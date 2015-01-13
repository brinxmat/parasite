package no.deichman.ls.parasite;

public class GetJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    public static String getData (String type) {
    	if ( type == "Test" ) {
    		return "{\"test\":\"Yes, it's a test\"}";
    	}
    	else {
        	return "Argument \"type\" with value \"" + type + "\" could not be parsed";
    	}
    }
}
