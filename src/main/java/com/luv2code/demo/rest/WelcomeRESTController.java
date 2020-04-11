package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRESTController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String welcome() {
		return "Landing Page!!!";
	}
	
}
