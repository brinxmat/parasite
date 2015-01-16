/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.adapter;

import com.hp.hpl.jena.rdf.model.Model;
import java.util.HashMap;
import no.deichman.ls.domain.Work;
import org.apache.jena.riot.Lang;

/**
 *
 * @author sbd
 */
public class DataDeichmanAdapterMock implements DataDeichmanAdapter {

    private HashMap<Integer, Work> workList = new HashMap<Integer, Work>();

    public DataDeichmanAdapterMock() {
        createMockList();
    }

    @Override
    public HashMap<Integer, Work> getWorkList() {
        return workList;
    }

    @Override
    public Work getWork(int id) {
        return workList.get(id);
    }

    private void createMockList() {
        Work workItem1 = new Work(1, "Sult", "Knut Hamsun", 22.20);
        workList.put(workItem1.getId(), workItem1);
        Work workItem2 = new Work(2, "Sykkelrytteren", "Tim Krabbé", 22.20);
        workList.put(workItem2.getId(), workItem2);
    }
}
