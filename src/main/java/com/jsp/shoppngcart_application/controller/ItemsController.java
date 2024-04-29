package com.jsp.shoppngcart_application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingCart_Application.dto.Cart;
import com.jsp.shoppingCart_Application.dto.Customer;
import com.jsp.shoppingCart_Application.dto.Items;
import com.jsp.shoppingCart_Application.dto.Merchant;
import com.jsp.shoppingCart_Application.dto.Product;
import com.jsp.shppingcart_application.dao.CartDao;
import com.jsp.shppingcart_application.dao.ItemsDao;
import com.jsp.shppingcart_application.dao.ProductDao;

@Controller
public class ItemsController {
	
	@Autowired
	public ItemsDao idao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao cdao;
	
	
	@RequestMapping("/additems")
	public ModelAndView additems(@RequestParam("id")int pid) {
		Product p= pdao.findProductById(pid);
		Items i= new Items();
		i.setBrand(p.getBrand());
		i.setCategory(p.getCategory());
		i.setPrice(p.getPrice());
		i.setPid(p.getId());
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemsobj",i);
		mav.setViewName("itemsform");
		return mav;
	}
	@RequestMapping("/additemtocart")
	public ModelAndView addItemtoCart(@ModelAttribute("itemsobj") Items item,HttpSession session) {
		item.setPrice(item.getQuantity()*item.getPrice());
		
		Customer customer=(Customer) session.getAttribute("customerinfo");
		Cart cart=customer.getCart();
		cart.setName(customer.getName());
		
		List<Items> items= cart.getItem();
		if(items.size()>0) {
			items.add(item);
			cart.setItem(items);
			cart.setTotalPrice(cart.getTotalPrice()+item.getPrice());
			
		}else {
			List<Items> items1= cart.getItem();
			items1.add(item);
			
			cart.setTotalPrice(item.getPrice());
			cart.setItem(items1);
		}
		idao.saveItems(item);
		cdao.updateCart(cart);
		
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("redirect://fetchallproducts");
		
		return mav;
		
	}

}
