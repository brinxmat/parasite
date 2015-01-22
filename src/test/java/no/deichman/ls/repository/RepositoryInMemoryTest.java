/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.repository;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import no.deichman.ls.preference.Preference;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
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
public class RepositoryInMemoryTest {

    static final String BASE_URI = "http://example.com/";
    static String resource;
    
    static final String WORK_ID = "w1";
    static final String MANIFESTATION_ID = "m1";
    static final String ITEM_ID = "i1";

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
        instance.createWork(w);
        Model expResult = w;
        System.out.println("expResult");
        RDFDataMgr.write(System.out, expResult, Lang.JSONLD);
        Model result = instance.retrieveWork(BASE_URI + "work/" + WORK_ID);
        System.out.println("result");
        RDFDataMgr.write(System.out, result, Lang.JSONLD);
        assertNotNull(result);
        assertTrue(result.containsAll(expResult));
    }

    /**
     * Test of createWork method, of class RepositoryInMemory.
     */
    @Test
    public void testCreateWork() {
        System.out.println("createWork");
        Model work = createWorkInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        Model expResult = work;
        Model result = instance.createWork(work);
        System.out.println("expResult");
        RDFDataMgr.write(System.out, expResult, Lang.JSONLD);
        System.out.println("result");
        RDFDataMgr.write(System.out, result, Lang.JSONLD);
        assertNotNull(result);
        assertTrue(result.containsAll(expResult));
    }

    /**
     * Test of createManifestation method, of class RepositoryInMemory.
     */
    @Test
    public void testCreateManifestation() {
        System.out.println("createManifestation");
        Model manifestation = createManifestationInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        Model expResult = manifestation;
        Model result = instance.createManifestation(manifestation);
        assertNotNull(result);
        assertTrue(result.containsAll(expResult));
    }

    /**
     * Test of createItem method, of class RepositoryInMemory.
     */
    @Test
    public void testCreateItem() {
        System.out.println("createItem");
        Model item = createItemInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        Model expResult = null;
        Model result = instance.createItem(item);
        assertNotNull(result);
    }

    
    /**
     * Test of deleteWork method, of class RepositoryInMemory.
     */
    @Ignore
    @Test
    public void testDeleteWork() {
        System.out.println("deleteWork");
        String id = "";
        RepositoryInMemory instance = new RepositoryInMemory();
        instance.deleteWork(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveManifestation method, of class RepositoryInMemory.
     */
    @Test
    public void testRetrieveManifestation() {
        System.out.println("retrieveManifestation");
        RepositoryInMemory instance = new RepositoryInMemory();
        Model m = createManifestationInstance();
        instance.createManifestation(m);
        Model expResult = m;
        System.out.println("expResult");
        RDFDataMgr.write(System.out, expResult, Lang.JSONLD);
        Model result = instance.retrieveWork(BASE_URI + "manifestation/" + MANIFESTATION_ID);
        System.out.println("result");
        RDFDataMgr.write(System.out, result, Lang.JSONLD);
        assertNotNull(result);
        assertTrue(result.containsAll(expResult));
    }

    /**
     * Test of deleteManifestation method, of class RepositoryInMemory.
     */
    @Ignore
    @Test
    public void testDeleteManifestation() {
        System.out.println("deleteManifestation");
        String id = "";
        RepositoryInMemory instance = new RepositoryInMemory();
        instance.deleteManifestation(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveItem method, of class RepositoryInMemory.
     */
    @Test
    public void testRetrieveItem() {
        System.out.println("retrieveItem");
        RepositoryInMemory instance = new RepositoryInMemory();
        Model i = createItemInstance();
        instance.createManifestation(i);
        Model expResult = i;
        System.out.println("expResult");
        RDFDataMgr.write(System.out, expResult, Lang.JSONLD);
        Model result = instance.retrieveWork(BASE_URI + "item/" + ITEM_ID);
        System.out.println("result");
        RDFDataMgr.write(System.out, result, Lang.JSONLD);
        assertNotNull(result);
        assertTrue(result.containsAll(expResult));
    }

    /**
     * Test of deleteItem method, of class RepositoryInMemory.
     */
    @Ignore
    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");
        String id = "";
        RepositoryInMemory instance = new RepositoryInMemory();
        instance.deleteItem(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listWorks method, of class RepositoryInMemory.
     */
    @Ignore
    @Test
    public void testListWorks() {
        System.out.println("listWorks");
        RepositoryInMemory instance = new RepositoryInMemory();
        Model expResult = null;
        Model result = instance.listWorks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listManifestations method, of class RepositoryInMemory.
     */
    @Ignore
    @Test
    public void testListManifestations() {
        System.out.println("listManifestations");
        RepositoryInMemory instance = new RepositoryInMemory();
        Model expResult = null;
        Model result = instance.listManifestations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listItems method, of class RepositoryInMemory.
     */
    @Ignore
    @Test
    public void testListItems() {
        System.out.println("listItems");
        RepositoryInMemory instance = new RepositoryInMemory();
        Model expResult = null;
        Model result = instance.listItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /*
     Private util-methods
     */
    private static Model createWorkInstance() {
        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", BASE_URI + "work/");
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(createWorkId(WORK_ID));
        model.add(createAuthor("Knut Hamsun"));
        model.add(createTitle("Sult"));

        return model;
    }

    private static Model createManifestationInstance() {

        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", BASE_URI + "manifestation/");
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(createManifestationId(MANIFESTATION_ID));

        return model;
    }

    private static Model createItemInstance() {
        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", BASE_URI + "item/");
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(createItemId(ITEM_ID));

        return model;
    }

    private static Statement createManifestationId(String id) {
        setResource("manifestation", id);
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        Resource o = ResourceFactory.createResource("http://purl.org/vocab/frbr/core#Manifestation");

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement createWorkId(String id) {
        setResource("work", id);
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        Resource o = ResourceFactory.createResource("http://purl.org/vocab/frbr/core#Work");

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement createTitle(String title) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/dc/terms/title");
        Literal o = ResourceFactory.createTypedLiteral(title);

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement createAuthor(String author) {
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://purl.org/dc/terms/creator");
        Resource o = ResourceFactory.createResource(author);

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement createItemId(String id) {
        setResource("item", id);
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        Resource o = ResourceFactory.createResource("http://purl.org/vocab/frbr/core#Item");

        return ResourceFactory.createStatement(s, p, o);
    }

    static private void setResource(String ns, String id) {
        resource = new String(BASE_URI + ns + "/" + id);
    }
}
