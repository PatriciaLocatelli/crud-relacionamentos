package edu.ifrs.ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.ifrs.model.Client;

@Path("/v1")
@Stateless
public class CrudService {

	@PersistenceContext(unitName = "Crud")
	private EntityManager em;

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Client create(@FormParam("name") String name, @FormParam("email") String email) {
		Client client = new Client();
		client.setName(name);
		client.setEmail(email);
		em.persist(client);
		return client;
	}

	@GET
	@Path("/read")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> read() {
		// https://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/htm
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Client> criteria = builder.createQuery(Client.class);
		Root<Client> client = criteria.from(Client.class);
		criteria.select(client);
		return em.createQuery(criteria).getResultList();
	}

	@GET
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("id") long id) {
		Client client = em.find(Client.class, id);
		em.remove(client);
		StringBuilder json = new StringBuilder();
		json.append("{\"result\":\"true\", \"id\":\"" + id + "\"}");
		return json.toString();

	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Client update(@FormParam("id") long id, @FormParam("name") String name, @FormParam("email") String email) {
		Client client = em.find(Client.class, id);
		client.setName(name);
		client.setEmail(email);
		return em.merge(client);
	}

}