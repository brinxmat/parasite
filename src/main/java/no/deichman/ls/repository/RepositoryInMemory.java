/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.repository;

import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Work;
import no.deichman.ls.mapper.ItemMapper;
import org.apache.jena.riot.RDFDataMgr;

/**
 *
 * @author sbd
 */
public class RepositoryInMemory implements Repository {
    
        private final Model model = ModelFactory.createDefaultModel();
        
        public void addItemToModel(Item item) {
            ItemMapper mapper = new ItemMapper();
            model.add(mapper.mapItemToModel(item));
        }
}
