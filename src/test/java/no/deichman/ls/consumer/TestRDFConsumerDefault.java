package no.deichman.ls.consumer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import no.deichman.ls.consumer.RDFClientDefault;

import com.hp.hpl.jena.rdf.model.*;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.junit.Before;
import org.junit.Test;


public class TestRDFConsumerDefault {
	String expected ;
	URL url ;
	RDFClientDefault RDFConsumerDefault ;

	@Before
	
	public void initialise () throws IOException {
		
		url = this.getClass () .getResource ( "/test1.ttl" ) ;
	    expected = StringUtils.trim ( IOUtils.toString ( url, "UTF-8" ) ) ;
	    RDFConsumerDefault = new RDFClientDefault () ;
	}
	
	@Test
	public void test () {
		
		assertNotNull ( "Class RDFConsumerDefault is implemented", RDFConsumerDefault ) ;
		
	}
	
	@Test
	public void loadData_test () throws IOException {
		
	    RDFConsumerDefault.loadData ( url.toString () ) ;
		Model model = RDFConsumerDefault.getModel () ;
		ByteArrayOutputStream out = new ByteArrayOutputStream () ;
		Lang lang = Lang.TURTLE;
		RDFDataMgr.write ( out,model,lang ) ;
		String actual = StringUtils.trim ( out.toString ( "UTF-8" ) ) ;
		
		assertEquals ( "Test data load", actual, expected ) ;
		
	}
	
	@Test
	public void print_test () {
		
		RDFConsumerDefault.loadData ( url.toString () ) ;
		String actual = StringUtils.trim ( RDFConsumerDefault.printModel ( Lang.TURTLE ) ) ;
		
		assertEquals ( "Test data print", actual, expected ) ;
				

	}
	
}
