/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;

/**
 *
 * @author sbd
 */
public interface KohaAdapter {

    public Model getItemById(String id);
    public Model getItemsByManifestationId(String id);
    public Model getItemList();
}
