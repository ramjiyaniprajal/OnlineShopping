package com.ebusiness.onlineshopping.dao;

import java.util.List;

import com.ebusiness.onlineshopping.model.Customer;

public interface CustomerDao {

	   long save(Customer customer);
	   Customer get(long id);
	   List<Customer> list();
	   void update(long id, Customer customer);
	   void delete(long id);
}
