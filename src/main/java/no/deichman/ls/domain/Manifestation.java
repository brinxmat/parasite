/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.domain;

/**
 *
 * @author sbd
 */
public class Manifestation {

    private int id;
    private String isbn;
    private String publisher;
    private String publicationYear;
    private int workId;

    public Manifestation(int id, String isbn, String publisher, String publicationYear, int workId) {
        this.id = id;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.workId = workId;
    }

    public int getId() {
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

    public int getWorkId() {
        return workId;
    }
}
