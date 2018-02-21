
package at.struct.was9bugs.bug18.mywebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.struct.was9bugs.bug18.mywebservice package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MyWebserviceRequest_QNAME = new QName("http://was9bugs.struct.at/Webservice/MyWebservice/", "MyWebserviceRequest");
    private final static QName _MyWebserviceResponse_QNAME = new QName("http://was9bugs.struct.at/Webservice/MyWebservice/", "MyWebserviceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.struct.was9bugs.bug18.mywebservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MyWebserviceResponse }
     * 
     */
    public MyWebserviceResponse createMyWebserviceResponse() {
        return new MyWebserviceResponse();
    }

    /**
     * Create an instance of {@link WebserviceMethod }
     * 
     */
    public WebserviceMethod createWebserviceMethod() {
        return new WebserviceMethod();
    }

    /**
     * Create an instance of {@link MyWebserviceRequest }
     * 
     */
    public MyWebserviceRequest createMyWebserviceRequest() {
        return new MyWebserviceRequest();
    }

    /**
     * Create an instance of {@link WebserviceMethodResponse }
     * 
     */
    public WebserviceMethodResponse createWebserviceMethodResponse() {
        return new WebserviceMethodResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyWebserviceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://was9bugs.struct.at/Webservice/MyWebservice/", name = "MyWebserviceRequest")
    public JAXBElement<MyWebserviceRequest> createMyWebserviceRequest(MyWebserviceRequest value) {
        return new JAXBElement<MyWebserviceRequest>(_MyWebserviceRequest_QNAME, MyWebserviceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyWebserviceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://was9bugs.struct.at/Webservice/MyWebservice/", name = "MyWebserviceResponse")
    public JAXBElement<MyWebserviceResponse> createMyWebserviceResponse(MyWebserviceResponse value) {
        return new JAXBElement<MyWebserviceResponse>(_MyWebserviceResponse_QNAME, MyWebserviceResponse.class, null, value);
    }

}
