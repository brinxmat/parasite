/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;
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
public class ServiceTest {
    
    public ServiceTest() {
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
     * Test of retriveWorkList method, of class Service.
     */
    @Test
    public void testRetriveWorkList() {
        System.out.println("retriveWorkList");
        Service instance = new Service();
        HashMap<String, Work> expResult = null;
        HashMap<String, Work> result = instance.retriveWorkList();
        assertNotNull(result);
        // assertEquals(expResult, result);
    }

    /**
     * Test of retriveManifestationById method, of class Service.
     */
    @Test
    public void testRetriveManifestationById() {
        System.out.println("retriveManifestationById");
        String id = "1";
        Service instance = new Service();
        Manifestation expResult = null;
        Manifestation result = instance.retriveManifestationById(id);
        assertNotNull(result);        
        // assertEquals(expResult, result);
    }

    /**
     * Test of retriveManifestationList method, of class Service.
     */
    @Test
    public void testRetriveManifestationList() {
        System.out.println("retriveManifestationList");
        Service instance = new Service();
        HashMap<String, Manifestation> expResult = null;
        HashMap<String, Manifestation> result = instance.retriveManifestationList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retriveWorkById method, of class Service.
     */
    @Test
    public void testRetriveWorkById() {
        System.out.println("retriveWorkById");
        String id = "0";
        Service instance = new Service();
        Work expResult = null;
        Work result = instance.retriveWorkById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retriveItemById method, of class Service.
     */
    @Test
    public void testRetriveItemById() {
        System.out.println("retriveItemById");
        String id = "0";
        Service instance = new Service();
        Item expResult = null;
        Item result = instance.retriveItemById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
