package com.ztiaa.password.server;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * ServerMapper.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.FIELD)
public interface ServerMapper {

	public LDAPServerEntity ldapServerToLDAPServerEntity(LDAPServer ldapServer);

	public LDAPServer ldapServerEntityToLDAPServer(LDAPServerEntity ldapServerEntity);

	public SCIMServerEntity scimServerToSCIMServerEntity(SCIMServer scimServer);

	public SCIMServer scimServerEntityToSCIMServer(SCIMServerEntity scimServerEntity);

}
