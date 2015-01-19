package no.deichman.ls.adapter;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryException;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class DataDeichmanSPARQLAdapterDefault implements DataDeichmanSPARQLAdapter {

	private String endpointURI = "http://data.deichman.no/sparql";
	private final String getAllWorks = "prefix fabio: <http://purl.org/spar/fabio/> CONSTRUCT {?uri a fabio:Work } WHERE {?uri a fabio:Work }";
	
	@Override
	public Model getAllWorks(String type, int limit, int offset) {
		// TODO Auto-generated method stub
		
		Query query = null ;

		if (type.equals("allWorks")) {
			query = QueryFactory.create(this.getAllWorks + " LIMIT " + limit + " OFFSET " + offset);
		}
		else {
			throw new Error("Invalid query type");
		}
		
		Model model = ModelFactory.createDefaultModel();
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpointURI, query);
		
		try {
			model = qexec.execConstruct() ;
		} catch (QueryException qex) {
            System.out.println("Failed to connect with SPARQL service");
		} finally {
			qexec.close() ;
		}
		
		return model;
	}

}
