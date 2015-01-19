package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;

public interface DataDeichmanSPARQLAdapter {

	Model getAllWorks(String type, int limit, int offset);
	
	
}
