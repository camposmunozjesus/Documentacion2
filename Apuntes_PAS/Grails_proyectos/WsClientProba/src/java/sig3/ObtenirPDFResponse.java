
package sig3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for obtenirPDFResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="obtenirPDFResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="obtenirPDFReturn" type="{http://sig3/}contenidorPDF" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenirPDFResponse", propOrder = {
    "obtenirPDFReturn"
})
public class ObtenirPDFResponse {

    protected ContenidorPDF obtenirPDFReturn;

    /**
     * Gets the value of the obtenirPDFReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ContenidorPDF }
     *     
     */
    public ContenidorPDF getObtenirPDFReturn() {
        return obtenirPDFReturn;
    }

    /**
     * Sets the value of the obtenirPDFReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContenidorPDF }
     *     
     */
    public void setObtenirPDFReturn(ContenidorPDF value) {
        this.obtenirPDFReturn = value;
    }

}
