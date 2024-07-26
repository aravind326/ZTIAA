package com.ztiaa.password.server;

import java.sql.Date;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * SCIMServerEntity.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Entity(name = "SCIM_SERVER")
public class SCIMServerEntity {

	@Id
	@GeneratedValue
	@Column(name = "SERVER_ID")
	private Integer serverID;

	@Column(name = "SERVER_NAME")
	private String serverName;

	@Column(name = "SERVER_SCIM_ENDPOINT")
	private String scimAPIEndpoint;

	@Column(name = "SERVER_AUTH_TOKEN")
	private String authToken;

	@Column(name = "SERVER_IDATTR")
	private String uniqueIDAttribute;

	@Column(name = "SERVER_PWDATTR")
	private String passwordAttribute;

	@CurrentTimestamp
	@Column(name = "SERVER_CREATED", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "SERVER_UPDATED")
	private Date updatedDate;

	@Column(name = "SERVER_ENABLED")
	private Boolean enabled;

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

	public String getScimAPIEndpoint() {
		return scimAPIEndpoint;
	}

	public void setScimAPIEndpoint(String scimAPIEndpoint) {
		this.scimAPIEndpoint = scimAPIEndpoint;
	}

	public String getUniqueIDAttribute() {
		return uniqueIDAttribute;
	}

	public void setUniqueIDAttribute(String uniqueIDAttribute) {
		this.uniqueIDAttribute = uniqueIDAttribute;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getPasswordAttribute() {
		return passwordAttribute;
	}

	public void setPasswordAttribute(String passwordAttribute) {
		this.passwordAttribute = passwordAttribute;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
