/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.ServiceDefault;

/**
 *
 * @author sbd
 */
@Path("/item")
class ItemResource {
    private static final ServiceDefault SERVICE = new ServiceDefault();

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getItemById(@PathParam("id") String id) {

        return Response.ok(SERVICE.retriveItemById(id)).build();
    }

}
