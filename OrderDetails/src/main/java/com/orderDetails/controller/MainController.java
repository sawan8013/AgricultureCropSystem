package com.orderDetails.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.orderDetails.model.AddDeliveryAddress;

@Controller
public class MainController {
	
	@RequestMapping("/addAddress")
	public String getform() {
		return "addAddress.jsp";
	}
	
	
	@RequestMapping(value="addPaymentDetails" , method = RequestMethod.POST)
	public String getPaymentDetails() {
		return "paymentDetails.jsp";
	}
	
	
	
	@RequestMapping(value="result.html" , method = RequestMethod.POST)
	public ModelAndView submitForm(@Valid @ModelAttribute("addDeliveryAddress") AddDeliveryAddress addDeliveryAddress, BindingResult result ) {
		
		  if(result.hasErrors()) 
		  {
			  ModelAndView m1 = new ModelAndView("register.jsp");
			  //System.out.print(result);
			  return m1; 
		  }
		 
		
		ModelAndView m1 = new ModelAndView("view.jsp");
		m1.addObject("msg", "Details Submitted by you. ");
		return m1;
	}
}
