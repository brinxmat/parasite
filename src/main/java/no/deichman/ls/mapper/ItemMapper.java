/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.mapper;

import no.deichman.ls.dao.ItemDAO;
import no.deichman.ls.domain.Item;

/**
 *
 * @author sbd
 */
public class ItemMapper {

    public Item mapItemDAOToItem(ItemDAO itemDAO) {
        Item i = new Item();
        i.setId(itemDAO.barcode);
        i.setManifestationId(itemDAO.biblionumber);
        i.setBiblioItemNumber(itemDAO.biblioitemnumber);
        i.setHoldingBranchName(itemDAO.holdingbranchname);
        i.setNotForLoan(Boolean.parseBoolean(itemDAO.notforloan)); // private boolean 
        i.setItemNumber(itemDAO.itemnumber); // private String 
        i.setItemCallNumber(itemDAO.itemcallnumber); // private String 
        i.setItemLost(Integer.parseInt(itemDAO.itemlost)); // private int 
        i.setDateDue(itemDAO.date_due); // private String 
        i.setUri(itemDAO.uri); // private String 
        i.setDateLastSeen(itemDAO.datelastseen); // private String 
        i.setHomeBranch(itemDAO.homebranch); // private String 
        i.setHomeBranchName(itemDAO.holdingbranchname); // private String 
        i.setHoldingBranch(itemDAO.holdingbranch); // private String 
        i.setCopyNumber(Integer.parseInt(itemDAO.copynumber)); // private int 

        return i;
    }

    public ItemDAO mapItemToItemDAO(Item item) {
        // TODO

        //ItemDAO i = new ItemDAO();
        //return i;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
