/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.ServiceDefault;

/**
 *
 * @author sbd
 */
@Path("/")
public class RootResource {

    private static final ServiceDefault SERVICE = new ServiceDefault();

    /**
     * Method processing HTTP GET requests, producing "text/turtle" MIME media
     * type.
     *
     * @return String that will be send back as a response of type
     * "text/turtle".
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSlashJSON() {

        return Response.ok().
                link("http://localhost:8080/parasite/", "self" ).
                link("http://localhost:8080/parasite/work", "works" ).
                link("http://localhost:8080/parasite/manifestation", "manifestations").
                build();
    }

    @GET
    @Produces({MediaType.TEXT_HTML})
    public Response getSlashHTML() {

        return Response.ok().
                link("http://localhost:8080/parasite/", "self" ).
                link("http://localhost:8080/parasite/work", "works" ).
                link("http://localhost:8080/parasite/manifestation", "manifestations").
                link("http://localhost:8080/parasite/sparql", "sparql" ).
                build();
    }

}
