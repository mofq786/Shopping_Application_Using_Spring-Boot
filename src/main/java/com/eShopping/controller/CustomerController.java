package com.eShopping.controller;

import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eShopping.DAO.CustomerDAO;
import com.eShopping.entity.CustomerDetails;
import com.eShopping.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public String home()
	{
		return "Home";
	}
	
	
	@GetMapping("/registrationpage")
	public String customerRegistrationPage(Model model) {
		CustomerDetails customerDetails = new CustomerDetails();
		model.addAttribute("customerobject", customerDetails);
		return "CustomerRegistration";
	}
	
	@GetMapping("/customerregistrationdetails")
	public String customerRegistrationDetails(CustomerDetails customerDetails) {
		 CustomerDetails details = customerDAO.insertCustomerObject(customerDetails);
		if (details.getCustomerid()!=0) {
			return "redirect:/loginpage";	
		} 
		else 
		{
			return null;
		}
	}
	
	@GetMapping("/loginpage")
	public String loginpage() {
		return "LogIn";
	}
	
	@GetMapping("/login")
	public String login(String emailid,String password,HttpServletRequest request,Model model) {
		CustomerDetails customerLogin = customerDAO.customerLogin(emailid, password);
		if (customerLogin!=null) {
			int otp = customerService.otpGenrater();
			HttpSession session = request.getSession();
			//session.setAttribute("genotp",otp);
			session.setAttribute("custId", customerLogin.getCustomerid());
			//model.addAttribute("otp", otp);
			return "redirect:/searchproducts";
		} else {
			return "redirect:/loginpage";
		}
	}
	
	@GetMapping("/uotp")
	public String otpValidation(int uotp,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		Integer otp = (Integer) session.getAttribute("genotp");
		if (otp==uotp) {
			return "AllProductDetails";
		} else {
			int rotp = customerService.otpGenrater();
			session.setAttribute("genotp", rotp);
			String custId = (String) session.getAttribute("custId");
			//model.addAttribute("msg","Invalid OTP Enter New OTP sended to the Email id");
			return "OTP";

		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
