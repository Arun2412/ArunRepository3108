package com.arun.killme.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arun.killme.model.AddItem;
import com.arun.killme.model.Cart;
import com.arun.killme.model.Customer;
import com.arun.killme.model.CustomerOrder;
import com.arun.killme.service.AddItemService;
import com.arun.killme.service.CategoryService;
import com.arun.killme.service.CustomerService;

@Controller
public class UserController 
{
	@Autowired
	CategoryService categoryService;
	@Autowired
	CustomerService customerService;
	@Autowired
	AddItemService addItemService;
	@RequestMapping("/toViewCategoryWise")
	public ModelAndView disCategoryWise(@RequestParam("category") String category) throws JsonGenerationException, JsonMappingException, IOException
	{
		List<AddItem> list = categoryService.getElementByCategory(category);
		ObjectMapper mapper = new ObjectMapper();
		String listJSON = mapper.writeValueAsString(list);
		System.out.println(listJSON);
		ModelAndView mv = new ModelAndView("CategoryView","CategoryKey",listJSON);
		mv.addObject("category", category);
		return mv;
	}
	@RequestMapping("/viewSingleItem")
	public ModelAndView disSingle(@RequestParam("id") String id)
	{
		AddItem addItem = addItemService.getItemById(Integer.parseInt(id));
		return new ModelAndView("SingleItem","addItemKey",addItem);
	}
	@RequestMapping("/toEditShipping")
	public ModelAndView disEditShipping(@RequestParam("id") String id)
	{
		Customer customer = customerService.getCustomerById(Integer.parseInt(id));
		return new ModelAndView("EditShipping","CustomerObj",customer);
	}
	@RequestMapping("/toSuccessShipping")
	public String disSuccessUpdateShipping(@RequestParam("id") String idUpdated,@RequestParam("address") String addressUpdated, @RequestParam("mobile") String mobileUpdated)
	{
		customerService.updateCustomer(Integer.parseInt(idUpdated),addressUpdated,mobileUpdated);
		return "redirect:/toPlaceOrder";
	}
	@RequestMapping("/toConfirmOrder")
	public ModelAndView disConfirmOrder()
	{
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Customer activeUser = customerService.getCustomerByName(activeUserName);
		Cart cart=activeUser.getCart();
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomer(activeUser);
		customerOrder.setCart(cart);
		int orderId = customerService.addOrder(customerOrder);
		return new ModelAndView("CheckCustomer","message","Congratulations ! Your Order Id is = '"+orderId+"'");
	}
}
