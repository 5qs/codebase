package com.katana.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {
	
	@RequestMapping("/loginUser")
	public ModelAndView goToLogin()
	{
		return new ModelAndView("loginLanding");
	}
	
	@RequestMapping("/successLogout")
	public ModelAndView goToPage()
	{
		return new ModelAndView("logoutSuccess");
	}
	@RequestMapping("/user/homepage")
	public ModelAndView goToHomePage()
	{
		return new ModelAndView("homepage");
	}

}
