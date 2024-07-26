package com.ztiaa.password.server;

import java.util.List;

/**
 * ServerConfigService.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public interface ServerConfigService {
	
	public List<Server> getServerList();
	
	public Server getEnterpriseServerDetails();
	
	public Server getServerDetails(Integer serverID);
	
	public Server createOrUpdateServer(Server server);
	
	public Boolean checkConnection(Server server);

}
