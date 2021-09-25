package br.com.fdrtec.api.resources;

import javax.inject.Inject;
import javax.transaction.Transactional;
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

import br.com.fdrtec.api.entities.Peca;
import br.com.fdrtec.api.services.PecaService;

@Path("pecas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class PecaResource {
	
	@Inject
	private PecaService pecaService;
	
	@GET	
	public Response getAll() {
		return Response.ok(pecaService.getAll()).build();		
	}
	
	@POST	
	public Response persist(Peca peca) {
		pecaService.persist(peca);
		return Response.status(Response.Status.OK).build();
	}
	
	@PUT	
	public Response update(Peca peca) {
		pecaService.update(peca);
		return Response.status(Response.Status.OK).build();
	}
	
	
	@DELETE	
	@Path("/{id}")
	public Response remove(@PathParam("id") Long id) {
		pecaService.remove(id);
		return Response.status(Response.Status.OK).build();
	}
}
