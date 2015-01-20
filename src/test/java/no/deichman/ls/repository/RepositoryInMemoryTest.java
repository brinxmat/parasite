/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.repository;

import com.hp.hpl.jena.rdf.model.Model;
import no.deichman.ls.domain.Item;
import no.deichman.ls.domain.Manifestation;
import no.deichman.ls.domain.Work;
import no.deichman.ls.mapper.ItemMapper;
import no.deichman.ls.mapper.ManifestationMapper;
import no.deichman.ls.mapper.WorkMapper;
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
    @Test
    public void testRetrieveWork() {
        System.out.println("retrieveWork");
        RepositoryInMemory instance = new RepositoryInMemory();
        Model w = createWorkInstance();
        String id = instance.createWork(w);
        Model expResult = w;
        Model result = instance.retrieveWork(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of createWork method, of class RepositoryInMemory.
     */
    @Test
    public void testCreateWork() {
        System.out.println("createWork");
        Model work = createWorkInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        String expResult = null;
        String result = instance.createWork(work);
        assertNotNull(result);
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
        Model manifestation = createManifestationInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        String expResult = null;
        String result = instance.createManifestation(manifestation);
        assertNotNull(result);
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
        Model item = createItemInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        String expResult = null;
        String result = instance.createItem(item);
        assertNotNull(result);
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
    
    private Model createWorkInstance () {
        Work work = new Work();
        work.setId("1");
        work.setAuthor("Hamsun");
        work.setTitle("Sult");
        
        return WorkMapper.mapWorkToModel(work);
    }
    
    private Model createManifestationInstance() {
        Manifestation manifestation = new Manifestation();
        manifestation.setId("2");
        manifestation.setWorkId("1");
        manifestation.setIsbn("this-is-a-test-isbn");
        manifestation.setPublicationYear("1999");
        manifestation.setPublisher("ParaSite Inc.");

        return ManifestationMapper.mapManifestationToModel(manifestation);
    }
    
    private Model createItemInstance() {
        Item item = new Item();
        item.setId("3");
        item.setManifestationId("2");
        item.setHoldingBranch("The ParaSite Main Library");
        return ItemMapper.mapItemToModel(item);
    }
}
