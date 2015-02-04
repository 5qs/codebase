package com.katana.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {
	
	@RequestMapping("/commonLoginUser")
	public ModelAndView goToLogin(HttpServletRequest request)
	{
		String authFail = (String)request.getParameter("error");
		authFail = authFail != null && !authFail.isEmpty() ? authFail:"";
		return new ModelAndView("loginLanding","error",authFail);
	}
	
	@RequestMapping("/commonSuccessLogout")
	public ModelAndView goToLogoutPage()
	{
		return new ModelAndView("logoutSuccess");
	}
	
	@RequestMapping("/commonRegisterUser")
	public ModelAndView goToRegisterPage()
	{
		return new ModelAndView("registerUser");
	}
	
	@RequestMapping("/accessdenied")
	public ModelAndView goToAccessDeniedPage()
	{
		return new ModelAndView("accessdenied");
	}
	
	@RequestMapping("/userHomepage")
	public ModelAndView goToHomePage()
	{
		return new ModelAndView("homepage");
	}

}
