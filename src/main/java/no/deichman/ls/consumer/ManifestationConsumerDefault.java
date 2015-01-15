/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.consumer;

import com.owlike.genson.Genson;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;

/**
 *
 * @author sbd
 */
public class ManifestationConsumerDefault implements ManifestationConsumer {

    @Override
    public Manifestation getManifestationById(int manifestationId) {

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://192.168.50.12:8080/cgi-bin/koha/rest.pl");
        WebTarget resourceWebTarget = webTarget.path("biblio/" + manifestationId + "/items");

        Invocation.Builder invocationBuilder
                = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);

        Response response = invocationBuilder.get();
        System.out.println();
        //System.out.println(response.readEntity(String.class));

        if (response.getStatusInfo() == Response.Status.NOT_FOUND) {
            return null;
        } else {
            return mapResponseToManifestation(manifestationId, response);
        }
    }

    @Override
    public HashMap<Integer, Manifestation> getManifestationList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Manifestation> getManifestationsByWorkId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Manifestation mapResponseToManifestation(int id, Response response) {

        Genson genson = null;
        String r = response.readEntity(String.class);
        HashMap<Integer, Item> items = new HashMap<Integer, Item>();
        items = genson.deserialize(r, HashMap.class);

        Manifestation manifestation = new Manifestation(id);
        manifestation.setItems(items);
        
        return manifestation;
    }
}
