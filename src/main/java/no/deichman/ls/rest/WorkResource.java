package no.deichman.ls.rest;

import com.hp.hpl.jena.rdf.model.Model;
import java.io.StringWriter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import service.ServiceDefault;

@Path("/work")
public class WorkResource {

    private static final ServiceDefault SERVICE = new ServiceDefault();

    /**
     * Method processing HTTP GET requests, producing "application/json" MIME
     * media type.
     *
     * @return String that will be send back as a response of type
     * "application/json".
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getWorkList() {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveWorkList();
        RDFDataMgr.write(sw, model, Lang.JSONLD);

        String data = sw.toString();

        return Response.ok()
                .entity(data)
                .build();
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
    //@Produces("application/json+ld;qs=0.2")
    public Response getJSON(@PathParam("id") String id) {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveWorkById(id);
        RDFDataMgr.write(sw, model, Lang.JSONLD);

        String data = sw.toString();

        return Response.ok()
                .entity(data)
                .build();
    }

}
