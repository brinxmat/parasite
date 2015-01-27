package no.deichman.ls.preference;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Preference {

    static Configuration properties = null;

    private static void init() throws ConfigurationException {

        if (properties == null) {
            properties = new PropertiesConfiguration("config.properties");
        }
    }

    public static final String getBaseURI() throws ConfigurationException {

        Preference.init();
        String uri = properties.getProperty("uri.baseuri").toString();
        return uri;

    }

    public static String getSPARQLEndpointURI() throws ConfigurationException {

        Preference.init();
        String uri = properties.getProperty("uri.baseuri").toString();
        return uri;

    }

    public static String getAllWorksQuery() throws ConfigurationException {
        Preference.init();
        String uri = properties.getProperty("query.getallworks").toString();
        System.out.println(uri);
        return uri;
    }

    public static String listWorks() throws ConfigurationException {
        Preference.init();
        String uri = properties.getProperty("query.listworks").toString();
        System.out.println(uri);
        return uri;
    }

    public static String listManifestations() throws ConfigurationException {
        Preference.init();
        String uri = properties.getProperty("query.listmanifestations").toString();
        System.out.println(uri);
        return uri;
    }

}
