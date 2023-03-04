package nayzek.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "customer_name")
	private String name;
	@Column(name = "customer_contacts")
	private int contacts;

	public Customer() {
	}

	public Customer(int id, String name, int contacts) {
		this.id = id;
		this.name = name;
		this.contacts = contacts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContacts() {
		return contacts;
	}

	public void setContacts(int contacts) {
		this.contacts = contacts;
	}

}