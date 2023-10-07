package br.unitins.resource;

import br.unitins.dto.MarcaDTO;
import br.unitins.service.MarcaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/marcas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaResource {

    @Inject
    MarcaService service;

    @POST
    public Response insert(MarcaDTO dto) {
       return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(MarcaDTO dto, @PathParam("id") Long id) {
        service.update(dto, id);
        return Response.noContent().build();
    }
    
    @GET
    public Response findAll() {
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }
    
    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findByNome(nome)).build();
    }
}
