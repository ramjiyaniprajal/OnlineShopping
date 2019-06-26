package com.ebusiness.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebusiness.onlineshopping.dao.CustomerDao;
import com.ebusiness.onlineshopping.model.Customer;
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public long save(Customer customer) {

		return customerDao.save(customer);

	}

	public Customer get(long id) {
		return customerDao.get(id);
	}

	public List<Customer> list() {
		return customerDao.list();
	}

	public void update(long id, Customer customer) {
		customerDao.update(id, customer);
	}

	public void delete(long id) {
		customerDao.delete(id);
	}

}
