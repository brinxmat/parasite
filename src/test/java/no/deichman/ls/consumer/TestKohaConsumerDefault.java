package no.deichman.ls.parasite;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGetJson {

	@Test
	public void test() {
		
		GetJson getJson = new GetJson();
        assertNotNull ("Class GetJson is implemented", getJson.getClass () );
	    
        assertEquals ( "GetJson.loadData", "{\"test\":\"Yes, it's a test\"}",  GetJson.getData("Test"));
	}

}
