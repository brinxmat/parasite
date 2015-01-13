package no.deichman.ls.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

import no.deichman.ls.domain.Work;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/work")
public class WorkResource {

    /**
     * Method processing HTTP GET requests, producing "text/turtle" MIME media
     * type.
     *
     * @return String that will be send back as a response of type
     * "text/turtle".
     */

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Map<Integer, Work> getWorkList() {
        Map<Integer, Work> list = new HashMap<Integer, Work>();
        Work workItem1 = new Work(1, "Work1", "Author1", 22.20);
        list.put(workItem1.getId(), workItem1);
        Work workItem2 = new Work(1, "Work1", "Author1", 22.20);
        list.put(workItem2.getId(), workItem2);

        return list;
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
    public String getWorkTurtle(@PathParam("id") String id) {
        return "Turtle: " + id;
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
    public String getHTML(@PathParam("id") String id) {
        return "<html><body>Requested work was: " + id + "</body></html>";
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
    public String getJSON(@PathParam("id") String id) {
        return "JSON: " + id;
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
    public String getRDFXML(@PathParam("id") String id) {
        return "RDF/XML: " + id;
    }

}
