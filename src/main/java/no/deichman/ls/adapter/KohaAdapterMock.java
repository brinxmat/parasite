/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.util.HashMap;
import no.deichman.ls.dao.ItemDAO;
import no.deichman.ls.mapper.ItemMapper;

/**
 *
 * @author sbd
 */
public class KohaAdapterMock implements KohaAdapter {

    private HashMap<String, HashMap<String, ItemDAO>> itemMap = new HashMap<String, HashMap<String, ItemDAO>>();

    public KohaAdapterMock() {
        createItemMockList();
    }

    @Override
    public Model getItemsByManifestationId(String id) {
        Model model = ModelFactory.createDefaultModel();

        for (ItemDAO i : itemMap.get(id).values()) {
            model.add(ItemMapper.mapItemDAOToModel(i));
        }
        return model;
    }

    private void createItemMockList() {
        ItemDAO item1 = new ItemDAO();
        item1.biblioitemnumber = "1";
        item1.biblionumber = "1"; // this is the FK to manifestationId
        HashMap<String, ItemDAO> itemList = new HashMap<String, ItemDAO>();
        itemList.put(item1.biblioitemnumber, item1);
        itemMap.put(item1.biblionumber, itemList);

        ItemDAO item2 = new ItemDAO();
        item2.biblioitemnumber = "2";
        item2.biblionumber = "2"; // this is the FK to manifestationId
        itemList = new HashMap<String, ItemDAO>();
        itemList.put(item2.biblioitemnumber, item2);
        itemMap.put(item2.biblionumber, itemList);

        ItemDAO item3 = new ItemDAO();
        item3.biblioitemnumber = "3";
        item3.biblionumber = "3"; // this is the FK to manifestationId
        itemList = new HashMap<String, ItemDAO>();
        itemList.put(item3.biblioitemnumber, item3);
        itemMap.put(item3.biblionumber, itemList);
    }
}
