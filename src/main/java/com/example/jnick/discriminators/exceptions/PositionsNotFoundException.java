package com.example.jnick.discriminators.exceptions;

/**
 * @author fabian
 */
public class PositionsNotFoundException extends RuntimeException {

    public PositionsNotFoundException() {
        super();
    }

    public PositionsNotFoundException(String message) {
        super(message);
    }

    public PositionsNotFoundException(String message, String token) {
        super(message + "\nFor token: " + token);
    }

}
