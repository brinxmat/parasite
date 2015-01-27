/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.service;

import no.deichman.ls.service.ServiceDefault;
import no.deichman.ls.service.Service;
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
        Service instance = new ServiceDefault();
        Model expResult = null;
        Model result = instance.retriveWorkList();
        assertNotNull(result);
        // assertEquals(expResult, result);
    }

    /**
     * Test of retriveManifestationById method, of class ServiceDefault.
     */
    @Test
    public void testRetriveManifestationById() {
        System.out.println("retriveManifestationById");
        String id = "m1";
        ServiceDefault instance = new ServiceDefault();
        Model expResult = null;
        Model result = instance.retriveManifestationById(id);
        assertNotNull(result);        
        // assertEquals(expResult, result);
    }    

    /**
     * Test of retriveManifestationList method, of class ServiceDefault.
     */
    @Test
    public void testRetriveManifestationList() {
        System.out.println("retriveManifestationList");
        ServiceDefault instance = new ServiceDefault();
        Model expResult = null;
        Model result = instance.retriveManifestationList();
        assertNotNull(result);
    }

    /**
     * Test of retriveWorkById method, of class ServiceDefault.
     */
    @Test
    public void testRetriveWorkById() {
        System.out.println("retriveWorkById");
        String id = "";
        ServiceDefault instance = new ServiceDefault();
        Model expResult = null;
        Model result = instance.retriveWorkById(id);
        assertNotNull(result);
    }

    /**
     * Test of retriveItemByManifestationId method, of class ServiceDefault.
     */
    @Test
    public void testRetriveItemByManifestationId() {
        System.out.println("retriveItemByManifestationId");
        String id = "";
        ServiceDefault instance = new ServiceDefault();
        Model expResult = null;
        Model result = instance.retriveItemByManifestationId(id);
        assertNotNull(result);
    }

    /**
     * Test of retriveItemById method, of class ServiceDefault.
     */
    @Ignore
    @Test
    public void testRetriveItemById() {
        System.out.println("retriveItemById");
        String id = "";
        ServiceDefault instance = new ServiceDefault();
        Model expResult = null;
        Model result = instance.retriveItemById(id);
        assertNotNull(result);
    }

    /**
     * Test of retriveItemList method, of class ServiceDefault.
     */
    @Ignore
    @Test
    public void testRetriveItemList() {
        System.out.println("retriveItemList");
        ServiceDefault instance = new ServiceDefault();
        Model expResult = null;
        Model result = instance.retriveItemList();
        assertNotNull(result);
    }

    /**
     * Test of runQuery method, of class ServiceDefault.
     */
    @Test
    public void testRunQuery() {
        System.out.println("runQuery");
        String query = queryString();
        ServiceDefault instance = new ServiceDefault();
        Model expResult = null;
        Model result = instance.runQuery(query);
        assertNotNull(result);
    }
    
    private String queryString() {
        return "CONSTRUCT {?s ?p ?o } WHERE { ?s ?p ?o }";
    }
}
