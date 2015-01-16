/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sbd
 */
public class Work {

    private String id;
    private String title;
    private String author;
    private double price;
    private HashMap<String, Manifestation> manifestations;

    public Work(String id, String title, String author, double price) {
        this.manifestations = new HashMap<String, Manifestation>();
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HashMap<String, Manifestation> getManifestations() {
        return manifestations;
    }

    public void setManifestations(HashMap<String, Manifestation> manifestations) {
        this.manifestations = manifestations;
    }
    
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Id : " + this.id + '\n');
        stringBuilder.append("Title : " + this.title + '\n');
        stringBuilder.append("Author : " + this.author + '\n');
        stringBuilder.append("Price : " + this.price + '\n');

        return stringBuilder.toString();
    }
}
