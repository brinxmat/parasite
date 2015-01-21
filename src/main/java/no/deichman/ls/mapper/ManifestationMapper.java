/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.mapper;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import java.util.HashMap;
import java.util.List;
import no.deichman.ls.dao.ItemDAO;
import no.deichman.ls.dao.ManifestationDAO;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;
import static no.deichman.ls.mapper.ItemMapper.resource;

/**
 *
 * @author sbd
 */
public class ManifestationMapper {

    static final String NS = "http://localhost:8080/parasite/manifestation/";
    static String resource;

    public static Manifestation mapModelToManifestation(Model model) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Model mapManifestationDAOToModel(ManifestationDAO manifestationDAO) {

        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", NS);
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(mapIdToStatement(manifestationDAO.getId()));
        model.add(mapItemListDAOToModel(manifestationDAO.getItemListDAO()));
        model.add(mapWorkIdToStatement(manifestationDAO.getWorkId()));

        return model;
    }

    public static Model mapManifestationToModel(Manifestation manifestation) {

        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", NS);
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(mapIdToStatement(manifestation.getId()));
        model.add(mapItemListToModel(manifestation.getItems()));

        return model;
    }

    private static Statement mapIdToStatement(String id) {
        setResource(id);
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        Resource o = ResourceFactory.createResource("http://purl.org/vocab/frbr/core#Manifestation");

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement mapTitleToStatement(String title) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/dc/terms/title");
        Literal o = ResourceFactory.createTypedLiteral(title);

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement mapAuthorToStatement(String author) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/dc/terms/creator");
        Resource o = ResourceFactory.createResource(author);

        return ResourceFactory.createStatement(s, p, o);
    }

        private static Statement mapWorkIdToStatement(String workId) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/vocab/frbr/core#isManifestationOf");
        Resource o = ResourceFactory.createResource("http://localhost:8080/parasite/work/" + workId);

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Model mapItemListToModel(HashMap<String, Item> map) {
        // TODO: for all manifestations map them, add to model and return
        Model model = ModelFactory.createDefaultModel();
        ItemMapper im = new ItemMapper();
        for (Item m : map.values()) {
            model.add(im.mapItemToModel(m));
        }
        return model;
    }

    private static Model mapItemListDAOToModel(List<ItemDAO> itemListDAO) {
        // TODO: for all manifestations map them, add to model and return
        Model model = ModelFactory.createDefaultModel();
        ItemMapper im = new ItemMapper();
        if (itemListDAO != null) {
            for (ItemDAO m : itemListDAO) {
                model.add(im.mapItemDAOToModel(m));
            }
        }

        return model;
    }

    static private void setResource(String id) {
        resource = new String(NS + id);
    }
}
