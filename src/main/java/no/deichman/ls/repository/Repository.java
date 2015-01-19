/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.repository;

import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;

/**
 *
 * @author sbd
 */
interface Repository {
    
    public String createWork (Work work);
    public Work retrieveWork(String id);
    public void deleteWork (String id);

    public String createManifestation (Manifestation manifestation);
    public Manifestation retrieveManifestation(String id);
    public void deleteManifestation (String id);

    public String createItem (Item item);
    public Item retrieveItem(String id);
    public void deleteItem (String id);

}
