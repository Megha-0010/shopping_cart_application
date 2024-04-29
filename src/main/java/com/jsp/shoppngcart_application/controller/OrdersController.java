package com.jsp.shoppngcart_application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingCart_Application.dto.Cart;
import com.jsp.shoppingCart_Application.dto.Customer;
import com.jsp.shoppingCart_Application.dto.Items;
import com.jsp.shoppingCart_Application.dto.Orders;
import com.jsp.shoppingCart_Application.dto.Product;
import com.jsp.shppingcart_application.dao.CartDao;
import com.jsp.shppingcart_application.dao.CustomerDao;
import com.jsp.shppingcart_application.dao.OrdersDao;
import com.jsp.shppingcart_application.dao.ProductDao;

@Controller
public class OrdersController {
	@Autowired
	OrdersDao dao;

	@Autowired
	CartDao cartdao;
	
	@Autowired
	CustomerDao cdao;

	@Autowired
	ProductDao pdao;

	
	
	@RequestMapping("/addorder")
	public ModelAndView addOrder() {
		Orders order = new Orders();
		ModelAndView mav = new ModelAndView();
		mav.addObject("ordersobj", order);
		mav.setViewName("ordersform");
		return mav;

	}

	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(@ModelAttribute("ordersobj") Orders o, HttpSession session) {
		Customer c = (Customer) session.getAttribute("customerinfo");
		Customer customer = cdao.findCustomerById(c.getId());
		Cart cart = customer.getCart();
		
		List<Items> items= cart.getItem();
		List<Items> cartitems= new ArrayList<Items>();
		List<Items> orderitems= new ArrayList<Items>();
		
		for(Items i: items) {
			Product p=pdao.findProductById(i.getPid());
			if(i.getQuantity()<p.getStock()) {
				orderitems.add(i);
				p.setStock(p.getStock()-i.getQuantity());
				pdao.updateProduct(p);
			}
			else {
				cartitems.add(i);
			}
		}
		
		double cartTotalPrice=0;
		double orderTotalPrice=0;
		
		for(Items i: items) {
			cartTotalPrice+=i.getPrice();
		}
		for(Items i: orderitems) {
			orderTotalPrice+=i.getPrice();
		}
		
		cart.setItem(cartitems);
		cart.setTotalPrice(cartTotalPrice);
		
		o.setItem(orderitems);
		o.setTotalPrice(orderTotalPrice);
		
		List<Orders> orders= c.getOrder();
		
		if(orders.size()>0) {
			orders.add(o);
			c.setOrder(orders);
		}
		
		else {
			List<Orders> orders1= new ArrayList<Orders>();
			orders1.add(o);
			c.setOrder(orders1);
		}
		cartdao.updateCart(cart);
		dao.saveOrders(o);
		cdao.updateCustomer(c);
		
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("orderbillobj","order placed successfully");
		mav.setViewName("customerbill");
		return mav;

		
		
		}

}
