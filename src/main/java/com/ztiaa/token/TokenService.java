package com.ztiaa.token;

/**
 * TokenService.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public interface TokenService {

	public String generateInitialToken(String userID);

	public Token validateInitialToken(String userID, String token);

	public String generateActivationOTP(String userID);

	public Token validateActivationOTP(String userID, String token);
	
	public Boolean doesUserHaveInitialToken(String userID);
	
	public Boolean canActivateUser(String userID);
	
	public String getUserIDForActivationToken(String activationTOkenID);
	
	public void markUserActivated(String userID);

}
