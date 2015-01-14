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
import service.Service;

/**
 *
 * @author sbd
 */
@Path("/manifestation")
public class ManifestationResource {

    private static final Service SERVICE = new Service();

    /**
     * Method processing HTTP GET requests, producing "text/turtle" MIME media
     * type.
     *
     * @return String that will be send back as a response of type
     * "text/turtle".
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getManifestationList() {

        return Response.ok(SERVICE.retriveManifestationList()).build();
    }


    /**
     * Method processing HTTP GET requests, producing "application/json" MIME
     * media type.
     *
     * @return String that will be send back as a response of type
     * "application/json".
     */
    @Path("/{id}")
    @GET
    @Produces("application/json;qs=0.2")
    public Response getJSON(@PathParam("id") String id) {
        int idAsInt = Integer.parseInt(id);
        return Response.ok(SERVICE.retriveManifestationById(idAsInt)).build();
    }

}
