
package mx.gob.imss.biometricos.ws.wsconsultasat.mx_gob_imss_didt_cia_interoper_sat_pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Sucursales complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Sucursales">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Calle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Pais_Residencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Telefono1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Telefono2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="c_ALR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="c_Colonia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="c_Ent_Fed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="c_Localidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="c_Municipio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="c_Sit_Cont_Suc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="c_Sit_Suc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="c_CRH" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_ALR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Colonia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Ent_Fed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_EntreCalle1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_EntreCalle2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Inmueble" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Localidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Municipio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Referencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Sit_Cont_Suc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Sit_Suc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_Vialidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="d_CRH" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="f_Alta_Suc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="n_Establecimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="n_Exterior" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="n_Interior" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_Inmueble" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_Tel1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_Tel2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_Vialidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="caract_domicilio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sucursales", propOrder = {
    "calle",
    "paisResidencia",
    "telefono1",
    "telefono2",
    "calr",
    "cColonia",
    "cEntFed",
    "cLocalidad",
    "cMunicipio",
    "cSitContSuc",
    "cSitSuc",
    "ccrh",
    "cp",
    "dalr",
    "dColonia",
    "dEntFed",
    "dEntreCalle1",
    "dEntreCalle2",
    "dInmueble",
    "dLocalidad",
    "dMunicipio",
    "dReferencia",
    "dSitContSuc",
    "dSitSuc",
    "dVialidad",
    "dcrh",
    "email",
    "fAltaSuc",
    "nEstablecimiento",
    "nExterior",
    "nInterior",
    "tInmueble",
    "tTel1",
    "tTel2",
    "tVialidad",
    "caractDomicilio"
})
public class Sucursales {

    @XmlElement(name = "Calle", required = true, nillable = true)
    protected String calle;
    @XmlElement(name = "Pais_Residencia", required = true, nillable = true)
    protected String paisResidencia;
    @XmlElement(name = "Telefono1", required = true, nillable = true)
    protected String telefono1;
    @XmlElement(name = "Telefono2", required = true, nillable = true)
    protected String telefono2;
    @XmlElement(name = "c_ALR", required = true, nillable = true)
    protected String calr;
    @XmlElement(name = "c_Colonia", required = true, nillable = true)
    protected String cColonia;
    @XmlElement(name = "c_Ent_Fed", required = true, nillable = true)
    protected String cEntFed;
    @XmlElement(name = "c_Localidad", required = true, nillable = true)
    protected String cLocalidad;
    @XmlElement(name = "c_Municipio", required = true, nillable = true)
    protected String cMunicipio;
    @XmlElement(name = "c_Sit_Cont_Suc", required = true, nillable = true)
    protected String cSitContSuc;
    @XmlElement(name = "c_Sit_Suc", required = true, nillable = true)
    protected String cSitSuc;
    @XmlElement(name = "c_CRH", required = true, nillable = true)
    protected String ccrh;
    @XmlElement(required = true, nillable = true)
    protected String cp;
    @XmlElement(name = "d_ALR", required = true, nillable = true)
    protected String dalr;
    @XmlElement(name = "d_Colonia", required = true, nillable = true)
    protected String dColonia;
    @XmlElement(name = "d_Ent_Fed", required = true, nillable = true)
    protected String dEntFed;
    @XmlElement(name = "d_EntreCalle1", required = true, nillable = true)
    protected String dEntreCalle1;
    @XmlElement(name = "d_EntreCalle2", required = true, nillable = true)
    protected String dEntreCalle2;
    @XmlElement(name = "d_Inmueble", required = true, nillable = true)
    protected String dInmueble;
    @XmlElement(name = "d_Localidad", required = true, nillable = true)
    protected String dLocalidad;
    @XmlElement(name = "d_Municipio", required = true, nillable = true)
    protected String dMunicipio;
    @XmlElement(name = "d_Referencia", required = true, nillable = true)
    protected String dReferencia;
    @XmlElement(name = "d_Sit_Cont_Suc", required = true, nillable = true)
    protected String dSitContSuc;
    @XmlElement(name = "d_Sit_Suc", required = true, nillable = true)
    protected String dSitSuc;
    @XmlElement(name = "d_Vialidad", required = true, nillable = true)
    protected String dVialidad;
    @XmlElement(name = "d_CRH", required = true, nillable = true)
    protected String dcrh;
    @XmlElement(required = true, nillable = true)
    protected String email;
    @XmlElement(name = "f_Alta_Suc", required = true, nillable = true)
    protected String fAltaSuc;
    @XmlElement(name = "n_Establecimiento", required = true, nillable = true)
    protected String nEstablecimiento;
    @XmlElement(name = "n_Exterior", required = true, nillable = true)
    protected String nExterior;
    @XmlElement(name = "n_Interior", required = true, nillable = true)
    protected String nInterior;
    @XmlElement(name = "t_Inmueble", required = true, nillable = true)
    protected String tInmueble;
    @XmlElement(name = "t_Tel1", required = true, nillable = true)
    protected String tTel1;
    @XmlElement(name = "t_Tel2", required = true, nillable = true)
    protected String tTel2;
    @XmlElement(name = "t_Vialidad", required = true, nillable = true)
    protected String tVialidad;
    @XmlElement(name = "caract_domicilio", required = true, nillable = true)
    protected String caractDomicilio;

