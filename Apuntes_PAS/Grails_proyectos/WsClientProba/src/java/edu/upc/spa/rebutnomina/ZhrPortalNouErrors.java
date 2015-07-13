
package edu.upc.spa.rebutnomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZhrPortalNouErrors complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZhrPortalNouErrors">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tipus" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Codi" type="{urn:sap-com:document:sap:rfc:functions}char2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZhrPortalNouErrors", propOrder = {
    "tipus",
    "codi"
})
public class ZhrPortalNouErrors {

    @XmlElement(name = "Tipus", required = true)
    protected String tipus;
    @XmlElement(name = "Codi", required = true)
    protected String codi;

    /**
     * Gets the value of the tipus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipus() {
        return tipus;
    }

    /**
     * Sets the value of the tipus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipus(String value) {
        this.tipus = value;
    }

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
