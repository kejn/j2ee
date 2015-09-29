package edu.starterkit.web.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;

import edu.starterkit.service.BookService;

@Path("/rest")
public class BookRestService {
	
	@Inject
	private BookService bookService;
	
	@GET
	@Produces("application/json")
	@Path("findAllBooks")
	public Response findAllBooks() throws JSONException {
		JSONArray jsonArray = new JSONArray(bookService.findAllBooks());
		Response response = Response.status(200).entity(jsonArray.toString()).build(); 
		System.out.println(response.getEntity().toString());
		return response;
	}

}
