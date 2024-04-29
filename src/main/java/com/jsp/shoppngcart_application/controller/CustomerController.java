package com.jsp.shoppngcart_application.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingCart_Application.dto.Cart;
import com.jsp.shoppingCart_Application.dto.Customer;
import com.jsp.shppingcart_application.dao.CartDao;
import com.jsp.shppingcart_application.dao.CustomerDao;

@Controller
public class CustomerController {
	@Autowired
	public CustomerDao dao;
	
	@Autowired
	CartDao cartDao;
	
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer() {
		Customer customer= new Customer();
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("customerobj", customer);
		mav.setViewName("customerform");
		return mav;
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj") Customer customer) {
		Cart cart=new Cart();
		customer.setCart(cart);
		
		cartDao.saveCart(cart);
		dao.saveCustomer(customer);

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "saved successfully");
		mav.setViewName("customerloginform");
		return mav;
	}
	
	@RequestMapping("/validatelogincustomer")
	public ModelAndView customerLoginValidation(ServletRequest req,HttpSession session) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Customer c= dao.findCustomerByEmailAndPassword(email, password);
		if(c!=null) {
			ModelAndView mav= new ModelAndView();
			session.setAttribute("customerinfo", c);
			mav.setViewName("customeroption");
			return mav;
		}
		else {
			ModelAndView mav= new ModelAndView();
			mav.addObject("msg","invalid credentials");
			mav.setViewName("customerloginform");
			return mav;
		}
		
	}


}
