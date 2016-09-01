package com.arun.killme.dao;

import com.arun.killme.dao.CartItemDao;
import com.arun.killme.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CartItemDaoImpl implements CartItemDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	public void addCartItem(CartItem cartItem) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(cartItem);
		tx.commit();
	}
	public List<CartItem> viewCartItems(int cartId)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from CartItem where cartId="+cartId);
	    List<CartItem> list=(List<CartItem>) query.list();
		return list;
	}
	
	public void deleteCartItemById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		CartItem cartItem = session.get(CartItem.class, new Integer(id));
		session.delete(cartItem);
		transaction.commit();
	}
}
