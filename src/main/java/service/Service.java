/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
import no.deichman.ls.consumer.RDFConsumerMock;
import no.deichman.ls.consumer.KohaConsumerMock;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;

/**
 *
 * @author sbd
 */
public class Service {
    static private RDFConsumerMock katalog =  new RDFConsumerMock();
    static private KohaConsumerMock koha = new KohaConsumerMock();
    
    public HashMap<Integer, Work> retriveWorkList() {
        return katalog.getWorkList();
}

    public HashMap<Integer, Manifestation> retriveManifestationList() {
        return koha.getManifestationList();
    }

    public Work retriveWorkById(int id) {
        Work work = katalog.getWork(id);
        work.setManifestations(koha.getManifestationsByWorkId(id));
        return work;
    }

    public Manifestation retriveManifestationById(int id) {
        return koha.getManifestationById(id);
    }

}
