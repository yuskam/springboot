package com.qds.learning.springboot.jersey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


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


	// Initialize DB

	static
	{
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
