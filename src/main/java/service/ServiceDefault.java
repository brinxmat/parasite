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
import no.deichman.ls.adapter.DataDeichmanAdapterMock;
import no.deichman.ls.adapter.KohaAdapterMock;
import no.deichman.ls.adapter.DataDeichmanAdapter;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;
import no.deichman.ls.mapper.ManifestationMapper;
import no.deichman.ls.mapper.WorkMapper;
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
    public HashMap<String, Work> retriveWorkList() {

        Model model = dataDeichmanAdapter.getWorkList();
        HashMap<String, Work> map = new HashMap<String, Work>();
        // for all works in model
        //   put them in the map
        return map;
    }

    @Override
    public HashMap<String, Manifestation> retriveManifestationList() {
        Model model = dataDeichmanAdapter.getManifestationList();
        HashMap<String, Manifestation> map = new HashMap<String, Manifestation>();
        // for all manifestations in model
        //   put them in the map
        return map;
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
    public Manifestation retriveManifestationById(String id) {
        Model model = repository.retrieveManifestation(id);
        if (model == null) {
            model = dataDeichmanAdapter.getManifestationById(id);
            repository.createManifestation(model);
        }
        return ManifestationMapper.mapModelToManifestation(model);
    }

    @Override
    public Item retriveItemById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}