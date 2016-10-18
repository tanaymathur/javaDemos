package com.barclays;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	Person p = new Person();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@Path("person")
	@GET
	@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Person getPersonDetails() {
		
		p.setAge(22);
		p.setName("Tanay");	
		return p;
	}

	@Path("addPerson")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Person addPersonDetails(Person p){
		
		System.out.println("inside post");
		System.out.println(p.getName());
		System.out.println(p.getAge());
		
		return p;
		
	}
	@GET
	@Path("test/{id}")
	@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getSpecificPerson(@PathParam("id") String id){
		
		System.out.println(id+"from Rest API");
		
		return Response.status(200).build();
		
	}
	
}
