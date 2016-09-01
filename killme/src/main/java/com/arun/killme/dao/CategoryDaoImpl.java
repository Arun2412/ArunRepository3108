package com.arun.killme.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arun.killme.model.AddItem;

@Repository
public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
	SessionFactory sessionFactory;
	public List<AddItem> getElementByCategory(String category) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("daoImpl :"+category);
		List<AddItem> list = session.createCriteria(AddItem.class)
			     .add( Restrictions.like("category", category) )
			     .list();
		System.out.println("list created");
		return list;
	}
}
