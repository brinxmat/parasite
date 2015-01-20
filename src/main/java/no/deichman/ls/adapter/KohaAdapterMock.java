/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;
import java.util.HashMap;
import no.deichman.ls.domain.Item;

/**
 *
 * @author sbd
 */
public class KohaAdapterMock implements KohaAdapter {
    private HashMap<String, Item> itemList = new HashMap<String, Item>();

    @Override
    public Model getItemsByManifestationId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
