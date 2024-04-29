package com.jsp.shoppngcart_application.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingCart_Application.dto.Merchant;
import com.jsp.shppingcart_application.dao.MerchantDao;

@Controller
public class MerchantController {
	@Autowired
	MerchantDao dao;

	@RequestMapping("/addmerchant")
	public ModelAndView addmerchant() {
		Merchant m = new Merchant();

		ModelAndView mav = new ModelAndView();
		mav.addObject("merchantobj", m);
		mav.setViewName("merchantform");
		return mav;
	}

	@RequestMapping("/savemerchant")
	public ModelAndView saveMerchant(@ModelAttribute("merchantobj") Merchant m) {
		dao.saveMerchant(m);

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "registered successfully");
		mav.setViewName("merchantloginform");
		return mav;
	}

	@RequestMapping("/validateloginmerchant")
	public ModelAndView merchantLoginValidation(ServletRequest req, HttpSession session) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Merchant m = dao.findMerchantByEmailAndPassword(email, password);
		if (m != null) {
			ModelAndView mav = new ModelAndView();
			session.setAttribute("merchantinfo", m);
			mav.setViewName("merchantoptions");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg", "invalid credentials");
			mav.setViewName("merchantloginform");
			return mav;
		}

	}

}
