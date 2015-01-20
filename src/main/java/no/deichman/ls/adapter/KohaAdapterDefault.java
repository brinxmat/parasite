/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.owlike.genson.Genson;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import no.deichman.ls.dao.ItemDAO;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.mapper.ItemMapper;

/**
 *
 * @author sbd
 */
public class KohaAdapterDefault implements KohaAdapter {

    @Override
    public Manifestation getManifestationById(String manifestationId) {

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://192.168.50.12:8080/cgi-bin/koha/rest.pl");
        WebTarget resourceWebTarget = webTarget.path("biblio/" + manifestationId + "/items");

        Invocation.Builder invocationBuilder
                = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);

        Response response = invocationBuilder.get();

        if (response.getStatusInfo() == Response.Status.NOT_FOUND) {
            return null;
        } else {
            return mapResponseToManifestation(manifestationId, response);
        }
    }

    @Override
    public HashMap<String, Manifestation> getManifestationList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, Manifestation> getManifestationsByWorkId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Manifestation mapResponseToManifestation(String id, Response response) {

	Genson genson = new Genson();
        String r = response.readEntity(String.class);
        List<no.deichman.ls.dao.ItemDAO> itemListDAO = genson.deserialize(r, new com.owlike.genson.GenericType<List<no.deichman.ls.dao.ItemDAO>>(){});
	
        // TODO vurder å flytte dette inn i en ManifestationMapper.java
        ItemMapper itemMapper = new ItemMapper();
        HashMap<String, Item> itemList = new HashMap<String, Item>();
        for (ItemDAO i : itemListDAO ) {
            Item item = itemMapper.mapItemDAOToItem(i);
            itemList.put(item.getId(), item);
        }
        
        Manifestation manifestation = new Manifestation(id);
        manifestation.setItems(itemList);
        
        return manifestation;
    }
}
