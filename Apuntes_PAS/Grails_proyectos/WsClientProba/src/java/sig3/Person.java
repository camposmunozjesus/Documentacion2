
package sig3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pernr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sexe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cognom1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cognom2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificacio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipusDocument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="naixement" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="codiPostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poblacio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuari" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="horesSemanals" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = {
    "pernr",
    "sexe",
    "cognom1",
    "cognom2",
    "nom",
    "identificacio",
    "tipusDocument",
    "naixement",
    "codiPostal",
    "poblacio",
    "provincia",
    "pais",
    "usuari",
    "correu",
    "horesSemanals"
})
public class Person {

    protected int pernr;
    protected String sexe;
    protected String cognom1;
    protected String cognom2;
    protected String nom;
    protected String identificacio;
    protected String tipusDocument;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar naixement;
    protected String codiPostal;
    protected String poblacio;
    protected String provincia;
    protected String pais;
    protected String usuari;
    protected String correu;
    protected Double horesSemanals;

    /**
     * Gets the value of the pernr property.
     * 
     */
    public int getPernr() {
        return pernr;
    }

    /**
     * Sets the value of the pernr property.
     * 
     */
    public void setPernr(int value) {
        this.pernr = value;
    }

    /**
     * Gets the value of the sexe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * Sets the value of the sexe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexe(String value) {
        this.sexe = value;
    }

    /**
     * Gets the value of the cognom1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognom1() {
        return cognom1;
    }

    /**
     * Sets the value of the cognom1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognom1(String value) {
        this.cognom1 = value;
    }

    /**
     * Gets the value of the cognom2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognom2() {
        return cognom2;
    }

    /**
     * Sets the value of the cognom2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognom2(String value) {
        this.cognom2 = value;
    }

    /**
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Gets the value of the identificacio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificacio() {
        return identificacio;
    }

    /**
     * Sets the value of the identificacio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificacio(String value) {
        this.identificacio = value;
    }

    /**
     * Gets the value of the tipusDocument property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipusDocument() {
        return tipusDocument;
    }

    /**
     * Sets the value of the tipusDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipusDocument(String value) {
        this.tipusDocument = value;
    }

    /**
     * Gets the value of the naixement property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNaixement() {
        return naixement;
    }

    /**
     * Sets the value of the naixement property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNaixement(XMLGregorianCalendar value) {
        this.naixement = value;
    }

    /**
     * Gets the value of the codiPostal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiPostal() {
        return codiPostal;
    }

    /**
     * Sets the value of the codiPostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiPostal(String value) {
        this.codiPostal = value;
    }

    /**
     * Gets the value of the poblacio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoblacio() {
        return poblacio;
    }

    /**
     * Sets the value of the poblacio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoblacio(String value) {
        this.poblacio = value;
    }

    /**
     * Gets the value of the provincia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Sets the value of the provincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvincia(String value) {
        this.provincia = value;
    }

    /**
     * Gets the value of the pais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Sets the value of the pais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

    /**
     * Gets the value of the usuari property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuari() {
        return usuari;
    }

    /**
     * Sets the value of the usuari property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuari(String value) {
        this.usuari = value;
    }

    /**
     * Gets the value of the correu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreu() {
        return correu;
    }

    /**
     * Sets the value of the correu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreu(String value) {
        this.correu = value;
    }

    /**
     * Gets the value of the horesSemanals property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHoresSemanals() {
        return horesSemanals;
    }

    /**
     * Sets the value of the horesSemanals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHoresSemanals(Double value) {
        this.horesSemanals = value;
    }

}
