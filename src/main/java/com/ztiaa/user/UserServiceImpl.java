package com.ztiaa.user;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ztiaa.password.PasswordSyncService;
import com.ztiaa.password.server.LDAPServer;
import com.ztiaa.password.server.Server;
import com.ztiaa.password.server.ServerConfigService;
import com.ztiaa.token.TokenService;
import com.ztiaa.util.LDAPUtils;

/**
 * UserServiceImpl.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	ServerConfigService ldapServerConfigService;

	@Autowired
	ServerConfigService scimServerConfigService;

	@Autowired
	PasswordSyncService passwordSyncService;

	@Autowired
	TokenService localTokenService;

	@Override
	public List<User> getUsersForManager(String managerDN) {
		List<User> userList = new ArrayList<User>();
		try {
			LDAPServer enterpriseLDAPServer = (LDAPServer) ldapServerConfigService.getEnterpriseServerDetails();
			userList = LDAPUtils.getUsersForManager(enterpriseLDAPServer, managerDN);
			for (User user : userList) {
				user.setActivationStatus(
						localTokenService.canActivateUser(user.getUserEnterpriseID()) ? "Pending" : "Activated");
			}
		} catch (Exception e) {
			System.out.println("Could not get users for manager " + managerDN);
			throw e;
		}
		return userList;
	}

	@Override
	public User getUserDetails(String userID) {
		User user = null;
		try {
			LDAPServer enterpriseLDAPServer = (LDAPServer) ldapServerConfigService.getEnterpriseServerDetails();
			user = LDAPUtils.getUserDetails(enterpriseLDAPServer, userID);
			user.setActivationStatus(
					localTokenService.canActivateUser(user.getUserEnterpriseID()) ? "Pending" : "Activated");
		} catch (Exception e) {
			System.out.println("Could not details for user " + userID);
			throw e;
		}
		return user;
	}

	@Override
	public void updateUserPassword(String userID, String password) {
		localTokenService.markUserActivated(userID);
		for (Server ldapServer : ldapServerConfigService.getServerList()) {
			try {
				passwordSyncService.syncPassword(ldapServer, userID, password);
				System.out.println("Syncing password to server " + ldapServer.getServerName());
			} catch (Exception e) {
				System.out.println("Could not sync password to server " + ldapServer.getServerName());
			}
		}
		for (Server scimServer : scimServerConfigService.getServerList()) {
			try {
				passwordSyncService.syncPassword(scimServer, userID, password);
				System.out.println("Syncing password to server " + scimServer.getServerName());
			} catch (Exception e) {
				System.out.println("Could not sync password to server " + scimServer.getServerName());
			}
		}
	}

	@Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
	public void fetchLDAPUsers() {
		System.out.println("Fetching users");
		LDAPServer enterpriseLDAPServer = (LDAPServer) ldapServerConfigService.getEnterpriseServerDetails();
		List<User> userList = LDAPUtils.getAllUsers(enterpriseLDAPServer);

		for (User user : userList) {
			if (!localTokenService.doesUserHaveInitialToken(user.getUserEnterpriseID())) {
				localTokenService.generateInitialToken(user.getUserEnterpriseID());
				System.out.println("Generating token for user " + user.getUserEnterpriseID());
			}
		}
	}

}
