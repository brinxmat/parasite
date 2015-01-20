/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.util.HashMap;
import no.deichman.ls.domain.Work;

/**
 *
 * @author sbd
 */
public class DataDeichmanAdapterMock implements DataDeichmanAdapter {

    private HashMap<String, Work> workList = new HashMap<String, Work>();

    public DataDeichmanAdapterMock() {
        createMockList();
    }

    @Override
    public Model getWorkList() {
        Model model = ModelFactory.createDefaultModel();
        // todo map mocklist to model
        return model;
    }

    @Override
    public Model getWork(String id) {
        Model model = ModelFactory.createDefaultModel();
        // todo map work to model
        return model;
    }

    private void createMockList() {
        Work workItem1 = new Work("1", "Sult", "Knut Hamsun", 22.20);
        workList.put(workItem1.getId(), workItem1);
        Work workItem2 = new Work("2", "Sykkelrytteren", "Tim Krabbé", 22.20);
        workList.put(workItem2.getId(), workItem2);

    }

    @Override
    public Model getAllWorks(String type, int limit, int offset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
