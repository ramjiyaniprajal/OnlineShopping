package com.ebusiness.onlineshopping.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebusiness.onlineshopping.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public long save(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		return customer.getId();
	}

	public Customer get(long id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Transactional
	public List<Customer> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Transactional
	public void update(long id, Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer2 = session.byId(Customer.class).load(id);
		customer2.setFname(customer.getFname());
		customer2.setLname(customer.getLname());
		customer2.setEmailAddress(customer.getEmailAddress());
		customer2.setBirthDate(customer.getBirthDate());
		session.flush();

	}

	@Transactional
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.byId(Customer.class).load(id);
		session.delete(customer);
	}

}
