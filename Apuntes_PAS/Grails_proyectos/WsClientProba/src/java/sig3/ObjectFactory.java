
package sig3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sig3 package. 
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

    private final static QName _ObtenirPDFResponse_QNAME = new QName("http://sig3/", "obtenirPDFResponse");
    private final static QName _ObtenirPDF_QNAME = new QName("http://sig3/", "obtenirPDF");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sig3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenirPDFResponse }
     * 
     */
    public ObtenirPDFResponse createObtenirPDFResponse() {
        return new ObtenirPDFResponse();
    }

    /**
     * Create an instance of {@link ObtenirPDF }
     * 
     */
    public ObtenirPDF createObtenirPDF() {
        return new ObtenirPDF();
    }

    /**
     * Create an instance of {@link ContenidorPDF }
     * 
     */
    public ContenidorPDF createContenidorPDF() {
        return new ContenidorPDF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenirPDFResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sig3/", name = "obtenirPDFResponse")
    public JAXBElement<ObtenirPDFResponse> createObtenirPDFResponse(ObtenirPDFResponse value) {
        return new JAXBElement<ObtenirPDFResponse>(_ObtenirPDFResponse_QNAME, ObtenirPDFResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenirPDF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sig3/", name = "obtenirPDF")
    public JAXBElement<ObtenirPDF> createObtenirPDF(ObtenirPDF value) {
        return new JAXBElement<ObtenirPDF>(_ObtenirPDF_QNAME, ObtenirPDF.class, null, value);
    }

}
