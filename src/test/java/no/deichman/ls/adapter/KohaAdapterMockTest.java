/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;
import no.deichman.ls.adapter.KohaAdapterMock;
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
public class KohaAdapterMockTest {
    
    public KohaAdapterMockTest() {
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
     * Test of getItemsByManifestationId method, of class KohaAdapterMock.
     */
    @Test
    public void testGetItemsByManifestationId() {
        System.out.println("getItemsByManifestationId");
        String id = "";
        KohaAdapterMock instance = new KohaAdapterMock();
        Model expResult = null;
        Model result = instance.getItemsByManifestationId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
