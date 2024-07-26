package com.ztiaa.web;

import java.util.Enumeration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/**
 * ErrorController.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Controller
@ControllerAdvice
public class ErrorController {

	@ExceptionHandler(Exception.class)
    @RequestMapping(value = "error", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
		System.out.println("*********************ERROR***********************");
        
        ModelAndView model = new ModelAndView();
		model.setViewName("layout/error");
        String errorMsg = "";
        
        int httpErrorCode = getErrorCode(httpRequest);
        
        System.out.println(httpErrorCode);

        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            } default: {
                errorMsg = "Unknown Error.";
            }
        }
        model.addObject("errorMsg", errorMsg);
        return model;
    }
    
    private int getErrorCode(HttpServletRequest httpRequest) {
    	System.out.println("Getting error code");
    	Enumeration<String> attributes = httpRequest.getAttributeNames();
    	System.out.println(attributes);
    	while(attributes.hasMoreElements()) {
    		String attribute = attributes.nextElement();
    		System.out.println(attribute + "::" + httpRequest.getAttribute(attribute));
    	}
        return (Integer) httpRequest
          .getAttribute("jakarta.servlet.error.status_code");
    }
}
