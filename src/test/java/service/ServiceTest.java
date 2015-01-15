/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
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
        HashMap<Integer, Work> expResult = null;
        HashMap<Integer, Work> result = instance.retriveWorkList();
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
        HashMap<Integer, Manifestation> expResult = null;
        HashMap<Integer, Manifestation> result = instance.retriveManifestationList();
        assertNotNull(result);
        // assertEquals(expResult, result);
    }

    /**
     * Test of retriveWorkById method, of class Service.
     */
    @Test
    public void testRetriveWorkById() {
        System.out.println("retriveWorkById");
        int id = 1;
        Service instance = new Service();
        Work expResult = null;
        Work result = instance.retriveWorkById(id);
        assertNotNull(result);
        // assertEquals(expResult, result);
    }

    /**
     * Test of retriveManifestationById method, of class Service.
     */
    @Test
    public void testRetriveManifestationById() {
        System.out.println("retriveManifestationById");
        int id = 1;
        Service instance = new Service();
        Manifestation expResult = null;
        Manifestation result = instance.retriveManifestationById(id);
        assertNotNull(result);        
        // assertEquals(expResult, result);
    }
    
}
