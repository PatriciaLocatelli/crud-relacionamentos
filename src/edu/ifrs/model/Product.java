package edu.ifrs.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;

	@ManyToMany	
	@JsonBackReference
	private Set<Client> clients;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return name;
	}

	public void setNumber(String name) {
		this.name = name;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	public void addClient(Client client) {
		this.clients.add(client);
	}
	
}