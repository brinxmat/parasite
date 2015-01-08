
package no.deichman.ls.parasite;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/service")
public class Service {
    
    /** Method processing HTTP GET requests, producing "text/turtle" MIME media
     * type.
     * @return String that will be send back as a response of type "text/turtle".
     */
	@Path("work/{id}")
    @GET 
    @Produces("text/turtle;qs=0.1")
    public String getTurtle(@PathParam("id") String id) {
        return "Turtle: " + id;
    }
    /** Method processing HTTP GET requests, producing "text/html" MIME media
     * type.
     * @return String that will be send back as a response of type "text/html".
     */
	@Path("work/{id}")
    @GET 
    @Produces("text/html;qs=2")
    public String getHTML(@PathParam("id") String id) {
        return "<html><body>Requested work was: " + id + "</body></html>";
    }
    /** Method processing HTTP GET requests, producing "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "application/json".
     */
	@Path("work/{id}")
    @GET 
    @Produces("application/json;qs=0.2")
    public String getJSON(@PathParam("id") String id) {
        return "JSON: " + id;
    }
    /** Method processing HTTP GET requests, producing "application/rdf+xml" MIME media
     * type.
     * @return String that will be send back as a response of type "application/rdf+xml".
     */
	@Path("work/{id}")
    @GET 
    @Produces("application/rdf+xml;qs=0.3")
    public String getRDFXML(@PathParam("id") String id) {
        return "RDF/XML: " + id;
    }
                
    
}
