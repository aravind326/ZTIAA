package com.ztiaa.password.server;

import java.sql.Date;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * LDAPServerEntity.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Entity(name = "LDAP_SERVER")
public class LDAPServerEntity {

	@Id
	@GeneratedValue
	@Column(name = "SERVER_ID")
	private Integer serverID;

	@Column(name = "SERVER_NAME")
	private String serverName;

	@Column(name = "SERVER_HOST")
	private String host;

	@Column(name = "SERVER_PORT")
	private Integer port;

	@Column(name = "SERVER_BIND_DN")
	private String bindDN;

	@Column(name = "SERVER_BINDPWD")
	private String bindPassword;

	@Column(name = "SERVER_SEARCHBASE")
	private String searchBase;

	@Column(name = "SERVER_USEROBJECT")
	private String userObject;

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

	@Column(name = "IS_ENTERPRISE")
	private Boolean enterpriseServerFlag = false;

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

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getBindDN() {
		return bindDN;
	}

	public void setBindDN(String bindDN) {
		this.bindDN = bindDN;
	}

	public String getBindPassword() {
		return bindPassword;
	}

	public void setBindPassword(String bindPassword) {
		this.bindPassword = bindPassword;
	}


	public String getSearchBase() {
		return searchBase;
	}

	public void setSearchBase(String searchBase) {
		this.searchBase = searchBase;
	}

	public String getUserObject() {
		return userObject;
	}

	public void setUserObject(String userObject) {
		this.userObject = userObject;
	}

	public String getPasswordAttribute() {
		return passwordAttribute;
	}

	public void setPasswordAttribute(String passwordAttribute) {
		this.passwordAttribute = passwordAttribute;
	}

	public String getUniqueIDAttribute() {
		return uniqueIDAttribute;
	}

	public void setUniqueIDAttribute(String uniqueIDAttribute) {
		this.uniqueIDAttribute = uniqueIDAttribute;
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
