package com.example.jnick.nicknames.exceptions;

/**
 * @author fabian
 */
public class InvalidLengthForNicknameException extends RuntimeException {

    public InvalidLengthForNicknameException() {
        super();
    }

    public InvalidLengthForNicknameException(String message) {
        super(message);
    }

    public InvalidLengthForNicknameException(String message, int length) {
        super(message + "\nExpected length: " + length);
    }

}
