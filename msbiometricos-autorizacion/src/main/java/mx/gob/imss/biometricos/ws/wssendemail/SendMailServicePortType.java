
package mx.gob.imss.biometricos.ws.wssendemail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SendMailServicePortType", targetNamespace = "http://mx.gob.imss.email.model")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SendMailServicePortType {


    /**
     * 
     * @param sendMailRequest
     * @return
     *     returns SendMailResponse
     */
    @WebMethod
    @WebResult(name = "sendMailResponse", targetNamespace = "http://mx.gob.imss.email.model", partName = "sendMailResponse")
    public SendMailResponse enviar(
        @WebParam(name = "sendMailRequest", targetNamespace = "http://mx.gob.imss.email.model", partName = "sendMailRequest")
        SendMailRequest sendMailRequest);

}