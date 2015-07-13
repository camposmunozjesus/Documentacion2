
package sig3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contenidorPDF complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contenidorPDF">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentPDF" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contenidorPDF", propOrder = {
    "documentPDF",
    "error"
})
public class ContenidorPDF {

    protected byte[] documentPDF;
    protected int error;

    /**
     * Gets the value of the documentPDF property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDocumentPDF() {
        return documentPDF;
    }

    /**
     * Sets the value of the documentPDF property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDocumentPDF(byte[] value) {
        this.documentPDF = value;
    }

    /**
     * Gets the value of the error property.
     * 
     */
    public int getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     */
    public void setError(int value) {
        this.error = value;
    }

}
