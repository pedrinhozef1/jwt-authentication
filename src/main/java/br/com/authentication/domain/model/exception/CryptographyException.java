package br.com.authentication.domain.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_FAILURE)
public class CryptographyException extends RuntimeException {
    public CryptographyException() {
        super();
    }

    public CryptographyException(final String message) {
        super(message);
    }

    public CryptographyException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
