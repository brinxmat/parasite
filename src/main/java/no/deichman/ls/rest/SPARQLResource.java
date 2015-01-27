/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.rest;

import com.hp.hpl.jena.rdf.model.Model;
import java.io.StringWriter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import no.deichman.ls.service.ServiceDefault;

/**
 *
 * @author sbd
 */
@Path("/sparql")
public class SPARQLResource {

    private static final ServiceDefault SERVICE = new ServiceDefault();

//    @GET
//    @Produces("application/rdf+xml")
//    public Response getSparqlHTML(@QueryParam("query") String query) {
//
//        if (query == null) {
//            return Response.ok()
//                    .link("http://localhost:8080/parasite/sparql", "self")
//                    .entity("WELCOME TO THE SPARQL ENDPOINT\n")
//                    .build();
//        } else {
//            if (queryOk(query)) {
//                return Response.ok().
//                        link("http://localhost:8080/parasite/sparql", "self")
//                        .entity("some rdf is going to get back here\n")
//                        .build();
//            } else {
//                return Response.
//                        status(Response.Status.BAD_REQUEST)
//                        .entity("Empty query-paramter is not allowed\n")
//                        .build();
//            }
//        }
//    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSparql(@QueryParam("query") String query) {
        StringWriter sw = new StringWriter();
        Model model = SERVICE.runQuery(query);
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

    private boolean queryOk(String query) {

        if (query != null && query.length() > 0) {
            return true;
        }
        return false;
    }
}
