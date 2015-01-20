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

    public static Item mapItemDAOToItem(ItemDAO itemDAO) {
        Item i = new Item();
        i.setId(itemDAO.barcode);
        i.setManifestationId(itemDAO.biblionumber);
        i.setBiblioItemNumber(itemDAO.biblioitemnumber);
        i.setHoldingBranchName(itemDAO.holdingbranchname);
        i.setNotForLoan(Boolean.parseBoolean(itemDAO.notforloan)); // private boolean 
        i.setItemNumber(itemDAO.itemnumber); // private String 
        i.setItemCallNumber(itemDAO.itemcallnumber); // private String 
        if (itemDAO.itemlost != null) {
            i.setItemLost(Integer.parseInt(itemDAO.itemlost)); // private int 
        }
        i.setDateDue(itemDAO.date_due); // private String 
        i.setUri(itemDAO.uri); // private String 
        i.setDateLastSeen(itemDAO.datelastseen); // private String 
        i.setHomeBranch(itemDAO.homebranch); // private String 
        i.setHomeBranchName(itemDAO.holdingbranchname); // private String 
        i.setHoldingBranch(itemDAO.holdingbranch); // private String 
        if (itemDAO.copynumber != null) {
            i.setCopyNumber(Integer.parseInt(itemDAO.copynumber)); // private int 
        }
        return i;
    }

    public static Model mapItemToModel(Item item) {

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

    Statement mapItemDAOToModel(ItemDAO m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
