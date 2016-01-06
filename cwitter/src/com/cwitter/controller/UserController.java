package com.cwitter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cwitter.constants.CwitterConstants;
import com.cwitter.dto.User;
import com.cwitter.service.UserLocalService;
import com.cwitter.service.UserLocalServiceImpl;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userLocalService")
	private UserLocalService userLocalService;

	@RequestMapping("/")
	public ModelAndView defaultPage()
	{
		return new ModelAndView("index","welcomeMessage",CwitterConstants.welcomeMessage);
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage()
	{
	  return new ModelAndView("login","user", new User());	
	}
	
	@RequestMapping("/register")
	public ModelAndView registrationPage()
	{
	  return new ModelAndView("register","user", new User());	
	}
	
	@RequestMapping("/showMyTweets")
	public ModelAndView showMyTweets(HttpServletRequest request)
	{
		String id = request.getParameter("userId");
		User user = new User();
		if(id !=null && id!="")
		{
		Long userId = Long.parseLong(id);
		user.setUserId(userId);
		}
		else{
			user.setUserId(1l);
		}
			  return new ModelAndView("showMyTweets","user",user);	
	}
	
	@RequestMapping(value="/registerAction", method = RequestMethod.POST)
	public ModelAndView registerAction(@ModelAttribute("user")User user, BindingResult result)
	{
		
		//UserLocalService userLocalService = new UserLocalServiceImpl();
		user = userLocalService.saveUser(user);
		return new ModelAndView("success", "registrationSuccess", CwitterConstants.registrationSuccess);
	}
	
	@RequestMapping(value="/loginAction", method = RequestMethod.POST)
	public ModelAndView loginAction(@ModelAttribute("user")User user, BindingResult result,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		//UserLocalService userLocalService = new UserLocalServiceImpl();
		user = userLocalService.getUser(user);
		if(user != null)
		{
				session.setAttribute("emailId", user.getEmailId());
				session.setAttribute("userId", user.getUserId());
		       return new ModelAndView("home", "user", user);
		}else{
			return new ModelAndView("login", "user", new User());
		}
	}
	
	@RequestMapping(value="/logoutAction", method = RequestMethod.GET)
	public ModelAndView logoutAction(@ModelAttribute("user")User user, BindingResult result,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("success","logoutSuccess", new String("Logout Success"));
	}
}
