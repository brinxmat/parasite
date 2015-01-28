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

    @GET
    @Produces({MediaType.APPLICATION_JSON+";qs=0.1"})
    public Response getSparql(@QueryParam("query") String query) {
        try {
            Model model = SERVICE.runQuery(query);
            if (!model.isEmpty()) {
                StringWriter sw = new StringWriter();
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
        } catch (Exception e) {
            if(query == null) {
                query = "";
            }
            return Response.
                    status(Response.Status.BAD_REQUEST)
                    .entity("\"" + query + "\"" + " is not a valid query\n\nTry e.g.\nCONSTRUCT {?s ?p ?o } WHERE { ?s ?p ?o }\nas value for query-parameter \"query\"")
                    .build();
        }
    }
    
    @GET
    @Produces({MediaType.TEXT_PLAIN+";qs=0.9"})
    public Response getSparqlTurtle(@QueryParam("query") String query) {
        try {
            Model model = SERVICE.runQuery(query);
            if (!model.isEmpty()) {
                StringWriter sw = new StringWriter();
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
        } catch (Exception e) {
            if(query == null) {
                query = "";
            }
            return Response.
                    status(Response.Status.BAD_REQUEST)
                    .entity("\"" + query + "\"" + " is not a valid query\n\nTry e.g.\nCONSTRUCT {?s ?p ?o } WHERE { ?s ?p ?o }\nas value for query-parameter \"query\"")
                    .build();
        }
    }
}
