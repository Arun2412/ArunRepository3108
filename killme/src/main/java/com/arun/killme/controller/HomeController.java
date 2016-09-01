package com.arun.killme.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arun.killme.model.Customer;
import com.arun.killme.service.CustomerService;

@Controller
public class HomeController {
	@Autowired
	CustomerService customerService;
	//first mapping on startup
	@RequestMapping("/")
	public ModelAndView disHome()
	{
		return new ModelAndView("enterHome");
	}
	//mapping when killer clicks sign in
	@RequestMapping("/CheckCustomer")
	public ModelAndView checkCus(Principal principal)
	{
		return new ModelAndView("CheckCustomer","message","Hello "+principal.getName()+", Shop here");
	}
	@RequestMapping("/login")
	public String loginMethod()
	{
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		return "logout";
	}
	@RequestMapping("/CheckAdmin")
	public ModelAndView checkAd(Principal principal)
	{
		return new ModelAndView("CheckAdmin","message","Hello "+principal.getName()+", Here You Can Manage Your Operations");
	}
	@RequestMapping("/toSignIn")
	public ModelAndView disSignIn()
	{
		return new ModelAndView("enterSignIn");
	}
	//mapping when killer clicks sign up
	@RequestMapping("toSignUp")
	public ModelAndView disSignUp()
	{
		Customer customer = new Customer();
		return new ModelAndView("enterSignUp","CusKey",customer);
	}
	//Mapping when customer enter details and clicks register
	@RequestMapping("toSuccess")
	public ModelAndView disRegistered(@Valid@ModelAttribute("CusKey") Customer customer,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return new ModelAndView("enterSignUp");
		}
		customerService.addCustomer(customer);
		return new ModelAndView("login","message","welcome "+customer.getName()+", you can login now");
	}
	@RequestMapping("toContactUs")
	public ModelAndView disContactUs()
	{
		return new ModelAndView("ContactUs");
	}
	@RequestMapping("toAboutUs")
	public ModelAndView disAboutUs()
	{
		return new ModelAndView("AboutUs");
	}
}
