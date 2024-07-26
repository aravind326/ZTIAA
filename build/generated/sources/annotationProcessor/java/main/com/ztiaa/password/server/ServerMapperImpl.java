package com.ztiaa.password.server;

import java.sql.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-25T20:17:32-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.1.1.jar, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ServerMapperImpl implements ServerMapper {

    @Override
    public LDAPServerEntity ldapServerToLDAPServerEntity(LDAPServer ldapServer) {
        if ( ldapServer == null ) {
            return null;
        }

        LDAPServerEntity lDAPServerEntity = new LDAPServerEntity();

        lDAPServerEntity.setServerID( ldapServer.getServerID() );
        lDAPServerEntity.setServerName( ldapServer.getServerName() );
        lDAPServerEntity.setHost( ldapServer.getHost() );
        lDAPServerEntity.setPort( ldapServer.getPort() );
        lDAPServerEntity.setBindDN( ldapServer.getBindDN() );
        lDAPServerEntity.setBindPassword( ldapServer.getBindPassword() );
        lDAPServerEntity.setSearchBase( ldapServer.getSearchBase() );
        lDAPServerEntity.setUserObject( ldapServer.getUserObject() );
        lDAPServerEntity.setPasswordAttribute( ldapServer.getPasswordAttribute() );
        lDAPServerEntity.setUniqueIDAttribute( ldapServer.getUniqueIDAttribute() );
        lDAPServerEntity.setCreatedDate( ldapServer.getCreatedDate() );
        lDAPServerEntity.setUpdatedDate( ldapServer.getUpdatedDate() );
        lDAPServerEntity.setEnabled( ldapServer.getEnabled() );

        return lDAPServerEntity;
    }

    @Override
    public LDAPServer ldapServerEntityToLDAPServer(LDAPServerEntity ldapServerEntity) {
        if ( ldapServerEntity == null ) {
            return null;
        }

        Integer serverID = null;
        String serverName = null;
        Date createdDate = null;
        Date updatedDate = null;
        Boolean enabled = null;
        String uniqueIDAttribute = null;
        String passwordAttribute = null;
        String host = null;
        Integer port = null;
        String bindDN = null;
        String bindPassword = null;
        String searchBase = null;
        String userObject = null;

        serverID = ldapServerEntity.getServerID();
        serverName = ldapServerEntity.getServerName();
        createdDate = ldapServerEntity.getCreatedDate();
        updatedDate = ldapServerEntity.getUpdatedDate();
        enabled = ldapServerEntity.getEnabled();
        uniqueIDAttribute = ldapServerEntity.getUniqueIDAttribute();
        passwordAttribute = ldapServerEntity.getPasswordAttribute();
        host = ldapServerEntity.getHost();
        port = ldapServerEntity.getPort();
        bindDN = ldapServerEntity.getBindDN();
        bindPassword = ldapServerEntity.getBindPassword();
        searchBase = ldapServerEntity.getSearchBase();
        userObject = ldapServerEntity.getUserObject();

        LDAPServer lDAPServer = new LDAPServer( serverID, serverName, createdDate, updatedDate, uniqueIDAttribute, passwordAttribute, enabled, host, port, bindDN, bindPassword, searchBase, userObject );

        return lDAPServer;
    }

    @Override
    public SCIMServerEntity scimServerToSCIMServerEntity(SCIMServer scimServer) {
        if ( scimServer == null ) {
            return null;
        }

        SCIMServerEntity sCIMServerEntity = new SCIMServerEntity();

        sCIMServerEntity.setServerID( scimServer.getServerID() );
        sCIMServerEntity.setServerName( scimServer.getServerName() );
        sCIMServerEntity.setScimAPIEndpoint( scimServer.getScimAPIEndpoint() );
        sCIMServerEntity.setUniqueIDAttribute( scimServer.getUniqueIDAttribute() );
        sCIMServerEntity.setAuthToken( scimServer.getAuthToken() );
        sCIMServerEntity.setPasswordAttribute( scimServer.getPasswordAttribute() );
        sCIMServerEntity.setCreatedDate( scimServer.getCreatedDate() );
        sCIMServerEntity.setUpdatedDate( scimServer.getUpdatedDate() );
        sCIMServerEntity.setEnabled( scimServer.getEnabled() );

        return sCIMServerEntity;
    }

    @Override
    public SCIMServer scimServerEntityToSCIMServer(SCIMServerEntity scimServerEntity) {
        if ( scimServerEntity == null ) {
            return null;
        }

        Integer serverID = null;
        String serverName = null;
        Date createdDate = null;
        Date updatedDate = null;
        Boolean enabled = null;
        String uniqueIDAttribute = null;
        String passwordAttribute = null;
        String scimAPIEndpoint = null;
        String authToken = null;

        serverID = scimServerEntity.getServerID();
        serverName = scimServerEntity.getServerName();
        createdDate = scimServerEntity.getCreatedDate();
        updatedDate = scimServerEntity.getUpdatedDate();
        enabled = scimServerEntity.getEnabled();
        uniqueIDAttribute = scimServerEntity.getUniqueIDAttribute();
        passwordAttribute = scimServerEntity.getPasswordAttribute();
        scimAPIEndpoint = scimServerEntity.getScimAPIEndpoint();
        authToken = scimServerEntity.getAuthToken();

        SCIMServer sCIMServer = new SCIMServer( serverID, serverName, createdDate, updatedDate, uniqueIDAttribute, passwordAttribute, enabled, scimAPIEndpoint, authToken );

        return sCIMServer;
    }
}
