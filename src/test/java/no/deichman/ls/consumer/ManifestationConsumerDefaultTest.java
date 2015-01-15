/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.consumer;

import java.util.HashMap;
import no.deichman.ls.domain.Manifestation;
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
public class ManifestationConsumerDefaultTest {
    
    public ManifestationConsumerDefaultTest() {
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
     * Test of getManifestationById method, of class ManifestationConsumerDefault.
     */
    @Test
    public void testGetManifestationById() {
        System.out.println("getManifestationById");
        int manifestationId = 626460;
        ManifestationConsumerDefault instance = new ManifestationConsumerDefault();
        Manifestation expResult = null;
        Manifestation result = instance.getManifestationById(manifestationId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getManifestationList method, of class ManifestationConsumerDefault.
     */
    @Test
    public void testGetManifestationList() {
        System.out.println("getManifestationList");
        ManifestationConsumerDefault instance = new ManifestationConsumerDefault();
        HashMap<Integer, Manifestation> expResult = null;
        HashMap<Integer, Manifestation> result = instance.getManifestationList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManifestationsByWorkId method, of class ManifestationConsumerDefault.
     */
    @Test
    public void testGetManifestationsByWorkId() {
        System.out.println("getManifestationsByWorkId");
        int id = 0;
        ManifestationConsumerDefault instance = new ManifestationConsumerDefault();
        HashMap<Integer, Manifestation> expResult = null;
        HashMap<Integer, Manifestation> result = instance.getManifestationsByWorkId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
