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

}
