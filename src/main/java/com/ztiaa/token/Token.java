package com.ztiaa.token;

import java.util.Date;

/**
 * Token.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public class Token {

	private Integer tokenID;

	private String userID;

	private String tokenType;

	private Boolean tokenUsed;

	private Integer tokenInvalidCounter;

	private Boolean tokenLocked;

	private Date tokenLockedTill;

	private Date tokenExpiryTimestamp;
	
	private Boolean tokenValid;

	public String getUserID() {
		return userID;
	}

	public Integer getTokenID() {
		return tokenID;
	}

	public void setTokenID(Integer tokenID) {
		this.tokenID = tokenID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
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

	public Boolean getTokenValid() {
		return tokenValid;
	}

	public void setTokenValid(Boolean tokenValid) {
		this.tokenValid = tokenValid;
	}
	
	
}
