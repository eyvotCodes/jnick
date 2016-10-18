package com.example.jnick.discriminators.exceptions;

/**
 * @author fabian
 */
public class AlphabetCharacterRequiredException extends RuntimeException {

    public AlphabetCharacterRequiredException() {
        super();
    }

    public AlphabetCharacterRequiredException(String message) {
        super(message);
    }

    public AlphabetCharacterRequiredException(String message,
            char character) {
        super(message + "\nCharacter: " + Character.toString(character));
    }

}
