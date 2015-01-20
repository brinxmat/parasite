/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.util.HashMap;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;
import no.deichman.ls.mapper.ManifestationMapper;
import no.deichman.ls.mapper.WorkMapper;

/**
 *
 * @author sbd
 */
public class DataDeichmanAdapterMock implements DataDeichmanAdapter {

    private HashMap<String, Work> workList = new HashMap<String, Work>();
    private HashMap<String, Manifestation> manifestationList = new HashMap<String, Manifestation>();
    private HashMap<String, HashMap<String, Manifestation>> manifestationListByWorkId = new HashMap<String, HashMap<String, Manifestation>>();
    private HashMap manifestationListOfWork1 = new HashMap<Integer, Manifestation>();
    private HashMap manifestationListOfWork2 = new HashMap<Integer, Manifestation>();

    public DataDeichmanAdapterMock() {
        createManifestationMockList();
        createWorkMockList();
    }

    @Override
    public Model getWorkList() {
        Model model = ModelFactory.createDefaultModel();
        for (Work w : workList.values()) {
            model.add(WorkMapper.mapWorkToModel(w));
        }
        return model;
    }

    @Override
    public Model getWork(String id) {

        return WorkMapper.mapWorkToModel(workList.get(id));
    }

    @Override
    public Model getAllWorks(String type, int limit, int offset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model getManifestationList() {
        Model model = ModelFactory.createDefaultModel();
        for (Manifestation m : manifestationList.values()) {
            model.add(ManifestationMapper.mapManifestationToModel(m));
        }
        return model;
    }

    @Override
    public Model getManifestationsByWorkId(String id) {
        Model model = ModelFactory.createDefaultModel();
        Work work = workList.get(id);
        for (Manifestation m : work.getManifestations().values()) {
            model.add(ManifestationMapper.mapManifestationToModel(m));
        }
        return model;
    }

    @Override
    public Model getManifestationById(String manifestationId) {

        return ManifestationMapper.mapManifestationToModel(manifestationList.get(manifestationId));
    }

    private void createWorkMockList() {
        Work workItem1 = new Work("1", "Sult", "Knut Hamsun", 22.20);
        workItem1.setManifestations(manifestationList);
        workList.put(workItem1.getId(), workItem1);
        Work workItem2 = new Work("2", "Sykkelrytteren", "Tim Krabbé", 22.20);
        workList.put(workItem2.getId(), workItem2);

    }

    private void createManifestationMockList() {
        Manifestation manifestation1 = new Manifestation("1", "1234-5678-90", "Gyldendal", "1906", "1");
        manifestationList.put(manifestation1.getId(), manifestation1);
        manifestationListOfWork1.put(manifestation1.getId(), manifestation1);
        manifestationListByWorkId.put(manifestation1.getWorkId(), manifestationListOfWork1);

        Manifestation manifestation2 = new Manifestation("2", "9788291614823", "Arneberg Forlag", "2009", "2");
        manifestationList.put(manifestation2.getId(), manifestation2);
        manifestationListOfWork2.put(manifestation2.getId(), manifestation2);
        manifestationListByWorkId.put(manifestation2.getWorkId(), manifestationListOfWork2);

        Manifestation manifestation3 = new Manifestation("3", "9788205277489", "Gyldendal Norsk Forlag", "2001", "1");
        manifestationList.put(manifestation3.getId(), manifestation3);
        manifestationListOfWork1.put(manifestation3.getId(), manifestation3);
        manifestationListByWorkId.put(manifestation3.getWorkId(), manifestationListOfWork1);

    }
}
