/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.repository;

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
public class RepositoryInMemoryTest {
    
    public RepositoryInMemoryTest() {
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
     * Test of retrieveWork method, of class RepositoryInMemory.
     */
//    @Test
//    public void testRetrieveWork() {
//        System.out.println("retrieveWork");
//        RepositoryInMemory instance = new RepositoryInMemory();
//        Work w = createWorkInstance();
//        String id = instance.createWork(w);
//        Work expResult = w;
//        Work result = instance.retrieveWork(id);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of createWork method, of class RepositoryInMemory.
     */
    @Test
    public void testCreateWork() {
        System.out.println("createWork");
        Work work = createWorkInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        String expResult = work.getId();
        String result = instance.createWork(work);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteWork method, of class RepositoryInMemory.
     */
//    @Test
//    public void testDeleteWork() {
//        System.out.println("deleteWork");
//        String id = "";
//        RepositoryInMemory instance = new RepositoryInMemory();
//        instance.deleteWork(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of retrieveManifestation method, of class RepositoryInMemory.
     */
//    @Test
//    public void testRetrieveManifestation() {
//        System.out.println("retrieveManifestation");
//        String id = "";
//        RepositoryInMemory instance = new RepositoryInMemory();
//        Manifestation expResult = null;
//        Manifestation result = instance.retrieveManifestation(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of createManifestation method, of class RepositoryInMemory.
     */
    @Test
    public void testCreateManifestation() {
        System.out.println("createManifestation");
        Manifestation manifestation = createManifestationInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        String expResult = manifestation.getId();
        String result = instance.createManifestation(manifestation);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteManifestation method, of class RepositoryInMemory.
     */
//    @Test
//    public void testDeleteManifestation() {
//        System.out.println("deleteManifestation");
//        String id = "";
//        RepositoryInMemory instance = new RepositoryInMemory();
//        instance.deleteManifestation(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of createItem method, of class RepositoryInMemory.
     */
    @Test
    public void testCreateItem() {
        System.out.println("createItem");
        Item item = createItemInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        String expResult = item.getId();
        String result = instance.createItem(item);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveItem method, of class RepositoryInMemory.
     */
//    @Test
//    public void testRetrieveItem() {
//        System.out.println("retrieveItem");
//        String id = "";
//        RepositoryInMemory instance = new RepositoryInMemory();
//        Item expResult = null;
//        Item result = instance.retrieveItem(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of deleteItem method, of class RepositoryInMemory.
     */
//    @Test
//    public void testDeleteItem() {
//        System.out.println("deleteItem");
//        String id = "";
//        RepositoryInMemory instance = new RepositoryInMemory();
//        instance.deleteItem(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    private Work createWorkInstance () {
        Work work = new Work();
        work.setId("1");
        work.setAuthor("Hamsun");
        work.setTitle("Sult");
        Manifestation m = createManifestationInstance();
        HashMap<String, Manifestation> map = new HashMap<String, Manifestation>();
        map.put(m.getId(), m);
        work.setManifestations(map);
        
        return work;
    }
    
    private Manifestation createManifestationInstance() {
        Manifestation manifestation = new Manifestation();
        manifestation.setId("2");
        manifestation.setWorkId("1");
        manifestation.setIsbn("this-is-a-test-isbn");
        manifestation.setPublicationYear("1999");
        manifestation.setPublisher("ParaSite Inc.");
        Item i = createItemInstance();
        HashMap<String, Item> map = new HashMap<String, Item>();
        map.put(i.getId(), i);
        manifestation.setItems(map);

        return manifestation;
    }
    
    private Item createItemInstance() {
        Item item = new Item();
        item.setId("3");
        item.setManifestationId("2");
        item.setHoldingBranch("The ParaSite Main Library");
        return item;
    }
}
