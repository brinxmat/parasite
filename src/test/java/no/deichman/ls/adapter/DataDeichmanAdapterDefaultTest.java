package no.deichman.ls.adapter;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import no.deichman.ls.adapter.DataDeichmanAdapterDefault;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;

import com.hp.hpl.jena.rdf.model.Model;

public class DataDeichmanAdapterDefaultTest {

    @Test
    public void testNothing() throws FileNotFoundException {
        DataDeichmanAdapterDefault x = new DataDeichmanAdapterDefault();
        Model m = x.getWork("749919");
        assertNotNull(m);
    }

    @Test
    public void test() throws ConfigurationException, Error {
        DataDeichmanAdapterDefault x = new DataDeichmanAdapterDefault();
        Model m = x.getAllWorks("allWorks", 100, 200);
        assertNotNull(m);
    }

}
