package no.deichman.ls.dao;

import java.util.List;

public class ManifestationDAO {

    private String id;
    private List<no.deichman.ls.dao.ItemDAO> itemListDAO;

    public ManifestationDAO(String id) {
        this.id = id;
    }

    public ManifestationDAO(String string, String string0, String gyldendal, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemDAO> getItemListDAO() {
        return itemListDAO;
    }

    public void setItemListDAO(List<ItemDAO> itemListDAO) {
        this.itemListDAO = itemListDAO;
    }
}
