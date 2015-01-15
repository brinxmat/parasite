/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.consumer;

import java.util.HashMap;
import no.deichman.ls.domain.Manifestation;

/**
 *
 * @author sbd
 */
public class ManifestationConsumerMock implements ManifestationConsumer {

    private HashMap<Integer, Manifestation> manifestationList = new HashMap<Integer, Manifestation>();
    private HashMap<Integer, HashMap<Integer, Manifestation>> manifestationListByWorkId = new HashMap<Integer, HashMap<Integer, Manifestation>>();

    public ManifestationConsumerMock() {
        createMockLists();
    }

    @Override
    public HashMap<Integer, Manifestation> getManifestationList() {
        return manifestationList;
    }

    @Override
    public HashMap<Integer, Manifestation> getManifestationsByWorkId(int id) {
        return manifestationListByWorkId.get(id);
    }

    @Override
    public Manifestation getManifestationById(int manifestationId) { 
       return manifestationList.get(manifestationId);
    }

    private void createMockLists() {
        Manifestation manifestation1 = new Manifestation(1, "1234-5678-90", "Gyldendal", "1906", 1);
        manifestationList.put(manifestation1.getId(), manifestation1);
        HashMap manifestationListOfWork1 = new HashMap<Integer, Manifestation>();
        manifestationListOfWork1.put(manifestation1.getId(), manifestation1);
        manifestationListByWorkId.put(manifestation1.getWorkId(), manifestationListOfWork1);

        Manifestation manifestation2 = new Manifestation(2, "9788291614823", "Arneberg Forlag", "2009", 2);
        manifestationList.put(manifestation2.getId(), manifestation2);
        HashMap manifestationListOfWork2 = new HashMap<Integer, Manifestation>();
        manifestationListOfWork2.put(manifestation2.getId(), manifestation2);
        manifestationListByWorkId.put(manifestation2.getWorkId(), manifestationListOfWork2);
        
        Manifestation manifestation3 = new Manifestation(3, "9788205277489", "Gyldendal Norsk Forlag", "2001", 1);
        manifestationList.put(manifestation3.getId(), manifestation3);
        manifestationListOfWork1.put(manifestation3.getId(), manifestation3);
        manifestationListByWorkId.put(manifestation3.getWorkId(), manifestationListOfWork1);

    }
}
