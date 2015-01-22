/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.repository;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Selector;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.vocabulary.RDFS;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

/**
 *
 * @author sbd
 */
public class RepositoryInMemory implements Repository {

    private final Model inMemoryModel = ModelFactory.createDefaultModel();

    private Model retrieveResource(String id) {
        Model result = ModelFactory.createDefaultModel();
        Resource resource = ResourceFactory.createResource(id);
        Selector selector = new SimpleSelector(resource, null, (RDFNode) null);
        result = inMemoryModel.query(selector);
        return result;
    }

    @Override
    public Model retrieveWork(String id) {
        return retrieveResource(id);
    }

    @Override
    public Model createWork(Model model) {
        inMemoryModel.add(model);
        return model;
    }

    @Override
    public void deleteWork(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model retrieveManifestation(String id) {
        return retrieveResource(id);
    }

    @Override
    public Model createManifestation(Model model) {
        inMemoryModel.add(model);
        return model;
    }

    @Override
    public void deleteManifestation(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model createItem(Model model) {
        inMemoryModel.add(model);
        return model;
    }

    @Override
    public Model retrieveItem(String id) {
        return retrieveResource(id);
    }

    @Override
    public void deleteItem(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model listWorks() {
        Model model = ModelFactory.createDefaultModel();
        return model;
    }

    @Override
    public Model listManifestations() {
        Model model = ModelFactory.createDefaultModel();
        return model;
    }

    @Override
    public Model listItems() {
        Model model = ModelFactory.createDefaultModel();
        return model;
    }
}
