/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.mapper;

import com.hp.hpl.jena.rdf.model.Model;
import no.deichman.ls.dao.ItemDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sbd
 */
public class ItemMapperTest {
    
    public ItemMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of mapItemDAOToItem method, of class ItemMapper.
     */
    @Test
    public void testMapItemDAOToItem() {
        System.out.println("mapItemDAOToItem");
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.barcode = "1";
        ItemMapper instance = new ItemMapper();
        Model expResult = null;
        Model result = instance.mapItemDAOToModel(itemDAO);
        assertNotNull(result);
    }    
}