    /**
     * Gets the value of the calle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Sets the value of the calle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalle(String value) {
        this.calle = value;
    }

    /**
     * Gets the value of the paisResidencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisResidencia() {
        return paisResidencia;
    }

    /**
     * Sets the value of the paisResidencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisResidencia(String value) {
        this.paisResidencia = value;
    }

    /**
     * Gets the value of the telefono1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     * Sets the value of the telefono1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono1(String value) {
        this.telefono1 = value;
    }

    /**
     * Gets the value of the telefono2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     * Sets the value of the telefono2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono2(String value) {
        this.telefono2 = value;
    }

    /**
     * Gets the value of the calr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCALR() {
        return calr;
    }

    /**
     * Sets the value of the calr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCALR(String value) {
        this.calr = value;
    }

    /**
     * Gets the value of the cColonia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCColonia() {
        return cColonia;
    }

    /**
     * Sets the value of the cColonia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCColonia(String value) {
        this.cColonia = value;
    }

    /**
     * Gets the value of the cEntFed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEntFed() {
        return cEntFed;
    }

    /**
     * Sets the value of the cEntFed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEntFed(String value) {
        this.cEntFed = value;
    }

    /**
     * Gets the value of the cLocalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLocalidad() {
        return cLocalidad;
    }

    /**
     * Sets the value of the cLocalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLocalidad(String value) {
        this.cLocalidad = value;
    }

    /**
     * Gets the value of the cMunicipio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCMunicipio() {
        return cMunicipio;
    }

    /**
     * Sets the value of the cMunicipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMunicipio(String value) {
        this.cMunicipio = value;
    }

    /**
     * Gets the value of the cSitContSuc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSitContSuc() {
        return cSitContSuc;
    }

    /**
     * Sets the value of the cSitContSuc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSitContSuc(String value) {
        this.cSitContSuc = value;
    }

    /**
     * Gets the value of the cSitSuc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSitSuc() {
        return cSitSuc;
    }

    /**
     * Sets the value of the cSitSuc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSitSuc(String value) {
        this.cSitSuc = value;
    }

    /**
     * Gets the value of the ccrh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCRH() {
        return ccrh;
    }

    /**
     * Sets the value of the ccrh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCRH(String value) {
        this.ccrh = value;
    }

    /**
     * Gets the value of the cp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCp() {
        return cp;
    }

    /**
     * Sets the value of the cp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCp(String value) {
        this.cp = value;
    }

    /**
     * Gets the value of the dalr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDALR() {
        return dalr;
    }

    /**
     * Sets the value of the dalr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDALR(String value) {
        this.dalr = value;
    }

    /**
     * Gets the value of the dColonia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDColonia() {
        return dColonia;
    }

    /**
     * Sets the value of the dColonia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDColonia(String value) {
        this.dColonia = value;
    }

    /**
     * Gets the value of the dEntFed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEntFed() {
        return dEntFed;
    }

    /**
     * Sets the value of the dEntFed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEntFed(String value) {
        this.dEntFed = value;
    }

    /**
     * Gets the value of the dEntreCalle1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEntreCalle1() {
        return dEntreCalle1;
    }

    /**
     * Sets the value of the dEntreCalle1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEntreCalle1(String value) {
        this.dEntreCalle1 = value;
    }

    /**
     * Gets the value of the dEntreCalle2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEntreCalle2() {
        return dEntreCalle2;
    }

    /**
     * Sets the value of the dEntreCalle2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEntreCalle2(String value) {
        this.dEntreCalle2 = value;
    }

    /**
     * Gets the value of the dInmueble property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDInmueble() {
        return dInmueble;
    }

    /**
     * Sets the value of the dInmueble property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDInmueble(String value) {
        this.dInmueble = value;
    }

    /**
     * Gets the value of the dLocalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDLocalidad() {
        return dLocalidad;
    }

    /**
     * Sets the value of the dLocalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDLocalidad(String value) {
        this.dLocalidad = value;
    }

    /**
     * Gets the value of the dMunicipio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDMunicipio() {
        return dMunicipio;
    }

    /**
     * Sets the value of the dMunicipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDMunicipio(String value) {
        this.dMunicipio = value;
    }

    /**
     * Gets the value of the dReferencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDReferencia() {
        return dReferencia;
    }

    /**
     * Sets the value of the dReferencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDReferencia(String value) {
        this.dReferencia = value;
    }

    /**
     * Gets the value of the dSitContSuc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSitContSuc() {
        return dSitContSuc;
    }

    /**
     * Sets the value of the dSitContSuc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSitContSuc(String value) {
        this.dSitContSuc = value;
    }

    /**
     * Gets the value of the dSitSuc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSitSuc() {
        return dSitSuc;
    }

    /**
     * Sets the value of the dSitSuc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSitSuc(String value) {
        this.dSitSuc = value;
    }

    /**
     * Gets the value of the dVialidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDVialidad() {
        return dVialidad;
    }

    /**
     * Sets the value of the dVialidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDVialidad(String value) {
        this.dVialidad = value;
    }

    /**
     * Gets the value of the dcrh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCRH() {
        return dcrh;
    }

    /**
     * Sets the value of the dcrh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCRH(String value) {
        this.dcrh = value;
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
     * Gets the value of the fAltaSuc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAltaSuc() {
        return fAltaSuc;
    }

    /**
     * Sets the value of the fAltaSuc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAltaSuc(String value) {
        this.fAltaSuc = value;
    }

    /**
     * Gets the value of the nEstablecimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEstablecimiento() {
        return nEstablecimiento;
    }

    /**
     * Sets the value of the nEstablecimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEstablecimiento(String value) {
        this.nEstablecimiento = value;
    }

    /**
     * Gets the value of the nExterior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNExterior() {
        return nExterior;
    }

    /**
     * Sets the value of the nExterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNExterior(String value) {
        this.nExterior = value;
    }

    /**
     * Gets the value of the nInterior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInterior() {
        return nInterior;
    }

    /**
     * Sets the value of the nInterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInterior(String value) {
        this.nInterior = value;
    }

    /**
     * Gets the value of the tInmueble property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTInmueble() {
        return tInmueble;
    }

    /**
     * Sets the value of the tInmueble property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTInmueble(String value) {
        this.tInmueble = value;
    }

    /**
     * Gets the value of the tTel1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTTel1() {
        return tTel1;
    }

    /**
     * Sets the value of the tTel1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTTel1(String value) {
        this.tTel1 = value;
    }

    /**
     * Gets the value of the tTel2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTTel2() {
        return tTel2;
    }

    /**
     * Sets the value of the tTel2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTTel2(String value) {
        this.tTel2 = value;
    }

    /**
     * Gets the value of the tVialidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTVialidad() {
        return tVialidad;
    }

    /**
     * Sets the value of the tVialidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTVialidad(String value) {
        this.tVialidad = value;
    }

    /**
     * Gets the value of the caractDomicilio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaractDomicilio() {
        return caractDomicilio;
    }

    /**
     * Sets the value of the caractDomicilio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaractDomicilio(String value) {
        this.caractDomicilio = value;
    }

}
