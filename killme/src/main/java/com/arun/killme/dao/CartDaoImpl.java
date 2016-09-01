package com.arun.killme.dao;

import com.arun.killme.dao.CartDao;
import com.arun.killme.model.Cart;
import com.arun.killme.model.CartItem;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	public Cart getCartById(int cartId) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		transaction.commit();
		return cart;
	}
	public void addToCart(Cart cart)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(cart);
		transaction.commit();
	}
	public double getGrandTotal(int cartId)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select sum(totalPrice) from CartItem where cartId = '"+cartId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		double grandTotal = (double) list.get(0);
		return grandTotal;
	}
}
