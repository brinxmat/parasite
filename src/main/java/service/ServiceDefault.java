/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
import no.deichman.ls.adapter.KohaAdapter;
import no.deichman.ls.adapter.DataDeichmanAdapterMock;
import no.deichman.ls.adapter.KohaAdapterMock;
import no.deichman.ls.adapter.DataDeichmanAdapter;
import no.deichman.ls.domain.Item;
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
    public HashMap<String, Work> retriveWorkList() {
        return dataDeichmanAdapter.getWorkList();
    }

    @Override
    public HashMap<String, Manifestation> retriveManifestationList() {
        return kohaAdapter.getManifestationList();
    }

    @Override
    public Work retriveWorkById(String id) {

        // Pseudo:
        // queryModel(workIId)
        // If found in model
        // -- return model, resource, or POJO?
        // If not found in model, fetch from adapter:
        Work work = repository.retrieveWork(id);
        if (work == null) {
            work = dataDeichmanAdapter.getWork(id);
            // TODO Burde ikkje work bli lagt til i modellen her?
        }
        work.setManifestations(kohaAdapter.getManifestationsByWorkId(id));
        return work;
    }

    @Override
    public Manifestation retriveManifestationById(String id) {
        Manifestation manifestation = repository.retrieveManifestation(id);
        if (manifestation == null) {
            manifestation = kohaAdapter.getManifestationById(id);
        }
        return kohaAdapter.getManifestationById(id);
    }

    @Override
    public Item retriveItemById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
