/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.consumer;

import com.hp.hpl.jena.rdf.model.Model;
import org.apache.jena.riot.Lang;

/**
 *
 * @author sbd
 */
public interface RdfClient {
    
    public void loadData(String url);
    public Model getModel();
    public String printModel(Lang lang);
}
