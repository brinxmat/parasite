/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import no.deichman.ls.adapter.KohaAdapterMock;
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
public class KohaAdapterMockTest {
    
    public KohaAdapterMockTest() {
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
     * Test of getItemsByManifestationId method, of class KohaAdapterMock.
     */
    @Test
    public void testGetItemsByManifestationId() {
        System.out.println("getItemsByManifestationId");
        String id = "m1";
        KohaAdapterMock instance = new KohaAdapterMock();
        Model expResult = null;
        Model result = instance.getItemsByManifestationId(id);
        assertNotNull(result);
    }
    
        /*
    Private util-methods
    */
    static final String NS = "http://data.deichman.no/work/";
    static String resource;

    private Model createItemInstanceModel() {
        Model model = ModelFactory.createDefaultModel();
        
        model.add(createId("m1"));
        model.add(createAuthor("Knut Hamsun"));
        model.add(createTitle("Sult"));
        
        return model;
    }
    
    
    
    private static Statement createId(String id) {
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


    static private void setResource(String id) {
        resource = new String(NS + "i" + id);
    }
}
