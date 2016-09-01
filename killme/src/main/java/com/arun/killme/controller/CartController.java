package com.arun.killme.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arun.killme.model.AddItem;
import com.arun.killme.model.Cart;
import com.arun.killme.model.CartItem;
import com.arun.killme.model.Customer;
import com.arun.killme.service.AddItemService;
import com.arun.killme.service.CartItemService;
import com.arun.killme.service.CartService;
import com.arun.killme.service.CustomerService;

@Controller
public class CartController
{
	@Autowired
	CustomerService customerService;
	@Autowired
	AddItemService addItemService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	CartService cartService;
	@RequestMapping(value ="/toAddToCart")
	public String addItem(@RequestParam("id") String itemId,ModelMap model)
	{
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Customer activeUser = customerService.getCustomerByName(activeUserName);
		Cart cart=activeUser.getCart();
		AddItem item=addItemService.getItemById(Integer.parseInt(itemId));
		CartItem cartItemk = new CartItem();
		cartItemk.setCart(cart);
		cartItemk.setAddItem(item);
		cartItemk.setQuantity(1);
		cartItemk.setTotalPrice(item.getPrice()*cartItemk.getQuantity());
		cartItemService.addCartItem(cartItemk);
		/*cart.setCustomer(activeUser);
		cart.setGrandTotal(cartItemk.getTotalPrice());
		cartService.addToCart(cart);*/
		model.addAttribute("message", "Your Product "+item.getName()+", added to cart successfully");
		return "redirect:/CheckCustomer";
	}
	@RequestMapping("/toViewCart")
	public ModelAndView disCart() throws JsonGenerationException, JsonMappingException, IOException
	{
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Customer activeUser = customerService.getCustomerByName(activeUserName);
		Cart cart=activeUser.getCart();
		int cartId = cart.getCartId();
		List<CartItem> list = cartItemService.viewCartItems(cartId);
		ObjectMapper mapper = new ObjectMapper();
		String listJSON = mapper.writeValueAsString(list);
		double grandTotal = cartService.getGrandTotal(cartId);
		ModelAndView modelAndView = new ModelAndView("ViewCart");
		modelAndView.addObject("CartItemsListKey",listJSON);
		modelAndView.addObject("grandTotal", grandTotal);
		return modelAndView;
	}
	@RequestMapping("/deleteCartItem")
	public String deleteCartItem(@RequestParam("id") int id)
	{
		cartItemService.deleteCartItemById(id);
		return "redirect:/toViewCart";
	}
	@RequestMapping("/toPlaceOrder")
	public ModelAndView disPlaceOrder()
	{
		String activeUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Customer activeUser = customerService.getCustomerByName(activeUserName);
		Cart cart=activeUser.getCart();
		cart.setCustomer(activeUser);
		int cartId = cart.getCartId();
		cart.setGrandTotal(cartService.getGrandTotal(cartId));
		cartService.addToCart(cart);
		double grandTotal = cart.getGrandTotal();
		String shippingAddress = activeUser.getAddress();
		String mobile = activeUser.getMobile();
		int customerId = activeUser.getId();
		ModelAndView modelAndView = new ModelAndView("PlaceOrder");
		modelAndView.addObject("shippingAddress", shippingAddress);
		modelAndView.addObject("grandTotal", grandTotal);
		modelAndView.addObject("phoneNumber", mobile);
		modelAndView.addObject("customerId", customerId);
		return modelAndView;
	}
	
}
