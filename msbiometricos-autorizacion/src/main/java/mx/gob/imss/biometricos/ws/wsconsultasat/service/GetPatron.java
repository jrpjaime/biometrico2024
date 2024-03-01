
package mx.gob.imss.biometricos.ws.wsconsultasat.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.gob.imss.biometricos.ws.wsconsultasat.mx_gob_imss_didt_cia_interoper_sat_pojos.EntradaSAT;


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
 *         &lt;element name="datosEntrada" type="{java:mx.gob.imss.didt.cia.interoper.sat.pojos.entrada}EntradaSAT"/>
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
    "datosEntrada"
})
@XmlRootElement(name = "getPatron")
public class GetPatron {

    @XmlElement(required = true)
    protected EntradaSAT datosEntrada;

    /**
     * Gets the value of the datosEntrada property.
     * 
     * @return
     *     possible object is
     *     {@link EntradaSAT }
     *     
     */
    public EntradaSAT getDatosEntrada() {
        return datosEntrada;
    }

    /**
     * Sets the value of the datosEntrada property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntradaSAT }
     *     
     */
    public void setDatosEntrada(EntradaSAT value) {
        this.datosEntrada = value;
    }

}
