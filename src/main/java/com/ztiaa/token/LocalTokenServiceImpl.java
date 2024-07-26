package com.ztiaa.token;

import java.security.SecureRandom;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztiaa.notification.NotificationService;
import com.ztiaa.user.UserService;

/**
 * LocalTokenServiceImpl.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Service("localTokenServiceImpl")
class LocalTokenServiceImpl implements TokenService {

	private static final String INITIAL_TOKEN_TYPE = "Initial";
	private static final Integer INITIAL_TOKEN_LENGTH = 6;
	private static final Integer INITIAL_TOKEN_VALIDITY_DAYS = 10;
	private static final Integer INITIAL_TOKEN_LOCKOUT_MINS = 30;

	private static final String ACTIVATION_OTP_TYPE = "Activation";
	private static final Integer ACTIVATION_OTP_LENGTH = 6;
	private static final Integer ACTIVATION_OTP_VALIDITY_MINS = 10;
	private static final Integer ACTIVATION_OTP_LOCKOUT_MINS = 30;

	@Autowired
	UserService userService;

	@Autowired
	TokenRepository localTokenRepository;

	@Autowired
	TokenMapper tokenMapper;
	
	@Autowired
	NotificationService notificationService;

	@Override
	public String generateInitialToken(String userID) {
		String token = generateAlphaNumericString(INITIAL_TOKEN_LENGTH);
		String activationID = generateAlphaNumericString(20);
		TokenEntity tokenEntity = new TokenEntity();
		tokenEntity.setToken(token);
		tokenEntity.setTokenType(INITIAL_TOKEN_TYPE);
		tokenEntity.setTokenActivationID(activationID);
		tokenEntity.setUserID(userID);
		tokenEntity.setTokenUsed(false);
		tokenEntity.setTokenExpiryTimestamp(Date.from(
				LocalDateTime.now().plusDays(INITIAL_TOKEN_VALIDITY_DAYS).atZone(ZoneId.systemDefault()).toInstant()));
		localTokenRepository.save(tokenEntity);
		notificationService.sendInitialNotification(userID, activationID, token);
		return token;
	}

	@Override
	public Token validateInitialToken(String userID, String token) {
		Boolean isValid = false;
		TokenEntity tokenEntity = localTokenRepository.findByUserIDAndTokenType(userID, INITIAL_TOKEN_TYPE);
		if (tokenEntity.getTokenLocked()) {
			if ((new Date()).before(tokenEntity.getTokenLockedTill())) {
				System.out.println("Token locked. Try again later.");
				Token responseToken = tokenMapper.tokenEnityToToken(tokenEntity);
				responseToken.setTokenValid(false);
				return responseToken;
			} else {
				tokenEntity.setTokenLocked(false);
				tokenEntity.setTokenInvalidCounter(0);
				tokenEntity.setTokenLockedTill(null);
			}
		}
		if (tokenEntity != null && token.equals(tokenEntity.getToken()) && !tokenEntity.getTokenUsed()
				&& (new Date()).before(tokenEntity.getTokenExpiryTimestamp())) {
			isValid = true;
			tokenEntity.setTokenUsed(true);
		} else {
			tokenEntity.setTokenInvalidCounter(tokenEntity.getTokenInvalidCounter() + 1);
			if (tokenEntity.getTokenInvalidCounter() == 3) {
				tokenEntity.setTokenLocked(true);
				tokenEntity.setTokenLockedTill(Date.from(LocalDateTime.now().plusMinutes(INITIAL_TOKEN_LOCKOUT_MINS)
						.atZone(ZoneId.systemDefault()).toInstant()));
			}
		}
		localTokenRepository.save(tokenEntity);
		Token responseToken = tokenMapper.tokenEnityToToken(tokenEntity);
		responseToken.setTokenValid(isValid);
		return responseToken;
	}

	@Override
	public String generateActivationOTP(String userID) {
		String otp = generateAlphaNumericString(ACTIVATION_OTP_LENGTH);
		TokenEntity tokenEntity = new TokenEntity();
		tokenEntity.setToken(otp);
		tokenEntity.setTokenType(ACTIVATION_OTP_TYPE);
		tokenEntity.setUserID(userID);
		tokenEntity.setTokenUsed(false);
		tokenEntity.setTokenExpiryTimestamp(Date.from(
				LocalDateTime.now().plusDays(ACTIVATION_OTP_VALIDITY_MINS).atZone(ZoneId.systemDefault()).toInstant()));
		localTokenRepository.save(tokenEntity);
		return otp;
	}

	@Override
	public Token validateActivationOTP(String userID, String token) {
		Boolean isValid = false;
		TokenEntity tokenEntity = localTokenRepository.findByUserIDAndTokenType(userID, ACTIVATION_OTP_TYPE);
		if (tokenEntity.getTokenLocked()) {
			if ((new Date()).before(tokenEntity.getTokenLockedTill())) {
				System.out.println("Token locked. Try again later.");
				Token responseToken = tokenMapper.tokenEnityToToken(tokenEntity);
				responseToken.setTokenValid(false);
				return responseToken;
			} else {
				tokenEntity.setTokenLocked(false);
				tokenEntity.setTokenInvalidCounter(0);
				tokenEntity.setTokenLockedTill(null);
			}
		}
		if (tokenEntity != null && token.equals(tokenEntity.getToken()) && !tokenEntity.getTokenUsed()
				&& (new Date()).before(tokenEntity.getTokenExpiryTimestamp())) {
			isValid = true;
		} else {
			tokenEntity.setTokenInvalidCounter(tokenEntity.getTokenInvalidCounter() + 1);
			if (tokenEntity.getTokenInvalidCounter() == 3) {
				tokenEntity.setTokenLocked(true);
				tokenEntity.setTokenLockedTill(Date.from(LocalDateTime.now().plusMinutes(ACTIVATION_OTP_LOCKOUT_MINS)
						.atZone(ZoneId.systemDefault()).toInstant()));
			}
		}
		localTokenRepository.save(tokenEntity);
		Token responseToken = tokenMapper.tokenEnityToToken(tokenEntity);
		responseToken.setTokenValid(isValid);
		return responseToken;
	}

	public void markUserActivated(String userID) {
		TokenEntity tokenEntity = localTokenRepository.findByUserIDAndTokenType(userID, ACTIVATION_OTP_TYPE);

		tokenEntity.setTokenUsed(true);
		System.out.println("Valid Token, setting as used");

		localTokenRepository.save(tokenEntity);
	}

	@Override
	public Boolean canActivateUser(String userID) {
		Boolean userCanActivate = false;
		TokenEntity initialTokenEntity = localTokenRepository.findByUserIDAndTokenType(userID, INITIAL_TOKEN_TYPE);
		TokenEntity activationTokenEntity = localTokenRepository.findByUserIDAndTokenType(userID, ACTIVATION_OTP_TYPE);
		if (initialTokenEntity != null && (!initialTokenEntity.getTokenUsed()
				|| (activationTokenEntity != null && !activationTokenEntity.getTokenUsed()))) {
			userCanActivate = true;
		}
		return userCanActivate;
	}

	@Override
	public Boolean doesUserHaveInitialToken(String userID) {
		Boolean tokenExists = false;
		TokenEntity tokenEntity = localTokenRepository.findByUserIDAndTokenType(userID, INITIAL_TOKEN_TYPE);
		if (tokenEntity != null) {
			tokenExists = true;
		}
		return tokenExists;
	}

	@Override
	public String getUserIDForActivationToken(String activationTokenID) {
		TokenEntity tokenEntity = localTokenRepository.findByTokenActivationID(activationTokenID);
		if (tokenEntity != null) {
			return tokenEntity.getUserID();
		}
		return null;
	}

	private String generateAlphaNumericString(Integer targetStringLength) {

		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		Random random = new SecureRandom();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()
				.toUpperCase();
		return generatedString;
	}

}
