package edu.ifrs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Client {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String email;

	@OneToMany(mappedBy = "client")
	@JsonManagedReference
	private Set<Phone> phones;
	
	@ManyToMany(mappedBy = "clients")
	@JsonManagedReference
	private Set<Product> products;

	public Client() {
		this.phones = new HashSet<>();
		this.products = new HashSet<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public void addPhone(Phone phone) {
		this.phones.add(phone);
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}

}