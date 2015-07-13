
package sig3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for puesto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="puesto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInici" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataFi" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="vigent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcioCurta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcioLlarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idOcupant" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="funcio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="funcioSpa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="edifici" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipusJornada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="horesSetmanals" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ambit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="familia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="campus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="espai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="laboratori" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="horesAnuals" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="primerCognom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segonCognom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "puesto", propOrder = {
    "codi",
    "dataInici",
    "dataFi",
    "vigent",
    "descripcioCurta",
    "descripcioLlarga",
    "unitat",
    "idOcupant",
    "funcio",
    "funcioSpa",
    "edifici",
    "tipusJornada",
    "horesSetmanals",
    "ambit",
    "familia",
    "campus",
    "espai",
    "laboratori",
    "horesAnuals",
    "primerCognom",
    "segonCognom",
    "nom"
})
public class Puesto {

    protected String codi;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInici;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFi;
    protected String vigent;
    protected String descripcioCurta;
    protected String descripcioLlarga;
    protected String unitat;
    protected Integer idOcupant;
    protected Long funcio;
    protected String funcioSpa;
    protected String edifici;
    protected String tipusJornada;
    protected Double horesSetmanals;
    protected String ambit;
    protected String familia;
    protected String campus;
    protected String espai;
    protected String laboratori;
    protected Integer horesAnuals;
    protected String primerCognom;
    protected String segonCognom;
    protected String nom;

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
     * Gets the value of the dataInici property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInici() {
        return dataInici;
    }

    /**
     * Sets the value of the dataInici property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInici(XMLGregorianCalendar value) {
        this.dataInici = value;
    }

    /**
     * Gets the value of the dataFi property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFi() {
        return dataFi;
    }

    /**
     * Sets the value of the dataFi property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFi(XMLGregorianCalendar value) {
        this.dataFi = value;
    }

    /**
     * Gets the value of the vigent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVigent() {
        return vigent;
    }

    /**
     * Sets the value of the vigent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVigent(String value) {
        this.vigent = value;
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
     * Gets the value of the unitat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitat() {
        return unitat;
    }

    /**
     * Sets the value of the unitat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitat(String value) {
        this.unitat = value;
    }

    /**
     * Gets the value of the idOcupant property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdOcupant() {
        return idOcupant;
    }

    /**
     * Sets the value of the idOcupant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdOcupant(Integer value) {
        this.idOcupant = value;
    }

    /**
     * Gets the value of the funcio property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFuncio() {
        return funcio;
    }

    /**
     * Sets the value of the funcio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFuncio(Long value) {
        this.funcio = value;
    }

    /**
     * Gets the value of the funcioSpa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncioSpa() {
        return funcioSpa;
    }

    /**
     * Sets the value of the funcioSpa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncioSpa(String value) {
        this.funcioSpa = value;
    }

    /**
     * Gets the value of the edifici property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdifici() {
        return edifici;
    }

    /**
     * Sets the value of the edifici property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdifici(String value) {
        this.edifici = value;
    }

    /**
     * Gets the value of the tipusJornada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipusJornada() {
        return tipusJornada;
    }

    /**
     * Sets the value of the tipusJornada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipusJornada(String value) {
        this.tipusJornada = value;
    }

    /**
     * Gets the value of the horesSetmanals property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHoresSetmanals() {
        return horesSetmanals;
    }

    /**
     * Sets the value of the horesSetmanals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHoresSetmanals(Double value) {
        this.horesSetmanals = value;
    }

    /**
     * Gets the value of the ambit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmbit() {
        return ambit;
    }

    /**
     * Sets the value of the ambit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmbit(String value) {
        this.ambit = value;
    }

    /**
     * Gets the value of the familia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilia() {
        return familia;
    }

    /**
     * Sets the value of the familia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilia(String value) {
        this.familia = value;
    }

    /**
     * Gets the value of the campus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Sets the value of the campus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampus(String value) {
        this.campus = value;
    }

    /**
     * Gets the value of the espai property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspai() {
        return espai;
    }

    /**
     * Sets the value of the espai property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspai(String value) {
        this.espai = value;
    }

    /**
     * Gets the value of the laboratori property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaboratori() {
        return laboratori;
    }

    /**
     * Sets the value of the laboratori property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaboratori(String value) {
        this.laboratori = value;
    }

    /**
     * Gets the value of the horesAnuals property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHoresAnuals() {
        return horesAnuals;
    }

    /**
     * Sets the value of the horesAnuals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHoresAnuals(Integer value) {
        this.horesAnuals = value;
    }

    /**
     * Gets the value of the primerCognom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerCognom() {
        return primerCognom;
    }

    /**
     * Sets the value of the primerCognom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerCognom(String value) {
        this.primerCognom = value;
    }

    /**
     * Gets the value of the segonCognom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegonCognom() {
        return segonCognom;
    }

    /**
     * Sets the value of the segonCognom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegonCognom(String value) {
        this.segonCognom = value;
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

}
