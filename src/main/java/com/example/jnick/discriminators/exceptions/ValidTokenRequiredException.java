package com.example.jnick.discriminators.exceptions;

/**
 * @author fabian
 */
public class ValidTokenRequiredException extends RuntimeException {

    public ValidTokenRequiredException() {
        super();
    }

    public ValidTokenRequiredException(String message) {
        super(message);
    }

    public ValidTokenRequiredException(String message, String token) {
        super(message + "\nToken: " + token);
    }

}
