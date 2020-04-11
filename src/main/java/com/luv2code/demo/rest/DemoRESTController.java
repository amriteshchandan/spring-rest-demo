package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test", method = RequestMethod.GET)
public class DemoRESTController {
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello World!!!";
	}
	
}
