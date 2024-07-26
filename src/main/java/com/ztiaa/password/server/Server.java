package com.ztiaa.password.server;

import java.sql.Date;

/**
 * Server.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public class Server {
	
	private Integer serverID;
	
	private String serverName;
	
	private Date createdDate;
	
	private Date updatedDate;

	private String uniqueIDAttribute;

	private String passwordAttribute;
	
	private Boolean enabled;
		
	protected Server(Integer serverID, String serverName, Date createdDate, Date updatedDate, String uniqueIDAttribute,
			String passwordAttribute, Boolean enabled) {
		super();
		this.serverID = serverID;
		this.serverName = serverName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.uniqueIDAttribute = uniqueIDAttribute;
		this.passwordAttribute = passwordAttribute;
		this.enabled = enabled;
	}

	public Integer getServerID() {
		return serverID;
	}

	public void setServerID(Integer serverID) {
		this.serverID = serverID;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getUniqueIDAttribute() {
		return uniqueIDAttribute;
	}

	public void setUniqueIDAttribute(String uniqueIDAttribute) {
		this.uniqueIDAttribute = uniqueIDAttribute;
	}

	public String getPasswordAttribute() {
		return passwordAttribute;
	}

	public void setPasswordAttribute(String passwordAttribute) {
		this.passwordAttribute = passwordAttribute;
	}

}
