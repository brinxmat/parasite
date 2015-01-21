/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryException;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;

import java.io.*;

import no.deichman.ls.preference.Preference;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.rdf.model.*;


/**
 *
 * @author rtg
 */
public class DataDeichmanAdapterDefault implements DataDeichmanAdapter {

    private final String dataDeichmanURL = "http://data.deichman.no/resource/tnr_"; // eg http://data.deichman.no/resource/tnr_749919
    private Model model = ModelFactory.createDefaultModel();
    private String url = null;

    private String endpointURI = "http://data.deichman.no/sparql";

    private void dereference(String url) throws FileNotFoundException {

        RDFDataMgr.read(this.model, url, Lang.RDFXML);
    }

    private void setURL(String id) {

//    	TODO: Fix this nonsense
        //corny, eh? :-/
//    	this.url = this.dataDeichmanURL + id;
        this.url = "http://data.deichman.no/sparql?default-graph-uri=&query=describe+%3Chttp%3A%2F%2Fdata.deichman.no%2Fresource%2Ftnr_" + id + "%3E%0D%0A&format=application%2Frdf%2Bxml&timeout=0&debug=on";
    }

    @Override
    public Model getWorkList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Model getWork(String id) throws FileNotFoundException {
        setURL(id);
        dereference(this.url);

        return this.model;
    }

    @Override
    public Model getAllWorks(String type, int limit, int offset) throws ConfigurationException, Error {
        // TODO Auto-generated method stub

        Query query = null;

        if (type.equals("allWorks")) {
            query = QueryFactory.create(Preference.getAllWorksQuery() + " LIMIT " + limit + " OFFSET " + offset);
        } else {
            throw new Error("Invalid query type");
        }

        Model model = ModelFactory.createDefaultModel();
        QueryExecution qexec = QueryExecutionFactory.sparqlService(endpointURI, query);

        try {
            model = qexec.execConstruct();
        } catch (QueryException qex) {
            System.out.println("Failed to connect with SPARQL service");
        } finally {
            qexec.close();
        }

        return model;
    }

    @Override
    public Model getManifestationList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model getManifestationsByWorkId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model getManifestationById(String manifestationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
