package com.ztiaa.user;

/**
 * User.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public class User {

	private String userID;

	private String userEnterpriseID;

	private String userDN;

	private String displayName;

	private String email;

	private String manager;

	private String activationStatus;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserEnterpriseID() {
		return userEnterpriseID;
	}

	public void setUserEnterpriseID(String userEnterpriseID) {
		this.userEnterpriseID = userEnterpriseID;
	}

	public String getUserDN() {
		return userDN;
	}

	public void setUserDN(String userDN) {
		this.userDN = userDN;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}

	public User(String userID, String userEnterpriseID, String userDN, String displayName, String email, String manager,
			String activationStatus) {
		super();
		this.userID = userID;
		this.userEnterpriseID = userEnterpriseID;
		this.userDN = userDN;
		this.displayName = displayName;
		this.email = email;
		this.manager = manager;
		this.activationStatus = activationStatus;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userEnterpriseID=" + userEnterpriseID + ", userDN=" + userDN
				+ ", displayName=" + displayName + ", email=" + email + ", manager=" + manager + ", activationStatus="
				+ activationStatus + "]";
	}
	
	
	

}
