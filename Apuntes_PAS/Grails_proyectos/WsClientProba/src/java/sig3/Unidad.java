
package sig3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for unidad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="unidad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcioCurta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcioLlarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiCurt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observacions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipusUnitat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="web" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiEdifici" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiInformat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unidad", propOrder = {
    "codi",
    "descripcioCurta",
    "descripcioLlarga",
    "codiCurt",
    "observacions",
    "tipusUnitat",
    "telefon",
    "email",
    "fax",
    "web",
    "codiEdifici",
    "codiInformat"
})
public class Unidad {

    protected String codi;
    protected String descripcioCurta;
    protected String descripcioLlarga;
    protected String codiCurt;
    protected String observacions;
    protected String tipusUnitat;
    protected String telefon;
    protected String email;
    protected String fax;
    protected String web;
    protected String codiEdifici;
    protected String codiInformat;

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

    /**
     * Gets the value of the descripcioCurta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcioCurta() {
        return descripcioCurta;
    }

    /**
     * Sets the value of the descripcioCurta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcioCurta(String value) {
        this.descripcioCurta = value;
    }

    /**
     * Gets the value of the descripcioLlarga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcioLlarga() {
        return descripcioLlarga;
    }

    /**
     * Sets the value of the descripcioLlarga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcioLlarga(String value) {
        this.descripcioLlarga = value;
    }

    /**
     * Gets the value of the codiCurt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiCurt() {
        return codiCurt;
    }

    /**
     * Sets the value of the codiCurt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiCurt(String value) {
        this.codiCurt = value;
    }

    /**
     * Gets the value of the observacions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacions() {
        return observacions;
    }

    /**
     * Sets the value of the observacions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacions(String value) {
        this.observacions = value;
    }

    /**
     * Gets the value of the tipusUnitat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipusUnitat() {
        return tipusUnitat;
    }

    /**
     * Sets the value of the tipusUnitat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipusUnitat(String value) {
        this.tipusUnitat = value;
    }

    /**
     * Gets the value of the telefon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Sets the value of the telefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefon(String value) {
        this.telefon = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the web property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeb() {
        return web;
    }

    /**
     * Sets the value of the web property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeb(String value) {
        this.web = value;
    }

    /**
     * Gets the value of the codiEdifici property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiEdifici() {
        return codiEdifici;
    }

    /**
     * Sets the value of the codiEdifici property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiEdifici(String value) {
        this.codiEdifici = value;
    }

    /**
     * Gets the value of the codiInformat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiInformat() {
        return codiInformat;
    }

    /**
     * Sets the value of the codiInformat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiInformat(String value) {
        this.codiInformat = value;
    }

}
