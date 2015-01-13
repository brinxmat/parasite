package no.deichman.ls.parasite;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import no.deichman.ls.parasite.GetRdf;

import com.hp.hpl.jena.rdf.model.*;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.junit.Before;
import org.junit.Test;


public class TestGetRdf {
	String expected ;
	URL url ;
	GetRdf getRdf ;

	@Before
	
	public void initialise () throws IOException {
		
		url = this.getClass () .getResource ( "/test1.ttl" ) ;
	    expected = StringUtils.trim ( IOUtils.toString ( url, "UTF-8" ) ) ;
	    getRdf = new GetRdf () ;
	}
	
	@Test
	public void test () {
		
		assertNotNull ( "Class GetRdf is implemented", getRdf ) ;
		
	}
	
	@Test
	public void loadData_test () throws IOException {
		
	    getRdf.loadData ( url.toString () ) ;
		Model model = getRdf.getModel () ;
		ByteArrayOutputStream out = new ByteArrayOutputStream () ;
		Lang lang = Lang.TURTLE;
		RDFDataMgr.write ( out,model,lang ) ;
		String actual = StringUtils.trim ( out.toString ( "UTF-8" ) ) ;
		
		assertEquals ( "Test data load", actual, expected ) ;
		
	}
	
	@Test
	public void print_test () {
		
		getRdf.loadData ( url.toString () ) ;
		String actual = StringUtils.trim ( getRdf.print ( Lang.TURTLE ) ) ;
		
		assertEquals ( "Test data print", actual, expected ) ;
				

	}
	
}
