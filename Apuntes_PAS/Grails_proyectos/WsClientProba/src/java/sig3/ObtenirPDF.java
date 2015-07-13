
package sig3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for obtenirPDF complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="obtenirPDF">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataFitxer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDEmpleat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenirPDF", propOrder = {
    "dataFitxer",
    "idEmpleat"
})
public class ObtenirPDF {

    protected String dataFitxer;
    @XmlElement(name = "IDEmpleat")
    protected String idEmpleat;

    /**
     * Gets the value of the dataFitxer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFitxer() {
        return dataFitxer;
    }

    /**
     * Sets the value of the dataFitxer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFitxer(String value) {
        this.dataFitxer = value;
    }

    /**
     * Gets the value of the idEmpleat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDEmpleat() {
        return idEmpleat;
    }

    /**
     * Sets the value of the idEmpleat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDEmpleat(String value) {
        this.idEmpleat = value;
    }

}
