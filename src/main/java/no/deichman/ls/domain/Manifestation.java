/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.domain;

import java.util.HashMap;

/**
 *
 * @author sbd
 */
public class Manifestation {

    private String id;
    private String isbn;
    private String publisher;
    private String publicationYear;
    private String workId;
    private HashMap<String, Item> items;

    public Manifestation() {
    }

    public Manifestation(String id, String isbn, String publisher, String publicationYear, String workId) {
        this.id = id;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.workId = workId;
        this.items = new HashMap<String, Item>();
    }

    public Manifestation(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getWorkId() {
        return workId;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    @Override
    public String toString() {
        return "Manifestation{" + "id=" + id + ", isbn=" + isbn + ", publisher=" + publisher + ", publicationYear=" + publicationYear + ", workId=" + workId + ", items=" + items + '}';
    }
}
