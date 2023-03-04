package nayzek.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import nayzek.hibernate.models.Customer;

@Component
public class CustomerDao implements Dao<Customer> {
	private final EntityManager entityManager;
	private static final String SELECT_CUSTOMER_INFO = "SELECT customer_name, customer_contacts FROM Customer";
	private static final String CUSTOMER_ID = "custId";
	private static final String SELECT_CUSTOMER_WITH_ID = "SELECT c FROM Customer c WHERE c.id >= :" + CUSTOMER_ID;

	@Autowired
	public CustomerDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Customer customer) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("Coudn't create customer with id" + customer.getId());
			entityManager.getTransaction().rollback();
		}
	}

	public Customer read(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		if (customer == null) {
			throw new EntityNotFoundException("Can't find Customer for ID " + id);
		}
		return customer;
	}

	public void update(Customer customer) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(customer);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("Coudn't update customer with id" + customer.getId());
			entityManager.getTransaction().rollback();
		}
	}

	public void delete(Customer customer) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(customer);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("Coudn't remove customer with id" + customer.getId());
			entityManager.getTransaction().rollback();
		}
	}

	public List<Customer> findAll() {
		List<Customer> customers = (List<Customer>) entityManager.createQuery(SELECT_CUSTOMER_INFO).getResultList();
		return customers;
	}

	public List<Customer> findCustomQuery(int id) {
		List<Customer> customers = (List<Customer>) entityManager.createQuery(SELECT_CUSTOMER_WITH_ID)
				.setParameter(CUSTOMER_ID, id).getResultList();
		return customers;
	}

}
