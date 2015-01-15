package no.deichman.ls.consumer;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

import no.deichman.ls.consumer.JSONClientDefault;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class TestJSONClientDefault {

    @Test
    public void test() throws IOException {

        JSONClientDefault getJson = new JSONClientDefault();

        assertNotNull("Class GetJson is implemented", getJson.getClass());

        testConnect();
    }

    public void testConnect() throws IOException {
        JSONClientDefault getJson = new JSONClientDefault();
        URL url = this.getClass().getResource("/testJsonConnect.json");
        String expected = StringUtils.trim(IOUtils.toString(url, "UTF-8"));
        String actual = getJson.connect("http://www.ntnu.no/ub/digital/document/ntnu203");

        assertEquals("GetJson.connect", expected, actual);

    }

}
