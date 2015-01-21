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
import no.deichman.ls.dao.ItemDAO;
import no.deichman.ls.domain.Item;

/**
 *
 * @author sbd
 */
public class ItemMapper {

    public static Model mapItemDAOToModel(ItemDAO item) {

        Model model = ModelFactory.createDefaultModel();
        String NS = "http://www.computas.no/zebra/";
        model.setNsPrefix("", NS);
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        Resource s = ResourceFactory.createResource(NS + "Joe");
        Property p = ResourceFactory.createProperty(NS + "hasSentMessage");
        Literal o = ResourceFactory.createTypedLiteral("Hello World!");

        Statement stmt = ResourceFactory.createStatement(s, p, o);
        model.add(stmt);

        return model;
    }

    Statement mapItemToModel(Item m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
