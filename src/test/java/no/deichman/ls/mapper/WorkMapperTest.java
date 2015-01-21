/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.mapper;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
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
public class WorkMapperTest {
    static final String NS = "http://data.deichman.no/work/";
    static String resource;

    public WorkMapperTest() {
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
     * Test of mapWorkToModel method, of class WorkMapper.
     */
    @Test
    public void testMapWorkToModel() {
        System.out.println("mapWorkToModel");
        Work work = createWorkInstanceWork();
        Model expResult = createWorkInstanceModel();
        Model result = WorkMapper.mapWorkToModel(work);
        assertNotNull(result);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of mapModelToWork method, of class WorkMapper.
     */
    @Ignore
    @Test
    public void testMapModelToWork() {
        System.out.println("mapModelToWork");
        Model model = createWorkInstanceModel();
        Work expResult = createWorkInstanceWork();
        Work result = WorkMapper.mapModelToWork(model);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /*
    Private util-methods
    */
    private Model createWorkInstanceModel() {
        Model model = ModelFactory.createDefaultModel();
        
        model.add(createId("1"));
        model.add(createAuthor("Knut Hamsun"));
        model.add(createTitle("Sult"));
        
        return model;
    }

    private Work createWorkInstanceWork() {
        Work work = new Work();
        work.setId("1");
        work.setAuthor("Hamsun");
        work.setTitle("Sult");

        return work;
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
        resource = new String(NS + "w" + id);
    }
}