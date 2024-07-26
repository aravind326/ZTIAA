package com.ztiaa.password.server;

import java.sql.Date;

/**
 * LDAPServer.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public class LDAPServer extends Server {

	private String host;

	private Integer port;

	private String bindDN;

	private String bindPassword;

	private String searchBase;

	private String userObject;

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

	public LDAPServer(Integer serverID, String serverName, Date createdDate, Date updatedDate, String uniqueIDAttribute,
			String passwordAttribute, Boolean enabled, String host, Integer port, String bindDN, String bindPassword,
			String searchBase, String userObject) {
		super(serverID, serverName, createdDate, updatedDate, uniqueIDAttribute, passwordAttribute, enabled);
		this.host = host;
		this.port = port;
		this.bindDN = bindDN;
		this.bindPassword = bindPassword;
		this.searchBase = searchBase;
		this.userObject = userObject;
	}

	@Override
	public String toString() {
		return "LDAPServer [host=" + host + ", port=" + port + ", bindDN=" + bindDN + ", bindPassword=" + bindPassword
				+ ", searchBase=" + searchBase + ", userObject=" + userObject + ", getServerID()=" + getServerID()
				+ ", getServerName()=" + getServerName() + ", getCreatedDate()=" + getCreatedDate()
				+ ", getUpdatedDate()=" + getUpdatedDate() + ", isEnabled()=" + isEnabled() + ", getEnabled()="
				+ getEnabled() + ", getUniqueIDAttribute()=" + getUniqueIDAttribute() + ", getPasswordAttribute()="
				+ getPasswordAttribute() + "]";
	}
	
	
}
