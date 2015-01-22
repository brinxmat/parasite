/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.hp.hpl.jena.rdf.model.Model;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import no.deichman.ls.adapter.KohaAdapter;
import no.deichman.ls.adapter.DataDeichmanAdapter;
import no.deichman.ls.adapter.DataDeichmanAdapterMock;
import no.deichman.ls.adapter.KohaAdapterDefault;
import no.deichman.ls.adapter.KohaAdapterMock;
import no.deichman.ls.repository.RepositoryInMemory;

/**
 *
 * @author sbd
 */
public class ServiceDefault implements Service {

    static private DataDeichmanAdapter dataDeichmanAdapter = new DataDeichmanAdapterMock();
    static private KohaAdapter kohaAdapter = new KohaAdapterMock();
    static private RepositoryInMemory repository = new RepositoryInMemory();

    @Override
    public Model retriveWorkList() {

        Model model = dataDeichmanAdapter.getWorkList();
        return model;
    }

    @Override
    public Model retriveManifestationList() {
        Model model = dataDeichmanAdapter.getManifestationList();
        return model;
    }

    @Override
    public Model retriveWorkById(String id) {

        Model model = repository.retrieveWork(id);
        if (model.isEmpty()) {
            try {
                model = dataDeichmanAdapter.getWork(id);
                if (model != null) {
                    repository.createWork(model);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ServiceDefault.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return model;
    }

    @Override
    public Model retriveManifestationById(String id) {

        Model model = repository.retrieveManifestation(id);
        if (model.isEmpty()) {
            model = dataDeichmanAdapter.getManifestationById(id);
            if (model != null) {
                model.add(kohaAdapter.getItemsByManifestationId(id));
            }
            if (model != null) {
                repository.createManifestation(model);
            }
        }
        return model;
    }

    @Override
    public Model retriveItemByManifestationId(String id) {
        Model model = repository.retrieveManifestation(id);
        if (model.isEmpty()) {
            model = dataDeichmanAdapter.getManifestationById(id);
            if (model != null) {
                model.add(kohaAdapter.getItemsByManifestationId(id));
            }
            if (model != null) {
                repository.createItem(model);
            }
        }
        return model;
    }

    @Override
    public Model retriveItemById(String id) {
        Model model = repository.retrieveItem(id);
        if (model.isEmpty()) {
            model = kohaAdapter.getItemById(id);
            if (model != null) {
                repository.createItem(model);
            }
        }
        return model;
    }

    @Override
    public Model retriveItemList() {
        Model model = repository.listItems();
        if (model.isEmpty()) {
            model = kohaAdapter.getItemList();
            if (model != null) {
                repository.createItem(model);
            }
        }
        return model;
    }
}
