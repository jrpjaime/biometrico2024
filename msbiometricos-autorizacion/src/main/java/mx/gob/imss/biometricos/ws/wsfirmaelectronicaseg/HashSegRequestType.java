
package mx.gob.imss.biometricos.ws.wsfirmaelectronicaseg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HashSegRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HashSegRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jsonParams" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HashSegRequestType", propOrder = {
    "jsonParams"
})
public class HashSegRequestType {

    @XmlElement(required = true)
    protected String jsonParams;

    /**
     * Gets the value of the jsonParams property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsonParams() {
        return jsonParams;
    }

    /**
     * Sets the value of the jsonParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsonParams(String value) {
        this.jsonParams = value;
    }

}
