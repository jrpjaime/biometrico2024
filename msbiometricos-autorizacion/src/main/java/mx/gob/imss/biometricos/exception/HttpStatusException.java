package mx.gob.imss.biometricos.exception;

import org.springframework.http.HttpStatus;

/**
 * Custon Exception that sends a HTTP Status code and a message.
 * 
 */
public class HttpStatusException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;

    public HttpStatusException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
