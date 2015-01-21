/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.dao;

import no.deichman.ls.domain.*;
import java.util.HashMap;

/**
 *
 * @author sbd
 */
public class WorkDAO {

    private String id;
    private String title;
    private String author;
    private HashMap<String, ManifestationDAO> manifestations;

    public WorkDAO() {
    }

    public WorkDAO(String id, String title, String author) {
        this.manifestations = new HashMap<String, ManifestationDAO>();
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public HashMap<String, ManifestationDAO> getManifestations() {
        return manifestations;
    }

    public void setManifestations(HashMap<String, ManifestationDAO> manifestations) {
        this.manifestations = manifestations;
    }
    
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Id : " + this.id + '\n');
        stringBuilder.append("Title : " + this.title + '\n');
        stringBuilder.append("Author : " + this.author + '\n');

        return stringBuilder.toString();
    }
}
