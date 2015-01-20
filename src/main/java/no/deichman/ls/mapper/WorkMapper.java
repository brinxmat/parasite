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
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;

/**
 *
 * @author sbd
 */
public class WorkMapper {

    static final String NS = "http://data.deichman.no/work/";
    static String resource;

    public Work mapWorkDAOToWork(Model workDAO) {

        return null;
    }

    public static Model mapWorkToModel(Work work) {

        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", NS);
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(mapIdToStatement(work.getId()));
        model.add(mapTitleToStatement(work.getTitle()));
        model.add(mapAuthorToStatement(work.getAuthor()));
        model.add(mapManifestationsToModel(work.getManifestations()));

        return model;
    }

    public static Work mapModelToWork(Model model) {

        // todo
        return new Work();
    }

    private static Statement mapIdToStatement(String id) {
        setResource(id);
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        Resource o = ResourceFactory.createResource("http://purl.org/vocab/frbr/core#Work");

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

    private static Model mapManifestationsToModel(HashMap<String, Manifestation> map) {
        // TODO: for all manifestations map them, add to model and return
        Model model = ModelFactory.createDefaultModel();
        ManifestationMapper mm = new ManifestationMapper();
        for (Manifestation m : map.values()) {
            model.add(mm.mapManifestationToModel(m));
        }
        return model;
    }

    static private void setResource(String id) {
        resource = new String(NS + "w" + id);
    }
}