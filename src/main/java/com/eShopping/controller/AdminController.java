package com.eShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eShopping.DAO.AdminDAO;
import com.eShopping.entity.Admin;

@Controller
public class AdminController {
	
	@Autowired
	AdminDAO adminDAO;
	
	@RequestMapping("/adminloginpage")
	public String adminLoginPage() {

		return "AdminLogin";
	}
	@RequestMapping("/adminlogin")
	public String adminLogin(String emailid,
			String password) {
		
		Admin adminLogin = adminDAO.adminLogin
				(emailid, password);
		if (adminLogin!=null) {
			
			return "AdminFunctions";
			
		} else {
			
			return "redirect:/adminloginpage";

		}
		
          
	}

}
