/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.repository;

import com.hp.hpl.jena.rdf.model.Model;

/**
 *
 * @author sbd
 */
interface Repository {

    /*
     Work
     */
    public Model listWorks();

    public Model createWork(Model model);

    public Model retrieveWorkById(String id);

    public void deleteWork(String id);

    /*
     Manifestation
     */
    public Model listManifestations();

    public Model createManifestation(Model model);

    public Model retrieveManifestationById(String id);

    public void deleteManifestation(String id);

    /*
     Item
     */
    public Model listItems();

    public Model createItem(Model model);

    public Model retrieveItemById(String id);

    public Model retrieveItemByManifestationId(String id);

    public void deleteItem(String id);

    /*
     Sparql "endpoint"
     */
    public Model queryModel(String query);

}
