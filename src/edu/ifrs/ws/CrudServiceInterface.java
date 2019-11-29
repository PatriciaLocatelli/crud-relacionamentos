package edu.ifrs.ws;

import java.util.List;

import javax.ejb.Remote;

import edu.ifrs.model.Client;

@Remote
public interface CrudServiceInterface {

	public Client create(String name, String email);

	public List<Client> read();

	public Client update(long id);

	public String delete(long id);

}
