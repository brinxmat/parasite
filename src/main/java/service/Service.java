/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
import no.deichman.ls.consumer.ManifestationConsumer;
import no.deichman.ls.consumer.WorkConsumerMock;
import no.deichman.ls.consumer.ManifestationConsumerMock;
import no.deichman.ls.consumer.WorkConsumer;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;

/**
 *
 * @author sbd
 */
public class Service {
    static private WorkConsumer workConsumer =  new WorkConsumerMock();
    static private ManifestationConsumer manifestationConsumer = new ManifestationConsumerMock();
    
    public HashMap<Integer, Work> retriveWorkList() {
        return workConsumer.getWorkList();
}

    public HashMap<Integer, Manifestation> retriveManifestationList() {
        return manifestationConsumer.getManifestationList();
    }

    public Work retriveWorkById(int id) {
        Work work = workConsumer.getWork(id);
        work.setManifestations(manifestationConsumer.getManifestationsByWorkId(id));
        return work;
    }

    public Manifestation retriveManifestationById(int id) {
        return manifestationConsumer.getManifestationById(id);
    }

}
