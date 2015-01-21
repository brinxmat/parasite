package no.deichman.ls.dao;

import java.util.HashMap;
import java.util.List;
import no.deichman.ls.domain.Item;

public class ManifestationDAO {

    private String id;
    private String isbn;
    private String publisher;
    private String publicationYear;
    private String workId;
    private List<no.deichman.ls.dao.ItemDAO> itemListDAO;

    public ManifestationDAO(String id) {
        this.id = id;
    }

    public ManifestationDAO(String id, String isbn, String publisher, String publicationYear, String workId) {
        this.id = id;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.workId = workId;
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
