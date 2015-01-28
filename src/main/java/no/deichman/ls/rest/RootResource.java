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
import no.deichman.ls.service.ServiceDefault;

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
                entity("Welcome to theparaSite!\n ").
                link("http://localhost:8080/parasite/", "self").
                link("http://localhost:8080/parasite/work", "works").
                link("http://localhost:8080/parasite/manifestation", "manifestations").
                build();
    }

    @GET
    @Produces({MediaType.TEXT_HTML})
    public Response getSlashHTML() {

        return Response.ok().
                entity(buildStaticHTML()).
                link("http://localhost:8080/parasite/", "self").
                link("http://localhost:8080/parasite/work", "works").
                link("http://localhost:8080/parasite/manifestation", "manifestations").
                build();
    }

    private static String buildStaticHTML() {
        return "<!DOCTYPE html>"
                + "<html>"
                + "    <head>"
                + "        <title>paraSite</title>"
                + "        <meta charset=\"UTF-8\">"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "        <style type=\"text/css\">"
                + "            .boundingbox {width: 400px;}"
                + "            textarea {width: 400px; height: 200px;}"
                + "            button {float: right}"
                + "            h1 {font-family: arial, helvetica, sun-sans, sans-cerif}"
                + "            h2 {font-family: arial, helvetica, sun-sans, sans-cerif}"
                + "        </style>"
                + "    </head>"
                + "    <body>"
                + "          <div class=\"boundingbox\">"
                + "             <h1>Welcome to the paraSite</h1>"
                + "             <form action=\"http://localhost:8080/parasite/sparql\" method=\"get\">"
                + "                 <h2>Submit a sparql query</h2>"
                + "                 <textarea name=\"query\">CONSTRUCT {?s ?p ?o} WHERE {?s ?p ?o} </textarea>"
                + "                 </br>"
                + "                 <button type=\"submit\">Submit</button>"
                + "             </form>"
                + "         </div>"
                + "    </body>"
                + "</html>";
    }
}
