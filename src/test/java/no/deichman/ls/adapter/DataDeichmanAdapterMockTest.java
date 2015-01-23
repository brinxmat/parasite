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

/**
 *
 * @author sbd
 */
public class DataDeichmanAdapterMockTest {

    public DataDeichmanAdapterMockTest() {
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
     * Test of getManifestationList method, of class KohaAdapterMock.
     */
    @Test
    public void testGetManifestationList() {
        System.out.println("getManifestationList");
        DataDeichmanAdapterMock instance = new DataDeichmanAdapterMock();
        Model expResult = null;
        Model result = instance.getManifestationList();
        //result.write(System.out);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        //assertEquals(expResult, result.size());
    }

    /**
     * Test of getManifestationsByWorkId method, of class KohaAdapterMock.
     */
    @Test
    public void testGetManifestationsByWorkId() {
        System.out.println("getManifestationsByWorkId");
        String id = "w1";
        DataDeichmanAdapterMock instance = new DataDeichmanAdapterMock();
        int expResult = 3;
        Model result = instance.getManifestationsByWorkId(id);
        result.write(System.out);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        //assertEquals(expResult, result.size());
    }

    /**
     * Test of getManifestationById method, of class KohaAdapterMock.
     */
    @Test
    public void testGetManifestationById() {
        System.out.println("getManifestationById");
        String manifestationId = "m1";
        DataDeichmanAdapterMock instance = new DataDeichmanAdapterMock();
        Model expResult = null;
        Model result = instance.getManifestationById(manifestationId);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
