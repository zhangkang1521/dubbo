package org.zk.dubbo.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public interface UserService {

	@GET
	@Path("/{id : \\d+}")
	@Produces({MediaType.APPLICATION_JSON})
	User getUser(@PathParam("id") Integer id);
}
