package com.katana.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.katana.mongodb.service.UserService;
import com.katana.web.domain.NewUser;

@Controller
public class SubmitUserController {
	
 @Autowired	
 private UserService userService;
 
 @RequestMapping(value="/commonsubmitUser",method=RequestMethod.POST)
 public String submitForm(NewUser user , BindingResult result, HttpServletRequest request)
 
 {
	 if (result.hasErrors())
	 {
		 return "registerUser";
	 }
	 
	 return "registerUser";
 }
	

}
