package com.example.jnick.nicknames.exceptions;

/**
 * @author fabian
 */
public class InvalidLengthForStructureException extends RuntimeException {

    public InvalidLengthForStructureException() {
        super();
    }

    public InvalidLengthForStructureException(String message) {
        super(message);
    }

    public InvalidLengthForStructureException(String message, int length) {
        super(message + "\nExpected length: " + length);
    }

}
