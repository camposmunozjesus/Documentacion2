
package edu.upc.spa.rebutnomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Missatges" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZhrPortalNouErrorsTable"/>
 *         &lt;element name="Pdf" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "missatges",
    "pdf"
})
@XmlRootElement(name = "ZhrPortalNouRebutNominaResponse")
public class ZhrPortalNouRebutNominaResponse {

    @XmlElement(name = "Missatges", required = true)
    protected ZhrPortalNouErrorsTable missatges;
    @XmlElement(name = "Pdf", required = true)
    protected byte[] pdf;

    /**
     * Gets the value of the missatges property.
     * 
     * @return
     *     possible object is
     *     {@link ZhrPortalNouErrorsTable }
     *     
     */
    public ZhrPortalNouErrorsTable getMissatges() {
        return missatges;
    }

    /**
     * Sets the value of the missatges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZhrPortalNouErrorsTable }
     *     
     */
    public void setMissatges(ZhrPortalNouErrorsTable value) {
        this.missatges = value;
    }

    /**
     * Gets the value of the pdf property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPdf() {
        return pdf;
    }

    /**
     * Sets the value of the pdf property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPdf(byte[] value) {
        this.pdf = ((byte[]) value);
    }

}
