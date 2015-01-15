package no.deichman.ls.consumer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class JSONClientDefault implements JSONClient {

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
}
