package com.ztiaa.password.server;

import java.sql.Date;

/**
 * SCIMServer.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public class SCIMServer extends Server {

	private String scimAPIEndpoint;

	private String authToken;

	public String getScimAPIEndpoint() {
		return scimAPIEndpoint;
	}

	public void setScimAPIEndpoint(String scimAPIEndpoint) {
		this.scimAPIEndpoint = scimAPIEndpoint;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public SCIMServer(Integer serverID, String serverName, Date createdDate, Date updatedDate, String uniqueIDAttribute,
			String passwordAttribute, Boolean enabled, String scimAPIEndpoint, String authToken) {
		super(serverID, serverName, createdDate, updatedDate, uniqueIDAttribute, passwordAttribute, enabled);
		this.scimAPIEndpoint = scimAPIEndpoint;
		this.authToken = authToken;
	}

}
