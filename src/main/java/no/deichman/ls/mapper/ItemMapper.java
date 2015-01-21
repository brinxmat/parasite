/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.mapper;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import no.deichman.ls.dao.ItemDAO;

/**
 *
 * @author sbd
 */
public class ItemMapper {

    static final String NS = "http://localhost:8080/parasite/item/";
    static String resource;

    public static Model mapItemDAOToModel(ItemDAO item) {

        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", NS);
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(mapIdToStatement(item.biblioitemnumber));
        model.add(mapBarcodeToStatement(item.barcode));
        model.add(mapStatusToStatement(item.onloan));
        model.add(mapManifestationIdToStatement(item.biblionumber));

        return model;
    }

    private static Statement mapIdToStatement(String id) {
        setResource(id);
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        Resource o = ResourceFactory.createResource("http://purl.org/vocab/frbr/core#Item");

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement mapBarcodeToStatement(String barcode) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/deichman/barcode");
        Resource o = ResourceFactory.createResource(barcode);

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement mapStatusToStatement(String status) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/deichman/status");
        Resource o = ResourceFactory.createResource(status);

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement mapManifestationIdToStatement(String biblionumber) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/vocab/frbr/core#isItemOf");
        Resource o = ResourceFactory.createResource("http://localhost:8080/parasite/manifestation/" + biblionumber);

        return ResourceFactory.createStatement(s, p, o);
    }


    static private void setResource(String id) {
        resource = new String(NS + id);
    }
}
