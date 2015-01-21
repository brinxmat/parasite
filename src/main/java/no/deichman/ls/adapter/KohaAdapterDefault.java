/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;
import com.owlike.genson.Genson;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import no.deichman.ls.dao.ManifestationDAO;
import no.deichman.ls.mapper.ManifestationMapper;

/**
 *
 * @author sbd
 */
public class KohaAdapterDefault implements KohaAdapter {

    @Override
    public Model getItemsByManifestationId(String manifestationId) {

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://192.168.50.12:8080/cgi-bin/koha/rest.pl");
        WebTarget resourceWebTarget = webTarget.path("biblio/" + manifestationId + "/items");

        Invocation.Builder invocationBuilder
                = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);

        Response response = invocationBuilder.get();

        if (response.getStatusInfo() == Response.Status.NOT_FOUND) {
            return null;
        } else {
            return mapResponseToModel(manifestationId, response);
        }
    }

    private Model mapResponseToModel(String id, Response response) {

	Genson genson = new Genson();
        String r = response.readEntity(String.class);
        List<no.deichman.ls.dao.ItemDAO> itemListDAO = genson.deserialize(r, new com.owlike.genson.GenericType<List<no.deichman.ls.dao.ItemDAO>>(){});
	
        ManifestationDAO manifestationDAO = new ManifestationDAO(id);
        manifestationDAO.setItemListDAO(itemListDAO);
        
        return ManifestationMapper.mapManifestationDAOToModel(manifestationDAO);
    }

    @Override
    public Model getItemById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
