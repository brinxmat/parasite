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
    private HashMap<String, ItemDAO> allItemList = new HashMap<String, ItemDAO>();

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

    @Override
    public Model getItemById(String id) {
        Model model = ModelFactory.createDefaultModel();
        ItemDAO itemDAO = allItemList.get(id);
        if (itemDAO != null) {
            model.add(ItemMapper.mapItemDAOToModel(itemDAO));
        }
        return model;
    }

    @Override
    public Model getItemList() {
        Model model = ModelFactory.createDefaultModel();
        for (ItemDAO i : allItemList.values()) {
            model.add(ItemMapper.mapItemDAOToModel(i));
        }
        return model;
    }

    private void createItemMockList() {
        ItemDAO item1 = new ItemDAO();
        item1.biblioitemnumber = "i1";
        item1.barcode = "1234567890";
        item1.biblionumber = "m1"; // this is the FK to manifestationId
        item1.onloan = "På hylla";
        HashMap<String, ItemDAO> itemList = new HashMap<String, ItemDAO>();
        itemList.put(item1.biblioitemnumber, item1);
        allItemList.put(item1.biblioitemnumber, item1);
        itemMap.put(item1.biblionumber, itemList);

        ItemDAO item2 = new ItemDAO();
        item2.biblioitemnumber = "i2";
        item2.barcode = "2234567890";
        item2.biblionumber = "m2"; // this is the FK to manifestationId
        item2.onloan = "Utlånt";
        itemList = new HashMap<String, ItemDAO>();
        itemList.put(item2.biblioitemnumber, item2);
        allItemList.put(item2.biblioitemnumber, item2);
        itemMap.put(item2.biblionumber, itemList);

        ItemDAO item3 = new ItemDAO();
        item3.biblioitemnumber = "i3";
        item3.barcode = "3234567890";
        item3.biblionumber = "m3"; // this is the FK to manifestationId
        item3.onloan = "På hylla";
        itemList = new HashMap<String, ItemDAO>();
        itemList.put(item3.biblioitemnumber, item3);
        allItemList.put(item3.biblioitemnumber, item3);
        itemMap.put(item3.biblionumber, itemList);

        ItemDAO item4 = new ItemDAO();
        item4.biblioitemnumber = "i4";
        item4.barcode = "4234567890";
        item4.biblionumber = "m3"; // this is the FK to manifestationId
        item4.onloan = "På hylla";
        if (itemMap.get(item4.biblionumber) == null) {
            itemList = new HashMap<String, ItemDAO>();
        } else {
            itemList = itemMap.get(item4.biblionumber);
        }
        itemList.put(item4.biblioitemnumber, item4);
        allItemList.put(item4.biblioitemnumber, item4);
        itemMap.put(item4.biblionumber, itemList);
    }
}
