package nayzek.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import nayzek.hibernate.dao.Dao;
import nayzek.hibernate.models.Customer;

public class CustomerService {

	private final Dao<Customer> dao;

	@Autowired
	public CustomerService(Dao<Customer> dao) {
		this.dao = dao;
	}

	public void create(Customer object) {
		dao.create(object);
	}

	public Customer getById(int id) {
		return dao.read(id);
	}

	public void update(Customer customer) {
		dao.update(customer);
	}

	public void delete(Customer customer) {
		dao.delete(customer);
	}

	public List<Customer> getAll() {
		return dao.findAll();
	}

}