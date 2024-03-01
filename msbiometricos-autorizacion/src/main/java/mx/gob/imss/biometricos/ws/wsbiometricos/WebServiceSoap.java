
package mx.gob.imss.biometricos.ws.wsbiometricos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServiceSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceSoap {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "HelloWorld", action = "http://tempuri.org/HelloWorld")
    @WebResult(name = "HelloWorldResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "HelloWorld", targetNamespace = "http://tempuri.org/", className = "org.tempuri.HelloWorld")
    @ResponseWrapper(localName = "HelloWorldResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.HelloWorldResponse")
    public String helloWorld();

    /**
     * 
     * @param command
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Todo", action = "http://tempuri.org/Todo")
    @WebResult(name = "TodoResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Todo", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Todo")
    @ResponseWrapper(localName = "TodoResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.TodoResponse")
    public String todo(
        @WebParam(name = "command", targetNamespace = "http://tempuri.org/")
        String command);

}
