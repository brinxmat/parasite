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

    static final String NS = "http://data.deichman.no/work/";
    static String resource;

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
    @Ignore
    @Test
    public void testRetrieveWork() {
        System.out.println("retrieveWork");
        RepositoryInMemory instance = new RepositoryInMemory();
        Model w = createWorkInstance();
        String id = instance.createWork(w);
        Model expResult = w;
        System.out.println("expResult");
        RDFDataMgr.write(System.out, expResult, Lang.JSONLD);
        Model result = instance.retrieveWork(id);
        System.out.println("result");
        RDFDataMgr.write(System.out, result, Lang.JSONLD);
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
        String expResult = work.toString();
        String result = instance.createWork(work);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of createManifestation method, of class RepositoryInMemory.
     */
    @Test
    public void testCreateManifestation() {
        System.out.println("createManifestation");
        Model manifestation = createManifestationInstance();
        RepositoryInMemory instance = new RepositoryInMemory();
        String expResult = manifestation.toString();
        String result = instance.createManifestation(manifestation);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

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

    /*
     Private util-methods
     */
    private static Model createWorkInstance() {
        Model model = ModelFactory.createDefaultModel();

        model.add(createWorkId("1"));
        model.add(createAuthor("Knut Hamsun"));
        model.add(createTitle("Sult"));

        return model;
    }

    private static Model createManifestationInstance() {

        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", NS);
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(createManifestationId("2"));

        return model;
    }

    private static Model createItemInstance() {
        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("", NS);
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");

        model.add(createItemId("3"));

        return model;
    }

    private static Statement createManifestationId(String id) {
        setResource(id);
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        Resource o = ResourceFactory.createResource("http://purl.org/vocab/frbr/core#Manifestation");

        return ResourceFactory.createStatement(s, p, o);
    }

    private static Statement createWorkId(String id) {
        setResource(id);
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
        setResource(id);
        Resource s = ResourceFactory.createResource(resource);
        Property p = ResourceFactory.createProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
        Resource o = ResourceFactory.createResource("http://purl.org/vocab/frbr/core#Item");

        return ResourceFactory.createStatement(s, p, o);
    }

    static private void setResource(String id) {
        resource = new String(NS + "w" + id);
    }
}
