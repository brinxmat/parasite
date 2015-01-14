/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.consumer;

import com.hp.hpl.jena.rdf.model.Model;
import java.util.HashMap;
import no.deichman.ls.domain.Work;
import org.apache.jena.riot.Lang;

/**
 *
 * @author sbd
 */
public class RDFConsumerMock implements RdfConsumer{

    private HashMap<Integer, Work> workList = new HashMap<Integer, Work>();

    public RDFConsumerMock() {
        createMockList();
    }

    public HashMap<Integer, Work> getWorkList() {
        return workList;
    }

    public Work getWork(int id) {
        return workList.get(id);
    }

    private void createMockList() {
        Work workItem1 = new Work(1, "Sult", "Knut Hamsun", 22.20);
        workList.put(workItem1.getId(), workItem1);
        Work workItem2 = new Work(2, "Sykkelrytteren", "Tim Krabbé", 22.20);
        workList.put(workItem2.getId(), workItem2);
    }

    @Override
    public void loadData(String url) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String printModel(Lang lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
