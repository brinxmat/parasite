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
    
    public Model listWorks();
    public String createWork (Model model);
    public Model retrieveWork(String id);
    public void deleteWork (String id);

    public Model listManifestations();
    public String createManifestation (Model model);
    public Model retrieveManifestation(String id);
    public void deleteManifestation (String id);

    public Model listItems();
    public String createItem (Model model);
    public Model retrieveItem(String id);
    public void deleteItem (String id);

}
