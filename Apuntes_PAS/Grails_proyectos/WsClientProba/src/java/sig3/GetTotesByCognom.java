
package sig3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTotesByCognom complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTotesByCognom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cognom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTotesByCognom", propOrder = {
    "cognom"
})
public class GetTotesByCognom {

    protected String cognom;

    /**
     * Gets the value of the cognom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognom() {
        return cognom;
    }

    /**
     * Sets the value of the cognom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognom(String value) {
        this.cognom = value;
    }

}
