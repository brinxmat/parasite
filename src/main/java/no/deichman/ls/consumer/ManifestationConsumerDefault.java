package no.deichman.ls.consumer;

import java.util.HashMap;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import no.deichman.ls.domain.Manifestation;

public class ManifestationConsumerDefault implements ManifestationConsumer {

	private final static String JSONAPI = "http://base.address.no/";
	private static Client client = null ;
	private static String response = null;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public void openConnection (String url) {
    //TODO: add filters for client and response

		client = ClientBuilder.newClient();
		
        response = client.target(url)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .get(String.class);

    }

	public String connect(String url) {
		// TODO Auto-generated method stub

		openConnection (url);
		return getResponse () ;
        
	}
	
	public String getResponse () {
		return response ;
	}

    @Override
    public HashMap<Integer, Manifestation> getManifestationList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Manifestation> getManifestationsByWorkId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Manifestation getManifestationById(int manifestationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
