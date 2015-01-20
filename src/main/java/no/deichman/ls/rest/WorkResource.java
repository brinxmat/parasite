package no.deichman.ls.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import javax.ws.rs.core.Response;

import service.ServiceDefault;

@Path("/work")
public class WorkResource {

    private static final ServiceDefault SERVICE = new ServiceDefault();
    /**
     * Method processing HTTP GET requests, producing "application/json" MIME media
     * type.
     *
     * @return String that will be send back as a response of type
     * "application/json".
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getWorkList() {

        return Response.ok(SERVICE.retriveWorkList()).build();
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
        return Response.ok(SERVICE.retriveWorkById(id)).build();
    }


}
