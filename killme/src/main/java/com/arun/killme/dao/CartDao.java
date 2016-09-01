package com.arun.killme.dao;

import com.arun.killme.model.Cart;

public interface CartDao
{
	Cart getCartById (int cartId);
	void addToCart(Cart cart);
	double getGrandTotal(int cartId);
}
