/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author sbd
 */
@Path("/item")
public class ItemResource {

    private static final Service SERVICE = new ServiceDefault();

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response getItemListTurtle() {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveItemList();

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

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getItemList() {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveItemList();

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

    @Path("/{id}")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response getItemByIdTurtle(@PathParam("id") String id) {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveItemById(id);
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

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getItemById(@PathParam("id") String id) {

        StringWriter sw = new StringWriter();
        Model model = SERVICE.retriveItemById(id);
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

}
