/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.repository;

import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;
import no.deichman.ls.mapper.ItemMapper;
import no.deichman.ls.mapper.ManifestationMapper;
import no.deichman.ls.mapper.WorkMapper;
import org.apache.jena.riot.RDFDataMgr;

/**
 *
 * @author sbd
 */
public class RepositoryInMemory implements Repository {

    private final Model model = ModelFactory.createDefaultModel();

    @Override
    public Work retrieveWork(String id) {
        return null;
    }

    @Override
    public String createWork(Work work) {
        WorkMapper mapper = new WorkMapper();
        model.add(mapper.mapWorkToModel(work));
        return work.getId();
    }

    @Override
    public void deleteWork(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Manifestation retrieveManifestation(String id) {
        return null;
    }

    @Override
    public String createManifestation(Manifestation manifestation) {
        ManifestationMapper mapper = new ManifestationMapper();
        model.add(mapper.mapManifestationToModel(manifestation));
        return manifestation.getId();
    }

    @Override
    public void deleteManifestation(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String createItem(Item item) {
        ItemMapper mapper = new ItemMapper();
        model.add(mapper.mapItemToModel(item));
        return item.getId();
    }

    @Override
    public Item retrieveItem(String id) {
        return null;
    }

    @Override
    public void deleteItem(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
