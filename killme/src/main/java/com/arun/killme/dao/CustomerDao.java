package com.arun.killme.dao;

import java.util.List;

import com.arun.killme.model.AddItem;
import com.arun.killme.model.Customer;
import com.arun.killme.model.CustomerOrder;

public interface CustomerDao {
	
	void addCustomer(Customer customer);
	List<Customer> viewCustomer();
	Customer getCustomerByName(String customer);
	Customer getCustomerById(int id);
	void updateCustomer(int id, String address,String mobile);
	int addOrder(CustomerOrder customerOrder);
}
