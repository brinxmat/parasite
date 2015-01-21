/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.util.HashMap;
import no.deichman.ls.dao.WorkDAO;
import no.deichman.ls.dao.ManifestationDAO;
import no.deichman.ls.mapper.ManifestationMapper;
import no.deichman.ls.mapper.WorkMapper;

/**
 *
 * @author sbd
 */
public class DataDeichmanAdapterMock implements DataDeichmanAdapter {

    private HashMap<String, WorkDAO> workList = new HashMap<String, WorkDAO>();
    private HashMap<String, ManifestationDAO> allManifestationList = new HashMap<String, ManifestationDAO>();
    private HashMap<String, HashMap<String, ManifestationDAO>> manifestationListByWorkId = new HashMap<String, HashMap<String, ManifestationDAO>>();

    public DataDeichmanAdapterMock() {
        createWorkDAOMockList();
        createManifestationDAOMockList();
    }

    @Override
    public Model getWorkList() {
        Model model = ModelFactory.createDefaultModel();
        for (WorkDAO w : workList.values()) {
            w.setManifestations(manifestationListByWorkId.get(w.getId()));
            model.add(WorkMapper.mapWorkDAOToModel(w));
        }
        return model;
    }

    @Override
    public Model getWork(String id) {
        Model model = ModelFactory.createDefaultModel();
        WorkDAO work = workList.get(id);
        if (work != null) {
            work.setManifestations(manifestationListByWorkId.get(id));
            model = WorkMapper.mapWorkDAOToModel(workList.get(id));
        }
        return model;
    }

    @Override
    public Model getAllWorks(String type, int limit, int offset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model getManifestationList() {
        Model model = ModelFactory.createDefaultModel();
        for (ManifestationDAO m : allManifestationList.values()) {
            model.add(ManifestationMapper.mapManifestationDAOToModel(m));
        }
        return model;
    }

    @Override
    public Model getManifestationsByWorkId(String id) {
        Model model = ModelFactory.createDefaultModel();

        for (ManifestationDAO m : manifestationListByWorkId.get(id).values()) {
            model.add(ManifestationMapper.mapManifestationDAOToModel(m));
        }
        return model;
    }

    @Override
    public Model getManifestationById(String manifestationId) {

        return ManifestationMapper.mapManifestationDAOToModel(allManifestationList.get(manifestationId));
    }

    private void createWorkDAOMockList() {
        WorkDAO work;
        // work1:
        work = new WorkDAO("w1", "Sult", "Knut Hamsun");
        addWorkToLists(work);

        // work2:
        work = new WorkDAO("w2", "Sykkelrytteren", "Tim Krabbé");
        addWorkToLists(work);
    }

    private void createManifestationDAOMockList() {
        ManifestationDAO manifestation;
        // manifestation of work1:
        manifestation = new ManifestationDAO("m1", "1234-5678-90", "Gyldendal", "1906", "w1");
        addManifestationToLists(manifestation);

        // manifestation of work2:
        manifestation = new ManifestationDAO("m2", "9788291614823", "Arneberg Forlag", "2009", "w2");
        addManifestationToLists(manifestation);

        // another manifestation of work1:
        manifestation = new ManifestationDAO("m3", "9788205277489", "Gyldendal Norsk Forlag", "2001", "w1");
        addManifestationToLists(manifestation);
    }

    private void addWorkToLists(WorkDAO w) {
        workList.put(w.getId(), w);
    }

    private void addManifestationToLists(ManifestationDAO m) {
        HashMap<String, ManifestationDAO> manifestationList = new HashMap<>();

        if (manifestationListByWorkId.get(m.getWorkId()) != null) {
            manifestationList = manifestationListByWorkId.get(m.getWorkId());
        } else {
            manifestationList = new HashMap<>();
        }

        manifestationList.put(m.getId(), m);
        manifestationListByWorkId.put(m.getWorkId(), manifestationList); // put the manifestation on work1's list
        allManifestationList.put(m.getId(), m); // put the manifestation on the list of all manifestations

    }
}
