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

import br.com.fdrtec.api.entities.Veiculo;
import br.com.fdrtec.api.services.VeiculoService;

@Path("veiculos")
public class VeiculoResource {

	@Inject
	private VeiculoService veiculoService;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok(veiculoService.getAll()).build();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response create(Veiculo veiculo) {
		veiculoService.create(veiculo);
        return Response.status(Response.Status.OK).build();
	}
	
	@PUT
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response update(Veiculo veiculo) {
		veiculoService.update(veiculo);
        return Response.status(Response.Status.OK).build();				
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		veiculoService.delete(id);		
		return Response.ok().build();
	}

}
