package com.dotridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dotridge.bean.LoginBean;
import com.dotridge.bean.ManageUserProfileBean;

@Controller
public class HomeController 
{
	@RequestMapping(value="/getHomePage")
	public String getHomePage()
	{
		return "home";
	}
	
	@RequestMapping(value="/getLoginPage")
	public String getLoginPage(Model model)
	{
		model.addAttribute("loginBean", new LoginBean());
		return "login";
	}
	
	@RequestMapping(value="/login")
	public String doLogin(@ModelAttribute("loginBean")LoginBean loginBean)
	{
		System.out.println(loginBean.toString());
		String userName = loginBean.getUserId();
		if (userName != null && !userName.isEmpty()) 
		{
		   if (userName.equalsIgnoreCase("superadmin@gmail.com"))
		   {
			   return "getSuperAdminBoard";
		   }
		   else
		   {
			   return "home";
		   }
		}
		else
		{
			return "home";
		}
	}
	
	@RequestMapping(value="/getSignUpPage")
	public String getSignUpPage(Model model)
	{
		model.addAttribute("manageUserProfileBean",new ManageUserProfileBean());
		return "registration";
	}
	
	@RequestMapping(value="/registration")
	public String doSignUp(@ModelAttribute("manageUserProfileBean") ManageUserProfileBean manageUserProfileBean)
	{
		System.out.println(manageUserProfileBean.toString());
		//model.addAttribute("loginBean", new LoginBean());
		return "registartion";
	}
}
