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
    private HashMap<String, ManifestationDAO> manifestationList = new HashMap<String, ManifestationDAO>();
    private HashMap<String, HashMap<String, ManifestationDAO>> manifestationListByWorkId = new HashMap<String, HashMap<String, ManifestationDAO>>();
    private HashMap manifestationListOfWork1 = new HashMap<String, ManifestationDAO>();
    private HashMap manifestationListOfWork2 = new HashMap<String, ManifestationDAO>();

    public DataDeichmanAdapterMock() {
        createManifestationDAOMockList();
        createWorkDAOMockList();
    }

    @Override
    public Model getWorkList() {
        Model model = ModelFactory.createDefaultModel();
        for (WorkDAO w : workList.values()) {
            model.add(WorkMapper.mapWorkDAOToModel(w));
        }
        return model;
    }

    @Override
    public Model getWork(String id) {
        WorkDAO work = workList.get(id);
        if (work != null) {
            return WorkMapper.mapWorkDAOToModel(workList.get(id));
        }
        return null;
    }

    @Override
    public Model getAllWorks(String type, int limit, int offset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model getManifestationList() {
        Model model = ModelFactory.createDefaultModel();
        for (ManifestationDAO m : manifestationList.values()) {
            model.add(ManifestationMapper.mapManifestationDAOToModel(m));
        }
        return model;
    }

    @Override
    public Model getManifestationsByWorkId(String id) {
        Model model = ModelFactory.createDefaultModel();
        WorkDAO work = workList.get(id);
        for (ManifestationDAO m : work.getManifestations().values()) {
            model.add(ManifestationMapper.mapManifestationDAOToModel(m));
        }
        return model;
    }

    @Override
    public Model getManifestationById(String manifestationId) {

        return ManifestationMapper.mapManifestationDAOToModel(manifestationList.get(manifestationId));
    }

    private void createWorkDAOMockList() {
        WorkDAO workItem1 = new WorkDAO("w1", "Sult", "Knut Hamsun", 22.20);
        workItem1.setManifestations(manifestationList);
        workList.put(workItem1.getId(), workItem1);
        WorkDAO workItem2 = new WorkDAO("w2", "Sykkelrytteren", "Tim Krabbé", 22.20);
        workList.put(workItem2.getId(), workItem2);

    }

    private void createManifestationDAOMockList() {
        ManifestationDAO manifestation1 = new ManifestationDAO("m1", "1234-5678-90", "Gyldendal", "1906", "w1");
        manifestationList.put(manifestation1.getId(), manifestation1);
        manifestationListOfWork1.put(manifestation1.getId(), manifestation1);
        manifestationListByWorkId.put("w1", manifestationListOfWork1);

        ManifestationDAO manifestation2 = new ManifestationDAO("m2", "9788291614823", "Arneberg Forlag", "2009", "w2");
        manifestationList.put(manifestation2.getId(), manifestation2);
        manifestationListOfWork2.put(manifestation2.getId(), manifestation2);
        manifestationListByWorkId.put("w2", manifestationListOfWork2);

        ManifestationDAO manifestation3 = new ManifestationDAO("m3", "9788205277489", "Gyldendal Norsk Forlag", "2001", "w1");
        manifestationList.put(manifestation3.getId(), manifestation3);
        manifestationListOfWork1.put(manifestation3.getId(), manifestation3);
        manifestationListByWorkId.put("w1", manifestationListOfWork1);
    }
}
