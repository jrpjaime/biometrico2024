
package mx.gob.imss.biometricos.ws.wssendemail;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mx.com.bi.ws.wssendemail package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendMailRequestCc_QNAME = new QName("", "cc");
    private final static QName _SendMailRequestBcc_QNAME = new QName("", "bcc");
    private final static QName _SendMailRequestFromAccountName_QNAME = new QName("", "fromAccountName");
    private final static QName _SendMailRequestSubject_QNAME = new QName("", "subject");
    private final static QName _SendMailRequestContent_QNAME = new QName("", "content");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.com.bi.ws.wssendemail
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendMailRequest }
     * 
     */
    public SendMailRequest createSendMailRequest() {
        return new SendMailRequest();
    }

    /**
     * Create an instance of {@link SendMailResponse }
     * 
     */
    public SendMailResponse createSendMailResponse() {
        return new SendMailResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cc", scope = SendMailRequest.class)
    public JAXBElement<String> createSendMailRequestCc(String value) {
        return new JAXBElement<String>(_SendMailRequestCc_QNAME, String.class, SendMailRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bcc", scope = SendMailRequest.class)
    public JAXBElement<String> createSendMailRequestBcc(String value) {
        return new JAXBElement<String>(_SendMailRequestBcc_QNAME, String.class, SendMailRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fromAccountName", scope = SendMailRequest.class)
    public JAXBElement<String> createSendMailRequestFromAccountName(String value) {
        return new JAXBElement<String>(_SendMailRequestFromAccountName_QNAME, String.class, SendMailRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subject", scope = SendMailRequest.class)
    public JAXBElement<String> createSendMailRequestSubject(String value) {
        return new JAXBElement<String>(_SendMailRequestSubject_QNAME, String.class, SendMailRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "content", scope = SendMailRequest.class)
    public JAXBElement<String> createSendMailRequestContent(String value) {
        return new JAXBElement<String>(_SendMailRequestContent_QNAME, String.class, SendMailRequest.class, value);
    }

}
