package no.deichman.ls.consumer;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

import no.deichman.ls.consumer.KohaConsumerDefault;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class TestKohaConsumerDefault {

    
	@Test
	public void test() throws IOException {
		
		KohaConsumerDefault getJson = new KohaConsumerDefault();
		
        assertNotNull ("Class GetJson is implemented", getJson.getClass () );
	    
        
        testConnect () ;
	}
	
	public void testConnect () throws IOException {

		URL url = this.getClass () .getResource ( "/testJsonConnect.json" ) ;
	    String expected = StringUtils.trim ( IOUtils.toString ( url, "UTF-8" ) ) ;
	    String actual = KohaConsumerDefault.connect("http://www.ntnu.no/ub/digital/document/ntnu203") ;
	    
        assertEquals ( "GetJson.connect", expected, actual );

	}

}
