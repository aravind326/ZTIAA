package com.ztiaa.util;

import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;

import com.unboundid.scim2.client.ScimService;
import com.unboundid.scim2.common.exceptions.ScimException;
import com.unboundid.scim2.common.filters.Filter;
import com.unboundid.scim2.common.messages.ListResponse;
import com.unboundid.scim2.common.types.UserResource;
import com.ztiaa.password.server.SCIMServer;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

/**
 * SCIMUtils.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public class SCIMUtils {

	public static Boolean checkSCIMConnection(SCIMServer server) {
		Boolean isSCIMConnectionValid = false;
		try {
			Client client = ClientBuilder.newClient().register(OAuth2ClientSupport.feature(server.getAuthToken()));
			WebTarget target = client.target(server.getScimAPIEndpoint());
			ScimService scimService = new ScimService(target);
			ListResponse<UserResource> searchResponse = scimService.searchRequest("Users").invoke(UserResource.class);
			if (searchResponse != null) {
				isSCIMConnectionValid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSCIMConnectionValid;
	}

	private static UserResource getSCIMUser(SCIMServer server, String userID) {
		UserResource scimUser = null;
		Client client = ClientBuilder.newClient().register(OAuth2ClientSupport.feature(server.getAuthToken()));
		WebTarget target = client.target(server.getScimAPIEndpoint());
		ScimService scimService = new ScimService(target);

		try {
			ListResponse<UserResource> searchResponse = scimService.searchRequest("Users")
					.filter(Filter.eq(server.getUniqueIDAttribute(), userID).toString()).page(1, 5).attributes("id")
					.invoke(UserResource.class);

			if (searchResponse.getTotalResults() > 0) {
				scimUser = searchResponse.getResources().get(0);
			}
		} catch (ScimException e) {
			e.printStackTrace();
		}
		return scimUser;
	}

	public static void updateSCIMUserPassword(SCIMServer server, String userID, String password) {
		UserResource scimUser = getSCIMUser(server, userID);
		Client client = ClientBuilder.newClient().register(OAuth2ClientSupport.feature(server.getAuthToken()));
		WebTarget target = client.target(server.getScimAPIEndpoint());
		ScimService scimService = new ScimService(target);

		try {
			scimUser.setPassword(password);
			System.out.println("Updating password for user " + userID);
			scimService.replaceRequest(scimUser).invoke();
		} catch (ScimException e) {
			e.printStackTrace();
		}
	}

}
