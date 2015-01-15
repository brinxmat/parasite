package no.deichman.ls.consumer;

import java.io.StringWriter;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class RDFClientDefault implements RdfClient {

    private final Model model = ModelFactory.createDefaultModel();

    public static void main(String[] args) {
		// TODO Auto-generated method stub

    }

    @Override
    public void loadData(String url) {

        RDFDataMgr.read(model, url);
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public String printModel(Lang lang) {

        StringWriter sw = new StringWriter();
        RDFDataMgr.write(sw, model, lang);

        String data = sw.toString();

        return data;
    }

}
