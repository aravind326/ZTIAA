package com.ztiaa.web;

import java.security.Principal;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ztiaa.token.Token;
import com.ztiaa.token.TokenService;
import com.ztiaa.user.User;
import com.ztiaa.user.UserService;

/**
 * ManagerController.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	UserService userService;
	
	@Autowired
	TokenService localTokenService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getUsersForManager(Principal principal) {
		ModelAndView model = new ModelAndView();
		model.setViewName("manager/user_list");
		String managerID = principal.getName();
		String managerDN = userService.getUserDetails(managerID).getUserDN();
		model.addObject("userList", userService.getUsersForManager(managerDN));

		return model;
	}

	@RequestMapping(value = "/users/{userid}", method = RequestMethod.GET)
	public ModelAndView getUsersDetails(@PathVariable(name = "userid") String userid) {
		ModelAndView model = new ModelAndView();
		model.setViewName("manager/user_activate");

		model.addObject("user", userService.getUserDetails(userid));

		return model;
	}

	@RequestMapping(value = "/users/{userid}/activate", method = RequestMethod.GET)
	public ModelAndView activateUser(@PathVariable(name = "userid") String userid) {
		ModelAndView model = new ModelAndView();
		model.setViewName("manager/user_activate");

		model.addObject("user", userService.getUserDetails(userid));

		return model;
	}

	@RequestMapping(value = "/users/{userid}/activate", method = RequestMethod.POST)
	public ModelAndView validateUserToken(@RequestParam(name = "userToken") String userToken,
			@RequestParam(name = "userID") String userID) {
		ModelAndView model = new ModelAndView();
		model.setViewName("manager/user_activate");
		
		User user = userService.getUserDetails(userID);
		
		Token validatedToken = localTokenService.validateInitialToken(user.getUserEnterpriseID(), userToken);
		
		if (validatedToken.getTokenValid()) {
			model.addObject("user", user);
			model.addObject("activationOTP", localTokenService.generateActivationOTP(user.getUserEnterpriseID()));
			model.addObject("verificationPass", true);
		} else {
			model.addObject("user", user);
			model.addObject("verificationPass", false);
			if (validatedToken.getTokenLocked()) {
				model.addObject("tokenLocked", true);
				model.addObject("tokenLockedTill",
						new SimpleDateFormat("MM-dd-yyyy hh:mm:ss z").format(validatedToken.getTokenLockedTill()));
			}
		}

		return model;
	}

}
