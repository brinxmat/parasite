/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.service;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.rdf.model.Model;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import no.deichman.ls.adapter.KohaAdapter;
import no.deichman.ls.adapter.DataDeichmanAdapter;
import no.deichman.ls.adapter.DataDeichmanAdapterMock;
import no.deichman.ls.adapter.KohaAdapterDefault;
import no.deichman.ls.repository.RepositoryInMemory;

/**
 *
 * @author sbd
 */
public class ServiceDefault implements Service {

    static private DataDeichmanAdapter dataDeichmanAdapter = new DataDeichmanAdapterMock();
    static private KohaAdapter kohaAdapter = new KohaAdapterDefault();
    static private RepositoryInMemory repository = new RepositoryInMemory();
    static private final String BASE_URI = "http://localhost:8080/parasite/";

    public ServiceDefault() {
        retriveManifestationList();
        retriveWorkList();
    }

    @Override
    public Model retriveWorkList() {

        Model model = repository.listWorks();
        if (model.isEmpty()) {
            model = repository.createWork(dataDeichmanAdapter.getWorkList());
        }
        return model;
    }

    @Override
    public Model retriveManifestationList() {
        Model model = repository.listManifestations();
        if (model.isEmpty()) {
            model = repository.createManifestation(dataDeichmanAdapter.getManifestationList());
        }
        return model;
    }

    @Override
    public Model retriveWorkById(String id) {
        String uri = BASE_URI + "work/" + id;
        Model model = repository.retrieveWorkById(uri);
        if (model.isEmpty()) {
            try {
                model = repository.createWork(dataDeichmanAdapter.getWork(id));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ServiceDefault.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return model;
    }

    @Override
    public Model retriveManifestationById(String id) {
        String uri = BASE_URI + "manifestation/" + id;
        Model model = repository.retrieveManifestationById(id);
        model.add(retriveItemByManifestationId(id));
        if (model.isEmpty()) {
            model = repository.createManifestation(dataDeichmanAdapter.getManifestationById(id));
            model.add(repository.createItem(kohaAdapter.getItemsByManifestationId(id)));
        }
        return model;
    }

    @Override
    public Model retriveItemByManifestationId(String id) {
        String uri = BASE_URI + "manifestation/" + id;
        Model model = repository.retrieveItemByManifestationId(uri);
        if (model.isEmpty()) {
            model = repository.createItem(kohaAdapter.getItemsByManifestationId(id));
        }
        return model;
    }

    @Override
    public Model retriveItemById(String id) {
        String uri = BASE_URI + "item/" + id;
        Model model = repository.retrieveItemById(uri);
        if (model.isEmpty()) {
            model = repository.createItem(kohaAdapter.getItemById(id));
        }
        return model;
    }

    @Override
    public Model retriveItemList() {
        Model model = repository.listItems();
        if (model.isEmpty()) {
            model = repository.createItem(kohaAdapter.getItemList());
        }
        return model;
    }

    @Override
    public Model runQuery(String query) {
        try {
            Query q = QueryFactory.create(query);
        } catch (Exception e) {
            throw e;
        }
        return repository.queryModel(query);
    }
}
