package com.app.scdl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


public class SCDLController {
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title","Home-Smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("title","About-Smart Contact Manager");
		return "about";
	}

	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title","Register-Smart Contact Manager");
		model.addAttribute("user" ,new User());
		return "signup";
	}
	//handler for registering user
	@RequestMapping(value="/do_register",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user")User user, @RequestParam(value="agreement",defaultValue="true") boolean agreement,Model model,HttpSession session)
	{
		try {
	
		
		if(!agreement) {
			System.out.println("You have not agreed the terms and conditions");
			throw new Exception("You have not agreed the terms and conditions");
		}
		user.setRole("Role_User");
		user.setEnabled(true);
		user.setImageUrl("default.png");
		
		System.out.println("Agreement " +agreement);
		System.out.println("USER " +user);
		
		User result=this.userRepo.save(user);
		
		model.addAttribute("user",result);
		session.setAttribute("message",new Message("Successfully Registerd!!","alert-success"));
		
		return "signup";
		
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message",new Message("something Went wrong!!"+e.getMessage(),"alert-danger"));
		
		return "signup";
		}
	}

}
