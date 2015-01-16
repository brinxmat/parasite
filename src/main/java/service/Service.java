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
import no.deichman.ls.adapter.DataDeichmanAdapterDefault;
import no.deichman.ls.adapter.KohaAdapterDefault;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;

/**
 *
 * @author sbd
 */
public class Service {

    static private DataDeichmanAdapter dataDeichmanAdapter = new DataDeichmanAdapterMock();
    static private KohaAdapter kohaAdapter = new KohaAdapterDefault();

    public HashMap<String, Work> retriveWorkList() {
        return dataDeichmanAdapter.getWorkList();
    }

    public HashMap<String, Manifestation> retriveManifestationList() {
        return kohaAdapter.getManifestationList();
    }

    public Work retriveWorkById(String id) {
        
        // Pseudo:
        // queryModel(workIId)
        // If found in model
        // -- return model, resource, or POJO?
        // If not found in model, fetch from adapter:
        Work work = dataDeichmanAdapter.getWork(id);
        work.setManifestations(kohaAdapter.getManifestationsByWorkId(id));
        return work;
    }

    public Manifestation retriveManifestationById(String id) {
        return kohaAdapter.getManifestationById(id);
    }

    public Item retriveItemById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
