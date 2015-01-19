package no.deichman.ls.consumer;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hp.hpl.jena.rdf.model.Model;

import no.deichman.ls.adapter.DataDeichmanSPARQLAdapterDefault;

public class DataDeichmanSPARQLAdapterDefaultTest {

	@Test
	public void test() {
		DataDeichmanSPARQLAdapterDefault x = new DataDeichmanSPARQLAdapterDefault();
		Model m = x.getAllWorks("allWorks",100,200);
		assertNotNull(m);
		System.out.println(m.getGraph());
	}

}
