package com.ztiaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * WebSecurityConfig.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	AuthenticationProvider ldapAuthenticationProvider;

	@Autowired
	AuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		System.out.println("**********************SECURITY FILTER - IGNORE**********************");
		return (web) -> web.ignoring().requestMatchers("/resources/**", "/WEB-INF/views/**");
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("**********************SECURITY FILTER**********************");
		http.cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
				.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/login").permitAll()
						.requestMatchers("/activate").permitAll()
						.requestMatchers("/resetpassword").permitAll()
						.requestMatchers("/error").permitAll()
						.requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN").anyRequest().authenticated())
				.formLogin((formLogin) -> formLogin.loginPage("/login").permitAll().failureUrl("/login?auth=fail")
						.usernameParameter("userLogin").passwordParameter("userPassword")
						.loginProcessingUrl("/loginURL").successHandler(customAuthenticationSuccessHandler))
				.logout((logout) -> logout.deleteCookies("remove").invalidateHttpSession(false).logoutUrl("/logout")
						.logoutSuccessUrl("/login"));
		return http.build();
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(ldapAuthenticationProvider);
		return authenticationManagerBuilder.build();
	}

//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		System.out.println("Checking password");
//		UserDetails user1 = User.withUsername("user1").password("{noop}user1Pass").roles("USER").build();
//		UserDetails user2 = User.withUsername("user2").password("{noop}user2Pass").roles("USER").build();
//		UserDetails admin = User.withUsername("admin").password("{noop}adminPass").roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user1, user2, admin);
//	}
}