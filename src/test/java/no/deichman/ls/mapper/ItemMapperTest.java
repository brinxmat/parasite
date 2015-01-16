/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.mapper;

import no.deichman.ls.dao.ItemDAO;
import no.deichman.ls.domain.Item;
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
        Item expResult = null;
        Item result = instance.mapItemDAOToItem(itemDAO);
        assertNotNull(result);
        assertEquals(itemDAO.barcode ,result.getId());
    }

//    /**
//     * Test of mapItemToItemDAO method, of class ItemMapper.
//     */
//    @Test
//    public void testMapItemToItemDAO() {
//        System.out.println("mapItemToItemDAO");
//        Item item = null;
//        ItemMapper instance = new ItemMapper();
//        ItemDAO expResult = null;
//        ItemDAO result = instance.mapItemToItemDAO(item);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
