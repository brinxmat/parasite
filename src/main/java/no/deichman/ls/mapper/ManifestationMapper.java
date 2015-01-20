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
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;

/**
 *
 * @author sbd
 */
public class ManifestationMapper {

    static final String NS = "http://data.deichman.no/manifestation/";
    static String resource;

    public static Manifestation mapModelToManifestation(Model model) {
        return new Manifestation();
    }

    public Manifestation mapManifestationDAOToManifestation(Model manifestationDAO) {

        return null;
    }

    public Model mapManifestationToModel(Manifestation manifestation) {

        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", NS);
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(mapIdToStatement(manifestation.getId()));
        model.add(mapManifestationsToModel(manifestation.getItems()));

        return model;
    }

    private Statement mapIdToStatement(String id) {
        setResource(id);
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        Resource o = ResourceFactory.createResource("http://purl.org/vocab/frbr/core#Manifestation");

        return ResourceFactory.createStatement(s, p, o);
    }

    private Statement mapTitleToStatement(String title) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/dc/terms/title");
        Literal o = ResourceFactory.createTypedLiteral(title);

        return ResourceFactory.createStatement(s, p, o);
    }

    private Statement mapAuthorToStatement(String author) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/dc/terms/creator");
        Resource o = ResourceFactory.createResource(author);

        return ResourceFactory.createStatement(s, p, o);
    }

    private Model mapManifestationsToModel(HashMap<String, Item> map) {
        // TODO: for all manifestations map them, add to model and return
        Model model = ModelFactory.createDefaultModel();
        ItemMapper im = new ItemMapper();
        for (Item m : map.values()) {
            model.add(im.mapItemToModel(m));
        }
        return model;
    }

    static private void setResource(String id) {
        resource = new String(NS + "w" + id);
    }
}

//
//  private int id;
//  private String title;
//  private String author;
//  private HashMap<Integer, Manifestation> manifestations;
