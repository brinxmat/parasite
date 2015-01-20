/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import java.io.FileNotFoundException;
import java.util.HashMap;

import com.hp.hpl.jena.rdf.model.Model;

import no.deichman.ls.domain.Work;

/**
 *
 * @author sbd
 */
public interface DataDeichmanAdapter {

    Model getWork(String id) throws FileNotFoundException;

    Model getWorkList();
    
    Model getAllWorks(String type, int limit, int offset);
    
}
