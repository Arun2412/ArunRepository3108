package com.arun.killme.dao;

import java.util.List;

import com.arun.killme.model.Cart;
import com.arun.killme.model.CartItem;

public interface CartItemDao
{
	void addCartItem(CartItem cartItem);
	List<CartItem> viewCartItems(int cartId);
	void deleteCartItemById(int id);
}
