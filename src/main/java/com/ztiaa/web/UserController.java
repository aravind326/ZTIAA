package com.ztiaa.web;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ztiaa.password.PasswordConfigService;
import com.ztiaa.token.Token;
import com.ztiaa.token.TokenService;
import com.ztiaa.user.User;
import com.ztiaa.user.UserService;

/**
 * UserController.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	TokenService localTokenService;

	@Autowired
	PasswordConfigService passwordConfigService;

	@RequestMapping(value = "activate", method = RequestMethod.GET)
	public ModelAndView getUsersDetails(@RequestParam(name = "id") String activationID) {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/user_landing");
		String userID = localTokenService.getUserIDForActivationToken(activationID);

		if (userID != null) {
			model.addObject("user", userService.getUserDetails(userID));
		} else {
			model.addObject("invalidToken", true);
		}

		return model;
	}

	@RequestMapping(value = "activate", method = RequestMethod.POST)
	public ModelAndView validateOTP(@RequestParam(name = "userid") String userid,
			@RequestParam(name = "activationOTP") String activationOTP) {
		ModelAndView model = new ModelAndView();
		User user = userService.getUserDetails(userid);
		model.addObject("passwordConfig", passwordConfigService.getPasswordConfig());
		
		Token validatedToken = localTokenService.validateActivationOTP(userid, activationOTP);

		if (validatedToken.getTokenValid()) {
			model.setViewName("user/user_pwd_reset");
			model.addObject("verificationPass", true);
		} else {
			model.setViewName("user/user_landing");
			model.addObject("verificationPass", false);
			if (validatedToken.getTokenLocked()) {
				model.addObject("tokenLocked", true);
				model.addObject("tokenLockedTill",
						new SimpleDateFormat("MM-dd-yyyy hh:mm:ss z").format(validatedToken.getTokenLockedTill()));
			}
		}
		model.addObject("user", user);

		return model;
	}

	@RequestMapping(value = "resetpassword", method = RequestMethod.POST)
	public ModelAndView setUserPassword(@RequestParam(name = "userid") String userid,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "confirmPassword") String confirmPassword) {
		ModelAndView model = new ModelAndView();
		model.addObject("passwordConfig", passwordConfigService.getPasswordConfig());
		if (!password.equalsIgnoreCase(confirmPassword)) {
			model.setViewName("user/user_pwd_reset");
			model.addObject("passwordMatch", false);
		} else if (passwordConfigService.validatePasswordAgainstConfig(userid, password)) {
			model.setViewName("user/user_activation_success");
			userService.updateUserPassword(userid, password);
		} else {
			model.setViewName("user/user_pwd_reset");
			model.addObject("passwordValid", false);
		}

		model.addObject("user", userService.getUserDetails(userid));

		return model;
	}

}
