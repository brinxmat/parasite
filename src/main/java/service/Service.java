/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.hp.hpl.jena.rdf.model.Model;
import java.util.HashMap;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;

/**
 *
 * @author sbd
 */
public interface Service {

    Item retriveItemById(String id);

    Manifestation retriveManifestationById(String id);

    HashMap<String, Manifestation> retriveManifestationList();

    Model retriveWorkById(String id);

    HashMap<String, Work> retriveWorkList();
    
}
