/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.hp.hpl.jena.rdf.model.Model;
import java.util.HashMap;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;
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
public class ServiceDefaultTest {
    
    public ServiceDefaultTest() {
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
     * Test of retriveWorkList method, of class ServiceDefault.
     */
    @Test
    public void testRetriveWorkList() {
        System.out.println("retriveWorkList");
        ServiceDefault instance = new ServiceDefault();
        HashMap<String, Work> expResult = null;
        HashMap<String, Work> result = instance.retriveWorkList();
        assertNotNull(result);
        // assertEquals(expResult, result);
    }

    /**
     * Test of retriveManifestationById method, of class ServiceDefault.
     */
    @Ignore
    @Test
    public void testRetriveManifestationById() {
        System.out.println("retriveManifestationById");
        String id = "1";
        ServiceDefault instance = new ServiceDefault();
        Model expResult = null;
        Model result = instance.retriveManifestationById(id);
        assertNotNull(result);        
        // assertEquals(expResult, result);
    }    
}
