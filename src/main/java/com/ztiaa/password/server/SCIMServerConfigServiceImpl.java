package com.ztiaa.password.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztiaa.util.SCIMUtils;

/**
 * SCIMServerConfigServiceImpl.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Service("scimServerConfigService")
public class SCIMServerConfigServiceImpl implements ServerConfigService {

	@Autowired
	SCIMServerRepository scimServerRepository;

	@Autowired
	ServerMapper serverMapper;

	@Override
	public List<Server> getServerList() {
		List<Server> scimServers = new ArrayList<Server>();
		for (SCIMServerEntity scimServerEntity : scimServerRepository.findAll()) {
			scimServers.add(serverMapper.scimServerEntityToSCIMServer(scimServerEntity));
		}
		return scimServers;
	}

	@Override
	public Server getServerDetails(Integer serverID) {
		SCIMServer scimServer = serverMapper.scimServerEntityToSCIMServer(scimServerRepository.findById(serverID).get());
		return scimServer;
	}

	@Override
	public Server createOrUpdateServer(Server server) {
		SCIMServerEntity createdServer = scimServerRepository.save(serverMapper.scimServerToSCIMServerEntity((SCIMServer) server));
		return serverMapper.scimServerEntityToSCIMServer(createdServer);
	}

	@Override
	public Server getEnterpriseServerDetails() {
		// Unimplemented for SCIM Server
		return null;
	}

	@Override
	public Boolean checkConnection(Server server) {
		if (!(server instanceof SCIMServer)) {
			return false;
		}
		return SCIMUtils.checkSCIMConnection((SCIMServer) server);
	}

};