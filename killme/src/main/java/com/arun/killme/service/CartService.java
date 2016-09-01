package com.arun.killme.service;

import java.util.List;

import com.arun.killme.model.Cart;
import com.arun.killme.model.CartItem;

public interface CartService 
{
	Cart getCartById (int cartId);
	void addToCart(Cart cart);
	double getGrandTotal(int cartId);
}
