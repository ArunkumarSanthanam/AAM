package com.dmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmt.response.LoginResponse;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    private String login(HttpServletRequest request) {
    	return "login";
    }
    
    @RequestMapping(value = "/loginsubmit",method=RequestMethod.POST)
    private String home(HttpServletRequest  request,HttpServletResponse  response, @ModelAttribute LoginResponse loginResponse ){
    	System.out.println("called controller");
    	//TODO
    	return "adminhome"; 
    }
    
}
