/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.hp.hpl.jena.rdf.model.Model;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import no.deichman.ls.adapter.KohaAdapter;
import no.deichman.ls.adapter.DataDeichmanAdapter;
import no.deichman.ls.adapter.DataDeichmanAdapterDefault;
import no.deichman.ls.adapter.DataDeichmanAdapterMock;
import no.deichman.ls.adapter.KohaAdapterDefault;
import no.deichman.ls.adapter.KohaAdapterMock;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;
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

        // Pseudo:
        // queryModel(workIId)
        // If found in model
        // -- return model, resource, or POJO?
        // If not found in model, fetch from adapter:
        //Model model = repository.retrieveWork(id);
        Model model = null;
        if (model == null) {
            try {
                model = dataDeichmanAdapter.getWork(id);
                repository.createWork(model);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ServiceDefault.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        //model.setManifestations(kohaAdapter.getManifestationsByWorkId(id));
        return model;
    }

    @Override
    public Model retriveManifestationById(String id) {
        //Model model = repository.retrieveManifestation(id);
        Model model = null;
        if (model == null) {
            model = dataDeichmanAdapter.getManifestationById(id);
            model.add(kohaAdapter.getItemsByManifestationId(id));
            repository.createManifestation(model);
        }
        return model;
    }

    @Override
    public Model retriveItemByManifestationId(String id) {
        Model model = null;
        if (model == null) {
            model = dataDeichmanAdapter.getManifestationById(id);
            model.add(kohaAdapter.getItemsByManifestationId(id));
            //repository.createItem(model);
        }
        return model;
    }

    @Override
    public Model retriveItemById(String id) {
        Model model = null;
        if (model == null) {
            model = kohaAdapter.getItemById(id);
            //repository.createItem(model);
        }
        return model;
    }
}
