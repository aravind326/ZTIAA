package com.ztiaa.token;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * TokenEntity.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Entity(name = "TOKEN")
public class TokenEntity {

	@Id
	@GeneratedValue
	@Column(name = "TOKEN_ID")
	private Integer tokenID;

	@Column(name = "TOKEN_ACTIVATIONID")
	private String tokenActivationID;

	@Column(name = "TOKEN_USERID")
	private String userID;

	@Column(name = "TOKEN_VALUE")
	private String token;

	@Column(name = "TOKEN_TYPE")
	private String tokenType;

	@Column(name = "TOKEN_USED")
	private Boolean tokenUsed = false;

	@Column(name = "TOKEN_INVALID_COUNTER")
	private Integer tokenInvalidCounter = 0;

	@Column(name = "TOKEN_LOCKED")
	private Boolean tokenLocked = false;

	@Column(name = "TOKEN_LOCKEDTILL")
	private Date tokenLockedTill;

	@Column(name = "TOKEN_EXPIRY")
	private Date tokenExpiryTimestamp;

	public String getUserID() {
		return userID;
	}

	public Integer getTokenID() {
		return tokenID;
	}

	public void setTokenID(Integer tokenID) {
		this.tokenID = tokenID;
	}

	public String getTokenActivationID() {
		return tokenActivationID;
	}

	public void setTokenActivationID(String tokenActivationID) {
		this.tokenActivationID = tokenActivationID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	

	public Boolean getTokenUsed() {
		return tokenUsed;
	}

	public void setTokenUsed(Boolean tokenUsed) {
		this.tokenUsed = tokenUsed;
	}
	

	public Integer getTokenInvalidCounter() {
		return tokenInvalidCounter;
	}

	public void setTokenInvalidCounter(Integer tokenInvalidCounter) {
		this.tokenInvalidCounter = tokenInvalidCounter;
	}

	public Boolean getTokenLocked() {
		return tokenLocked;
	}

	public void setTokenLocked(Boolean tokenLocked) {
		this.tokenLocked = tokenLocked;
	}

	public Date getTokenLockedTill() {
		return tokenLockedTill;
	}

	public void setTokenLockedTill(Date tokenLockedTill) {
		this.tokenLockedTill = tokenLockedTill;
	}

	public Date getTokenExpiryTimestamp() {
		return tokenExpiryTimestamp;
	}

	public void setTokenExpiryTimestamp(Date tokenExpiryTimestamp) {
		this.tokenExpiryTimestamp = tokenExpiryTimestamp;
	}
}
