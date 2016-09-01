package com.arun.killme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.killme.dao.CartItemDao;
import com.arun.killme.model.Cart;
import com.arun.killme.model.CartItem;
@Service
public class CartItemServiceImpl implements CartItemService
{
	@Autowired
	CartItemDao cartItemDao;
	public void addCartItem(CartItem cartItem) 
	{
		cartItemDao.addCartItem(cartItem);		
	}
	public List<CartItem> viewCartItems(int cartId)
	{
		return cartItemDao.viewCartItems(cartId);
	}
	public void deleteCartItemById(int id) 
	{
		cartItemDao.deleteCartItemById(id);
	}
}
