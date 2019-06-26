package com.ebusiness.onlineshopping.service;

import java.util.List;

import com.ebusiness.onlineshopping.model.Customer;

public interface CustomerService {
	
	   long save(Customer customer);
	   Customer get(long id);
	   List<Customer> list();
	   void update(long id, Customer customer);
	   void delete(long id);
}
