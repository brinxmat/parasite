package no.deichman.ls.preference;

import static org.junit.Assert.*;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;

public class PreferenceTest {

	@Test
	public void testGetBaseURI() throws ConfigurationException {
		String baseuri = Preference.getBaseURI();
		assertNotNull(baseuri);
	}

	@Test
	public void getAllWorksQuery() throws ConfigurationException {
		String getAllWorksQuery = Preference.getAllWorksQuery();
		assertNotNull(getAllWorksQuery);
	}
	@Test
	public void testGetSPARQLEndpointURI() throws ConfigurationException {
		String SPARQLEndpointURI = Preference.getSPARQLEndpointURI();
		assertNotNull(SPARQLEndpointURI);
	}
}
