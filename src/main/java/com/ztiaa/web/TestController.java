package com.ztiaa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * TestController.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Controller
public class TestController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
        model.setViewName("index");
        
        return model;
	}

	@RequestMapping(value = "/index/{message}", method = RequestMethod.GET)
	public ModelAndView indexWithMessage(@PathVariable("message") String message) {
		ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("message", message);
        
        return model;
	}

}
