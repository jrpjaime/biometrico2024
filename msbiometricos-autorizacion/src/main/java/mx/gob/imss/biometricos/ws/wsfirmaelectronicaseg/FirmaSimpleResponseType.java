package mx.gob.imss.biometricos.ws.wsfirmaelectronicaseg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FirmaSimpleResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FirmaSimpleResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultado" type="{http://doctrust.metatrust.com.mx/WsFirmaElectronicaSeg.xsd}ResultadoType"/>
 *         &lt;element name="jsonSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FirmaSimpleResponseType", propOrder = {
    "resultado",
    "jsonSalida"
})
public class FirmaSimpleResponseType {

    @XmlElement(required = true)
    protected ResultadoType resultado;
    protected String jsonSalida;

    /**
     * Gets the value of the resultado property.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoType }
     *     
     */
    public ResultadoType getResultado() {
        return resultado;
    }

    /**
     * Sets the value of the resultado property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoType }
     *     
     */
    public void setResultado(ResultadoType value) {
        this.resultado = value;
    }

    /**
     * Gets the value of the jsonSalida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsonSalida() {
        return jsonSalida;
    }

    /**
     * Sets the value of the jsonSalida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsonSalida(String value) {
        this.jsonSalida = value;
    }

}
