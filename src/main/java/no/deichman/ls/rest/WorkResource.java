package no.deichman.ls.rest;

import com.hp.hpl.jena.rdf.model.Model;
import java.io.StringWriter;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import no.deichman.ls.service.Service;
import no.deichman.ls.service.ServiceDefault;

@Path("/work")
public class WorkResource {

    private static final Service SERVICE = new ServiceDefault();

    @GET
    @Produces({MediaType.TEXT_PLAIN+";qs=0.9", "text/turtle;qs=0.8"})
    public Response getWorkListTurtle() {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveWorkList();
        if (!model.isEmpty()) {
            RDFDataMgr.write(sw, model, Lang.TURTLE);

            String data = sw.toString();

            return Response.ok()
                    .entity(data)
                    .build();
        } else {
            return Response.ok().
                    entity("{\"Message\":\"The query executed correctly, but the list is empty.\"}").
                    build();
        }
    }

    /**
     * Method processing HTTP GET requests, producing "application/json" MIME
     * media type.
     *
     * @return String that will be send back as a response of type
     * "application/json".
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON+";qs=0.1"})
    public Response getWorkList() {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveWorkList();
        if (!model.isEmpty()) {
            RDFDataMgr.write(sw, model, Lang.JSONLD);

            String data = sw.toString();

            return Response.ok()
                    .entity(data)
                    .build();
        } else {
            return Response.ok().
                    entity("{\"Message\":\"The query executed correctly, but the list is empty.\"}").
                    build();
        }
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
    @Produces({MediaType.APPLICATION_JSON})
    public Response getJSON(@PathParam("id") String id) {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveWorkById(id);
        if (!model.isEmpty()) {
            RDFDataMgr.write(sw, model, Lang.JSONLD);

            String data = sw.toString();

            return Response.ok()
                    .entity(data)
                    .build();
        } else {
            throw new NotFoundException();
        }
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.TEXT_PLAIN, "text/turtle"})
    public Response getWorkTurtle(@PathParam("id") String id) {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveWorkById(id);
        if (!model.isEmpty()) {
            RDFDataMgr.write(sw, model, Lang.TURTLE);

            String data = sw.toString();

            return Response.ok()
                    .entity(data)
                    .build();
        } else {
            throw new NotFoundException();
        }
    }

}
