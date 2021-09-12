package br.com.fdrtec.api.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fdrtec.api.entities.Dica;
import br.com.fdrtec.api.services.DicaService;

@Path("dicas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DicaResource {
	
	@Inject
	private DicaService dicaService;
	
	@GET
	public Response getAll() {
		return Response.ok(dicaService.getAll()).build();
	}
	
	@POST	
	public Response persist(Dica dica) {
		dicaService.persist(dica);
		return Response.ok(Response.Status.OK).build();
	}
	
	@PUT	
	public Response update(Dica dica) {
		dicaService.update(dica);
		return Response.ok(Response.Status.OK).build();
	}	
	
	@DELETE	
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id ) {
		dicaService.remove(id);
		return Response.ok(Response.Status.OK).build();
	}

}
