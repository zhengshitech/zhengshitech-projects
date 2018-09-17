package com.acme.code.gen.exception;

/**
 * @author H
 */
public class GenerationException extends RuntimeException {

    private static final long serialVersionUID = 2496926103108528613L;

    public GenerationException(String message) {
        super(message);
    }

    public GenerationException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenerationException(Throwable cause) {
        super(cause);
    }

    public GenerationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
