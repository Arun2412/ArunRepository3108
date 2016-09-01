package com.arun.killme.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class CustomerOrder implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private int customerOrderId;
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	public int getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomserOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
