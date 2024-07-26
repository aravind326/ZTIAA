package com.ztiaa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * AuthenticationController.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Controller
@RequestMapping("/")
public class AuthenticationController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLandingPage(@RequestParam(name="auth", required = false) String authStatus) {
		ModelAndView model = new ModelAndView();
		model.setViewName("auth/login");
		if ("fail".equalsIgnoreCase(authStatus) ) {
			model.addObject("authStatus", authStatus);
		}
		return model;
	}

}
