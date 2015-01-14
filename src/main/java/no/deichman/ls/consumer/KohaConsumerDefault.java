package no.deichman.ls.consumer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class KohaConsumerDefault {

	private final static String JSONAPI = "http://base.address.no/";
	private static Client client = null ;
	private static String response = null;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public static void openConnection (String url) {
    //TODO: add filters for client and response

		client = ClientBuilder.newClient();
		
        response = client.target(url)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .get(String.class);

    }

	public static String connect(String url) {
		// TODO Auto-generated method stub

		openConnection (url);
		return getResponse () ;
        
	}
	
	public static String getResponse () {
		return response ;
	}
}
