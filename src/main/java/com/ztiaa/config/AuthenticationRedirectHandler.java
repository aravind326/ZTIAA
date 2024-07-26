package com.ztiaa.config;

import java.io.IOException;

import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * AuthenticationRedirectHandler.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Component
public class AuthenticationRedirectHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String targetUrl = "/manager/";

		Iterator<? extends GrantedAuthority> roles = authentication.getAuthorities().iterator();
		while (roles.hasNext()) {
			if (roles.next().getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
				targetUrl = "/admin/";
			}
		}
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

}
