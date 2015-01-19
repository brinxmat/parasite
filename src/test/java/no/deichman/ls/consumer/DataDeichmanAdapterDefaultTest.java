package no.deichman.ls.consumer;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import no.deichman.ls.adapter.DataDeichmanAdapter;
import no.deichman.ls.adapter.DataDeichmanAdapterDefault;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.junit.Test;

import com.hp.hpl.jena.rdf.model.Model;

public class DataDeichmanAdapterDefaultTest {

	@Test
	public void test() throws FileNotFoundException {
		DataDeichmanAdapterDefault x = new DataDeichmanAdapterDefault();
		Model m = x.getWork("749919");
        RDFDataMgr.write(System.out, m, Lang.TRIG);

	}

}
