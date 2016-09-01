package com.arun.killme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.arun.killme.dao.CustomerDao;
import com.arun.killme.model.Customer;
import com.arun.killme.model.CustomerOrder;
@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerDao customerDao;
	public void addCustomer(Customer customer)
	{
		customerDao.addCustomer(customer);
	}
	public List<Customer> viewCustomer() {
		List<Customer> list = customerDao.viewCustomer();
		return list;
	}
	public Customer getCustomerByName(String customer)
	{
		return customerDao.getCustomerByName(customer);
	}
	public Customer getCustomerById(int id) 
	{
		return customerDao.getCustomerById(id);
	}
	public void updateCustomer(int id,String address,String mobile) 
	{
		customerDao.updateCustomer(id,address,mobile);
	}
	public int addOrder(CustomerOrder customerOrder)
	{
		return customerDao.addOrder(customerOrder);
	}
}
