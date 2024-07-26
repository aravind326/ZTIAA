package com.ztiaa.config;

import java.util.ArrayList;

import javax.naming.directory.DirContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.ztiaa.password.server.LDAPServer;
import com.ztiaa.password.server.ServerConfigService;
import com.ztiaa.util.LDAPUtils;

/**
 * LDAPAuthenticationProvider.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Component
public class LDAPAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	ServerConfigService ldapServerConfigService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();

		LDAPServer enterpriseLDAPServer = (LDAPServer) ldapServerConfigService.getEnterpriseServerDetails();
		com.ztiaa.user.User user = LDAPUtils.getUserDetails(enterpriseLDAPServer, username);

		if (user == null) {
			return null;
		}
		
		if (authenticateLDAP(enterpriseLDAPServer, user.getUserDN(), password)) {
			System.out.println("Authentication success!");
			ArrayList<GrantedAuthority> roles = new ArrayList<>();
			if(LDAPUtils.isUserAdmin(enterpriseLDAPServer, user.getUserDN())) {
				roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
			User authenticatedUser = new User(user.getUserEnterpriseID(), password, roles);
			if (username == "nologin") {
				return null;
			}
			return new UsernamePasswordAuthenticationToken(authenticatedUser.getUsername(),
					authenticatedUser.getPassword(), authenticatedUser.getAuthorities());
		}
		System.out.println("Authentication failed!");
		return null;
	}

	private boolean authenticateLDAP(LDAPServer enterpriseLDAPServer, String userDN, String password) {
		try {
			DirContext ctx = LDAPUtils.getConnection(enterpriseLDAPServer, userDN, password);
			ctx.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}