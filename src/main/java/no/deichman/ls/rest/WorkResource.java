package no.deichman.ls.rest;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.Consumes;

import javax.ws.rs.core.Response;

import no.deichman.ls.domain.Work;
import service.Service;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/work")
public class WorkResource {

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
    public Response getWorkList() {

        return Response.ok(SERVICE.retriveWorkList()).build();
    }

    /**
     * Method processing HTTP GET requests, producing "text/turtle" MIME media
     * type.
     *
     * @return String that will be send back as a response of type
     * "text/turtle".
     */
    @Path("/{id}")
    @GET
    @Produces("text/turtle;qs=0.1")
    public Response getWorkTurtle(@PathParam("id") String id) {
        return Response.ok("Turtle: " + id).build();
    }

    /**
     * Method processing HTTP GET requests, producing "text/html" MIME media
     * type.
     *
     * @return String that will be send back as a response of type "text/html".
     */
    @Path("/{id}")
    @GET
    @Produces("text/html;qs=2")
    public Response getHTML(@PathParam("id") String id) {
        return Response.ok("<html><body>Requested work was: " + id + "</body></html>").build();
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
        return Response.ok(SERVICE.retriveWorkById(idAsInt)).build();
    }

    /**
     * Method processing HTTP GET requests, producing "application/rdf+xml" MIME
     * media type.
     *
     * @return String that will be send back as a response of type
     * "application/rdf+xml".
     */
    @Path("/{id}")
    @GET
    @Produces("application/rdf+xml;qs=0.3")
    public Response getRDFXML(@PathParam("id") String id) {
        return Response.ok("RDF/XML: " + id).build();
    }

}
