/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;


import java.util.HashMap;
import java.io.*;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.lang.LangRDFXML;

import com.hp.hpl.jena.rdf.model.*;

import no.deichman.ls.domain.Work;

/**
 *
 * @author rtg
 */
public class DataDeichmanAdapterDefault implements DataDeichmanAdapter {
	
    private final String dataDeichmanURL = "http://data.deichman.no/resource/tnr_" ; // eg http://data.deichman.no/resource/tnr_749919
	private Model model = ModelFactory.createDefaultModel();
	private String url = null ;
    
	private void dereference (String url) throws FileNotFoundException {	  
		
		RDFDataMgr.read(this.model,url,Lang.RDFXML);
    }
    
    private void setURL (String id) {
    	
//    	TODO: Fix this nonsense
    	//corny, eh? :-/
//    	this.url = this.dataDeichmanURL + id;
    	this.url = "http://data.deichman.no/sparql?default-graph-uri=&query=describe+%3Chttp%3A%2F%2Fdata.deichman.no%2Fresource%2Ftnr_" + id + "%3E%0D%0A&format=application%2Frdf%2Bxml&timeout=0&debug=on";
    }

	@Override
	public HashMap<String, Work> getWorkList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model getWork(String id) throws FileNotFoundException {
    	setURL (id);
    	dereference (this.url);
        
    	return this.model;
	}
    
}
