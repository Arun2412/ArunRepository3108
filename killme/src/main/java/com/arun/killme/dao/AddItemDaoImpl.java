package com.arun.killme.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arun.killme.model.AddItem;
@Repository
public class AddItemDaoImpl implements AddItemDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addMyItem(AddItem addItem) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(addItem);
		transaction.commit();
	}
	public List<AddItem> viewItems() 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<AddItem> list = session.createCriteria(AddItem.class).list();
		return list;
	}
	public void deleteItem(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		AddItem addItem = session.get(AddItem.class, new Integer(id));
		session.delete(addItem);
		transaction.commit();
	}
	public void updateItem(AddItem addItem) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(addItem);
		transaction.commit();	
	}
	public AddItem getItemById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		AddItem addItem = session.get(AddItem.class, new Integer(id));
		return addItem;
	}
}
