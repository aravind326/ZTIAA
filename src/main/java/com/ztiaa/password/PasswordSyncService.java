package com.ztiaa.password;

import com.ztiaa.password.server.Server;

/**
 * PasswordSyncService.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public interface PasswordSyncService {
	
	public void syncPassword(Server server, String userEnterpriseID, String password);

}
