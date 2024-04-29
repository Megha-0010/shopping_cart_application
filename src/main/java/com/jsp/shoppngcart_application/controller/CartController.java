package com.jsp.shoppngcart_application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingCart_Application.dto.Cart;
import com.jsp.shoppingCart_Application.dto.Customer;
import com.jsp.shoppingCart_Application.dto.Items;
import com.jsp.shppingcart_application.dao.CartDao;

@Controller
public class CartController {
	@Autowired
	public CartDao dao;

	@RequestMapping("/viewitemsfromcart")
	public ModelAndView viewItemsFromCart(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerinfo");
		Cart cart = customer.getCart();
		List<Items> items = cart.getItem();

		ModelAndView mav = new ModelAndView();
		mav.addObject("itemslist", items);
		mav.addObject("totalprice",cart.getTotalPrice());
		mav.setViewName("displayallitemsfromcart");
		return mav;

	}

}
