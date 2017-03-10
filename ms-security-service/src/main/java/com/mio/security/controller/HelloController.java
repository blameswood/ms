package com.mio.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	   @RequestMapping(value = "/hello", method = RequestMethod.GET)
	    @ResponseBody
	    public String hello() {
	        return "hello";
	    }

	    @RequestMapping("/home")
	    public String home() {
	        return "home";
	    }

	    @RequestMapping("/logout")
	    public String logout() {
	        return "logout";
	    }

	    @RequestMapping("/login")
	    public String login() {
	        return "login";
	    }
}
