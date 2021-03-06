package com.obeid.springrest.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obeid.springrest.crud.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		Session session= sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Customer getCustomer(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		// if id = null save else update
		session.saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Customer.class, customerId));
	}

}
