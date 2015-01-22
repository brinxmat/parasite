/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.hp.hpl.jena.rdf.model.Model;
import java.io.FileNotFoundException;
import java.io.StringWriter;
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
    static private KohaAdapter kohaAdapter = new KohaAdapterDefault();
    static private RepositoryInMemory repository = new RepositoryInMemory();
    static private final String BASE_URI = "http://localhost:8080/parasite/";

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
        String uri = BASE_URI + "work/" + id;
        Model model = repository.retrieveWork(uri);
        if (model.isEmpty()) {
            try {
                model.add(dataDeichmanAdapter.getWork(id));
                if (!model.isEmpty()) {
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
        String uri = BASE_URI + "manifestation/" + id;
        Model model = repository.retrieveManifestation(uri);
        if (model.isEmpty()) {
            model.add(dataDeichmanAdapter.getManifestationById(id));
            model.add(kohaAdapter.getItemsByManifestationId(id));
            String debug = modelToString(model);
            if (!model.isEmpty()) {
                repository.createManifestation(model);
            }
        }
        return model;
    }

    @Override
    public Model retriveItemByManifestationId(String id) {
        String uri = BASE_URI + "manifestation/" + id;
        Model model = repository.retrieveManifestation(uri);
        if (model.isEmpty()) {
            model.add(kohaAdapter.getItemsByManifestationId(id));
            if (!model.isEmpty()) {
                repository.createItem(model);
            }
        }
        return model;
    }

    @Override
    public Model retriveItemById(String id) {
                String uri = BASE_URI + "item/" + id;
        Model model = repository.retrieveItem(uri);
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

    @Override
    public Model queryModel(String query) {
        return repository.queryModel(query);
    }

    private String modelToString(Model m) {
        String syntax = "TURTLE"; // also try "N-TRIPLE" and "TURTLE"
        StringWriter out = new StringWriter();
        m.write(out, syntax);
        return out.toString();
    }
}
