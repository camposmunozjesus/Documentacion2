
package sig3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getUnidad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUnidad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUnidad", propOrder = {
    "codi"
})
public class GetUnidad {

    @XmlElement(required = true)
    protected String codi;

    /**
     * Gets the value of the codi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodi() {
        return codi;
    }

    /**
     * Sets the value of the codi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodi(String value) {
        this.codi = value;
    }

}
