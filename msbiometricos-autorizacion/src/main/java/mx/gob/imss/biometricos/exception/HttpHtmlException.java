package mx.gob.imss.biometricos.exception;

import org.springframework.http.HttpStatus;

/**
 * Custon Exception that sends a HTTP Status code and a message.
 *
 */
public class HttpHtmlException extends HttpStatusException {

    private static final long serialVersionUID = 1L;
    
    private final String htmlCode;

    public HttpHtmlException(HttpStatus httpStatus, String message, String htmlCode) {
        super(httpStatus, message);
        this.htmlCode = htmlCode;
    }

    public String getHtmlCode() {
        return htmlCode;
    }

}
