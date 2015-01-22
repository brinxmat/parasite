/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author sbd
 */
public class KohaAdapterDefaultIT {
    
    public KohaAdapterDefaultIT() {
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
     * Test of getItemsByManifestationId method, of class KohaAdapterDefault.
     */
    @Test
    public void testGetItemsByManifestationId() {
        System.out.println("getItemsByManifestationId");
        String manifestationId = "";
        KohaAdapterDefault instance = new KohaAdapterDefault();
        Model expResult = null;
        Model result = instance.getItemsByManifestationId(manifestationId);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        //assertEquals(expResult, result);
    }

    /**
     * Test of getItemById method, of class KohaAdapterDefault.
     */
    @Ignore
    @Test
    public void testGetItemById() {
        System.out.println("getItemById");
        String id = "";
        KohaAdapterDefault instance = new KohaAdapterDefault();
        Model expResult = null;
        Model result = instance.getItemById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemList method, of class KohaAdapterDefault.
     */
    @Ignore
    @Test
    public void testGetItemList() {
        System.out.println("getItemList");
        KohaAdapterDefault instance = new KohaAdapterDefault();
        Model expResult = null;
        Model result = instance.getItemList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
