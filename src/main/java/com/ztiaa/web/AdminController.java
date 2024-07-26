package com.ztiaa.web;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ztiaa.password.PasswordConfig;
import com.ztiaa.password.PasswordConfigService;
import com.ztiaa.password.server.LDAPServer;
import com.ztiaa.password.server.SCIMServer;
import com.ztiaa.password.server.ServerConfigService;

import jakarta.servlet.http.HttpSession;

/**
 * AdminController.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	PasswordConfigService passwordConfigService;

	@Autowired
	ServerConfigService ldapServerConfigService;

	@Autowired
	ServerConfigService scimServerConfigService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getLandingPage(HttpSession session,
			@SessionAttribute(name = "adminid", required = false) String adminid) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_landing");

		Enumeration<String> sessionAttributeNames = session.getAttributeNames();
		while (sessionAttributeNames.hasMoreElements()) {
			String attributeName = sessionAttributeNames.nextElement();
			try {
				System.out.println(attributeName + "::" + session.getAttribute(attributeName));
			} catch (Exception e) {
			}
		}

		return model;
	}

	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public ModelAndView getPasswordConfig() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_password");

		model.addObject("passwordConfig", passwordConfigService.getPasswordConfig());
		return model;
	}

	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public ModelAndView updatePasswordConfig(@ModelAttribute("passwordConfig") PasswordConfig passwordConfig) {

		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_password");
		
		Integer minPasswordLength = passwordConfig.getMinLength();
		Integer minUpperCaseLength = passwordConfig.getMinUpperCaseChars();
		Integer minLowerCaseLength = passwordConfig.getMinLowerCaseChars();
		Integer minNumericLength = passwordConfig.getMinDigits();
		Integer minSplCharLength = passwordConfig.getMinSpecialChars();
		
		Integer totalIndividualMins = minUpperCaseLength + minLowerCaseLength + minNumericLength + minSplCharLength;
		
		if (minPasswordLength < totalIndividualMins) {
			model.addObject("success", false);
			model.addObject("message", "Minimum length cannot be less than individual character type minimums!");
			model.addObject("passwordConfig", passwordConfig);
		} else {
			passwordConfigService.updatePasswordConfig(passwordConfig);
			model.addObject("success", true);
			model.addObject("passwordConfig", passwordConfigService.getPasswordConfig());
		}
		

		return model;
	}

	@RequestMapping(value = "/ldap", method = RequestMethod.GET)
	public ModelAndView getLDAPServerList() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_server_list");

		model.addObject("serverType", "ldap");
		model.addObject("serverList", ldapServerConfigService.getServerList());

		return model;
	}

	@RequestMapping(value = "/ldap/{id}", method = RequestMethod.GET)
	public ModelAndView getLDAPServerDetails(@PathVariable(name = "id") Integer serverid) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_ldap_details");

		model.addObject("server", ldapServerConfigService.getServerDetails(serverid));
		return model;
	}

	@RequestMapping(value = "/ldap/add", method = RequestMethod.GET)
	public ModelAndView addNewLDAPServer() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_ldap_details");

		model.addObject("server",
				new LDAPServer(null, null, null, null, null, null, null, null, null, null, null, null, null));
		return model;
	}

	@RequestMapping(value = "/ldap", method = RequestMethod.POST)
	public ModelAndView createOrNewLDAPServer(@ModelAttribute("server") LDAPServer server,
			@RequestParam("action") String action) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_ldap_details");
		
		if ("Save".equalsIgnoreCase(action)) {
			try {
				LDAPServer createdServer = (LDAPServer) ldapServerConfigService.createOrUpdateServer(server);
				model.addObject("success", true);
				System.out.println(createdServer);
				model.addObject("server", createdServer);
			} catch (Exception e) {
				model.addObject("success", false);
				model.addObject("server", server);
			}
		} else if ("Test".equalsIgnoreCase(action)) {
			if (ldapServerConfigService.checkConnection(server)) {
				model.addObject("testSuccess", true);
			} else {
				model.addObject("testSuccess", false);
			}
			model.addObject("server", server);
		}
		return model;
	}

	@RequestMapping(value = "/scim", method = RequestMethod.GET)
	public ModelAndView getSCIMServerList() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_server_list");

		model.addObject("serverType", "scim");
		model.addObject("serverList", scimServerConfigService.getServerList());
		return model;
	}

	@RequestMapping(value = "/scim/{id}", method = RequestMethod.GET)
	public ModelAndView getSCIMServerDetails(@PathVariable(name = "id") Integer serverid) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_scim_details");

		model.addObject("server", scimServerConfigService.getServerDetails(serverid));
		return model;
	}

	@RequestMapping(value = "/scim/add", method = RequestMethod.GET)
	public ModelAndView addNewSCIMServer() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_scim_details");

		model.addObject("server", new SCIMServer(null, null, null, null, null, null, null, null, null));
		return model;
	}

	@RequestMapping(value = "/scim", method = RequestMethod.POST)
	public ModelAndView createOrNewSCIMServer(@ModelAttribute("server") SCIMServer server,
			@RequestParam("action") String action) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/admin_scim_details");

		if ("Save".equalsIgnoreCase(action)) {
			try {
				SCIMServer createdServer = (SCIMServer) scimServerConfigService.createOrUpdateServer(server);
				model.addObject("success", true);
				System.out.println(createdServer);
				model.addObject("server", createdServer);
			} catch (Exception e) {
				model.addObject("success", false);
				model.addObject("server", server);
			}
		} else if ("Test".equalsIgnoreCase(action)) {
			if (scimServerConfigService.checkConnection(server)) {
				model.addObject("testSuccess", true);
			} else {
				model.addObject("testSuccess", false);
			}
			model.addObject("server", server);
		}
		return model;
	}

}
