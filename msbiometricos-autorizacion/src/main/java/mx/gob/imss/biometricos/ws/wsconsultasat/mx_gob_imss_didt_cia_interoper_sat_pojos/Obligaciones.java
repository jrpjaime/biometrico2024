
package mx.gob.imss.biometricos.ws.wsconsultasat.mx_gob_imss_didt_cia_interoper_sat_pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Obligaciones complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Obligaciones">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="c_Obligacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cve_pago" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Obligacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_oblig_lc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="f_Alta_Oblig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="f_Baja_Oblig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="f_Efec_A_Oblig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="f_Efec_B_Oblig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="f_fin_Legal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="f_ini_Legal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_Contribucion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Obligaciones", propOrder = {
    "cObligacion",
    "cvePago",
    "dObligacion",
    "dObligLc",
    "fAltaOblig",
    "fBajaOblig",
    "fEfecAOblig",
    "fEfecBOblig",
    "fFinLegal",
    "fIniLegal",
    "tContribucion"
})
public class Obligaciones {

    @XmlElement(name = "c_Obligacion", required = true, nillable = true)
    protected String cObligacion;
    @XmlElement(name = "cve_pago", required = true, nillable = true)
    protected String cvePago;
    @XmlElement(name = "d_Obligacion", required = true, nillable = true)
    protected String dObligacion;
    @XmlElement(name = "d_oblig_lc", required = true, nillable = true)
    protected String dObligLc;
    @XmlElement(name = "f_Alta_Oblig", required = true, nillable = true)
    protected String fAltaOblig;
    @XmlElement(name = "f_Baja_Oblig", required = true, nillable = true)
    protected String fBajaOblig;
    @XmlElement(name = "f_Efec_A_Oblig", required = true, nillable = true)
    protected String fEfecAOblig;
    @XmlElement(name = "f_Efec_B_Oblig", required = true, nillable = true)
    protected String fEfecBOblig;
    @XmlElement(name = "f_fin_Legal", required = true, nillable = true)
    protected String fFinLegal;
    @XmlElement(name = "f_ini_Legal", required = true, nillable = true)
    protected String fIniLegal;
    @XmlElement(name = "t_Contribucion", required = true, nillable = true)
    protected String tContribucion;

    /**
     * Gets the value of the cObligacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCObligacion() {
        return cObligacion;
    }

    /**
     * Sets the value of the cObligacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCObligacion(String value) {
        this.cObligacion = value;
    }

    /**
     * Gets the value of the cvePago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvePago() {
        return cvePago;
    }

    /**
     * Sets the value of the cvePago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvePago(String value) {
        this.cvePago = value;
    }

    /**
     * Gets the value of the dObligacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDObligacion() {
        return dObligacion;
    }

    /**
     * Sets the value of the dObligacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDObligacion(String value) {
        this.dObligacion = value;
    }

    /**
     * Gets the value of the dObligLc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDObligLc() {
        return dObligLc;
    }

    /**
     * Sets the value of the dObligLc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDObligLc(String value) {
        this.dObligLc = value;
    }

    /**
     * Gets the value of the fAltaOblig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAltaOblig() {
        return fAltaOblig;
    }

    /**
     * Sets the value of the fAltaOblig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAltaOblig(String value) {
        this.fAltaOblig = value;
    }

    /**
     * Gets the value of the fBajaOblig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFBajaOblig() {
        return fBajaOblig;
    }

    /**
     * Sets the value of the fBajaOblig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFBajaOblig(String value) {
        this.fBajaOblig = value;
    }

    /**
     * Gets the value of the fEfecAOblig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEfecAOblig() {
        return fEfecAOblig;
    }

    /**
     * Sets the value of the fEfecAOblig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEfecAOblig(String value) {
        this.fEfecAOblig = value;
    }

    /**
     * Gets the value of the fEfecBOblig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEfecBOblig() {
        return fEfecBOblig;
    }

    /**
     * Sets the value of the fEfecBOblig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEfecBOblig(String value) {
        this.fEfecBOblig = value;
    }

    /**
     * Gets the value of the fFinLegal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFinLegal() {
        return fFinLegal;
    }

    /**
     * Sets the value of the fFinLegal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFinLegal(String value) {
        this.fFinLegal = value;
    }

    /**
     * Gets the value of the fIniLegal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIniLegal() {
        return fIniLegal;
    }

    /**
     * Sets the value of the fIniLegal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIniLegal(String value) {
        this.fIniLegal = value;
    }

    /**
     * Gets the value of the tContribucion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTContribucion() {
        return tContribucion;
    }

    /**
     * Sets the value of the tContribucion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTContribucion(String value) {
        this.tContribucion = value;
    }

}
