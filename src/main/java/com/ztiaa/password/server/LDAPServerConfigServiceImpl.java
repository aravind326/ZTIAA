package com.ztiaa.password.server;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.DirContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztiaa.util.LDAPUtils;

/**
 * LDAPServerConfigServiceImpl.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Service("ldapServerConfigService")
public class LDAPServerConfigServiceImpl implements ServerConfigService {

	@Autowired
	LDAPServerRepository ldapServerRepository;

	@Autowired
	ServerMapper serverMapper;

	@Override
	public List<Server> getServerList() {
		List<Server> ldapServers = new ArrayList<Server>();
		for (LDAPServerEntity ldapServerEntity : ldapServerRepository.findAll()) {
			ldapServers.add(serverMapper.ldapServerEntityToLDAPServer(ldapServerEntity));
		}
		return ldapServers;
	}

	@Override
	public Server getServerDetails(Integer serverID) {
		LDAPServer server = serverMapper.ldapServerEntityToLDAPServer(ldapServerRepository.findById(serverID).get());
		return server;
	}

	@Override
	public Server createOrUpdateServer(Server server) {
		LDAPServerEntity createdServer = ldapServerRepository.save(serverMapper.ldapServerToLDAPServerEntity((LDAPServer)server));
		return serverMapper.ldapServerEntityToLDAPServer(createdServer);
	}

	@Override
	public Server getEnterpriseServerDetails() {
		LDAPServer server = serverMapper.ldapServerEntityToLDAPServer(ldapServerRepository.findByEnterpriseServerFlagTrue());
		return server;
	}

	@Override
	public Boolean checkConnection(Server server) {
		if (!(server instanceof LDAPServer)) {
			return false;
		}
		try {
			DirContext ctx = LDAPUtils.getConnection((LDAPServer) server);
			ctx.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
