package com.qds.learning.springboot.jersey.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.qds.learning.springboot.jersey.model.User;
import com.qds.learning.springboot.jersey.model.Users;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path("/users")
public class UserResource {

	private static Map<Integer, User> DB = new HashMap<>();

	@GET
	@Produces("application/json")
	public Users getAllUsers() {

		Users users = new Users();
		users.setUsers(new ArrayList<User>(DB.values()));
		return users;
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createUser(User user) throws URISyntaxException {
		if (user.getFirstName() == null || user.getLastName() == null) {
			return Response.status(400).entity("Please provide all mandatory inputs").build();
		}

		user.setId(DB.values().size() + 1);
		user.setUri("/user-management/" + user.getId());
		DB.put(user.getId(), user);
		return Response.status(201).contentLocation(new URI(user.getUri())).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getUserById(@PathParam("id") int id) throws URISyntaxException {
		User user = DB.get(id);

		if (user == null) {
			return Response.status(404).build();
		}

		return Response
				.status(200)
				.entity(user)
				.contentLocation(new URI("/user-management/" + id))
				.build();
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateUser(@PathParam("id") int id, User user) throws URISyntaxException {
		User temp = DB.get(id);

		if (user == null) {
			return Response.status(404).build();
		}

		temp.setFirstName(user.getFirstName());
		temp.setLastName(user.getLastName());
		DB.put(temp.getId(), temp);

		return Response.status(200).entity(temp).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int id) throws URISyntaxException {
		User user = DB.get(id);
		if (user != null) {
			DB.remove(user.getId());
			return Response.status(200).build();
		}
		return Response.status(404).build();
	}
	// Initialise DB

	static {
		User user1 = new User();
		user1.setId(1);
		user1.setFirstName("John");
		user1.setLastName("Wick");
		user1.setUri("/user-management/1");

		User user2 = new User();
		user2.setId(2);
		user2.setFirstName("Harry");
		user2.setLastName("Potter");
		user2.setUri("/user-management/2");

		DB.put(user1.getId(), user1);
		DB.put(user2.getId(), user2);
	}
}
