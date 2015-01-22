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
import java.io.StringWriter;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

/**
 *
 * @author sbd
 */
public class RepositoryInMemory implements Repository {

    private final Model inMemoryModel = ModelFactory.createDefaultModel();

    private Model retrieveResource(String id) {
        String debug = modelToString(inMemoryModel);
        Model result = ModelFactory.createDefaultModel();
        Resource resource = ResourceFactory.createResource(id);
        Selector selector = new SimpleSelector(resource, null, (RDFNode) null);
        result = inMemoryModel.query(selector);
        String debugResult = modelToString(result);
        return result;
    }

    @Override
    public Model retrieveWork(String uri) {
        return retrieveResource(uri);
    }

    @Override
    public Model createWork(Model model) {
        inMemoryModel.add(model);
        String debug = modelToString(inMemoryModel);
        return model;
    }

    @Override
    public void deleteWork(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model retrieveManifestation(String uri) {
        return retrieveResource(uri);
    }

    @Override
    public Model createManifestation(Model model) {
        inMemoryModel.add(model);
        String debug = modelToString(inMemoryModel);
        return model;
    }

    @Override
    public void deleteManifestation(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model createItem(Model model) {
        inMemoryModel.add(model);
        String debug = modelToString(inMemoryModel);
        return model;
    }

    @Override
    public Model retrieveItem(String uri) {
        String debug = modelToString(inMemoryModel);
        return retrieveResource(uri);
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

    private String modelToString(Model m) {
        String syntax = "TURTLE"; // also try "N-TRIPLE" and "TURTLE"
        StringWriter out = new StringWriter();
        m.write(out, syntax);
        return out.toString();
    }

    @Override
    public Model queryModel(String query) {
        // For now just return the whole model
        //TODO
        return inMemoryModel;
    }
}
