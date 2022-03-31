package com.example.api.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.User.User;
import com.example.api.service.UserService;


@Controller
public class UserController {
	@Autowired
   UserService userservice;	
	
  @GetMapping(value = "/registerUser")
  public String registerUser(Model model) { 
    model.addAttribute("user", new User());
    return "userform";
  }
	
  @PostMapping(value="/showUser")
  public String showUser(@Valid @ModelAttribute("user") User user,final BindingResult result, Model model) { 
    if(result.hasErrors()) {
      return "userform";
    }
    
    userservice.saveOrUpdate(user);
    model.addAttribute("user", user);
    return "user";
  }
  

	
	  @RequestMapping("/insert") public void index(@ModelAttribute("user") User user) {
		  System.out.println(user);
	   userservice.saveOrUpdate(user);
	  
	   }
	 
  
}
