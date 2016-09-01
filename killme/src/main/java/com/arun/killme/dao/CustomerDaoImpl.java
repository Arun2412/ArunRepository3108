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
import com.arun.killme.model.Cart;
import com.arun.killme.model.Customer;
import com.arun.killme.model.CustomerOrder;
import com.arun.killme.model.UserRole;
@Repository
public class CustomerDaoImpl implements CustomerDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public void addCustomer(Customer customer) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		customer.setEnabled(true);
		session.save(customer);
		UserRole userRole = new UserRole();
		userRole.setAuthority("ROLE_USER");
		userRole.setId(customer.getId());
		session.save(userRole);
		Cart cart = new Cart();
		customer.setCart(cart);
		transaction.commit();
	}
	public List<Customer> viewCustomer() 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Customer> list = session.createCriteria(Customer.class).list();
		return list;		
	}
	public Customer getCustomerByName(String customer) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Customer activeUser =  (Customer) session.createCriteria(Customer.class)
	     .add(Restrictions.like("name", customer)).uniqueResult();
		return activeUser;
	}
	public Customer getCustomerById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Customer activeUser =  (Customer) session.createCriteria(Customer.class)
	     .add(Restrictions.like("id", id)).uniqueResult();
		return activeUser;
	}
	public void updateCustomer(int id,String address,String mobile)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String hql ="update Customer set address = '"+address+"' , mobile = '"+mobile+"' where id = '"+id+"'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		transaction.commit();
	}
	public int addOrder(CustomerOrder customerOrder)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(customerOrder);
		int orderId = customerOrder.getCustomerOrderId();
		System.out.println("id = "+orderId);
		transaction.commit();
		return orderId;
	}
	 

}
