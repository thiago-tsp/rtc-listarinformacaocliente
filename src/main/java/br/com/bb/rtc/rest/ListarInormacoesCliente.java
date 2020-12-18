package br.com.bb.rtc.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.opentracing.Traced;

import br.com.bb.rtc.dao.ClienteDao;
import br.com.bb.rtc.models.Cliente;

@RequestScoped
@Path("/v1/iformacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Traced
public class ListarInormacoesCliente {

    @Inject
    ClienteDao dao;

    @GET
    @Path("/{cdCliente}")
    @Operation(summary = "Busca Usuario por ID",
            description = "Retorna um usuario")
    @APIResponse(
            responseCode = "200",
            description = "Informações do cliente",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Cliente.class))})
    public Response obtemUsuarioPorId(final @PathParam("cdCliente") Integer cdCliente) throws Exception {
        return  Response.status(Response.Status.OK).entity(dao.listarInformacoes(cdCliente)).build();
    }
    
}