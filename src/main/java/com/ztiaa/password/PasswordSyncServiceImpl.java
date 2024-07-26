package com.ztiaa.password;

import org.springframework.stereotype.Service;

import com.ztiaa.password.server.LDAPServer;
import com.ztiaa.password.server.SCIMServer;
import com.ztiaa.password.server.Server;
import com.ztiaa.util.LDAPUtils;
import com.ztiaa.util.SCIMUtils;

/**
 * PasswordSyncServiceImpl.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Service("passwordSyncService")
class PasswordSyncServiceImpl implements PasswordSyncService {

	@Override
	public void syncPassword(Server server, String userEnterpriseID, String password) {
		if (server instanceof LDAPServer) {
			LDAPUtils.updateUserPassword((LDAPServer) server, userEnterpriseID, password);
		} else if (server instanceof SCIMServer) {
			SCIMUtils.updateSCIMUserPassword((SCIMServer) server, userEnterpriseID, password);
		}
	}

}
