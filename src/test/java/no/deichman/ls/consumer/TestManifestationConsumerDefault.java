package no.deichman.ls.consumer;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

import no.deichman.ls.consumer.ManifestationConsumerDefault;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class TestManifestationConsumerDefault {

    @Test
    public void test() throws IOException {

        ManifestationConsumerDefault getJson = new ManifestationConsumerDefault();

        assertNotNull("Class GetJson is implemented", getJson.getClass());

        testConnect();
    }

    public void testConnect() throws IOException {
        ManifestationConsumerDefault getJson = new ManifestationConsumerDefault();
        URL url = this.getClass().getResource("/testJsonConnect.json");
        String expected = StringUtils.trim(IOUtils.toString(url, "UTF-8"));
        String actual = getJson.connect("http://www.ntnu.no/ub/digital/document/ntnu203");

        assertEquals("GetJson.connect", expected, actual);

    }

}
