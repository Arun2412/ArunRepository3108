package com.arun.killme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.killme.dao.CartDao;
import com.arun.killme.model.Cart;
import com.arun.killme.model.CartItem;

@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	CartDao cartDao;
	public Cart getCartById(int cartId) 
	{
		return cartDao.getCartById(cartId);
	}
	public void addToCart(Cart cart)
	{
		cartDao.addToCart(cart);
	}
	public double getGrandTotal(int cartId)
	{
		return cartDao.getGrandTotal(cartId);
	}	
}
