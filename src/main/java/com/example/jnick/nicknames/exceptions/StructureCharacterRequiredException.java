package com.example.jnick.nicknames.exceptions;

/**
 * @author fabian
 */
public class StructureCharacterRequiredException extends RuntimeException {

    public StructureCharacterRequiredException() {
        super();
    }

    public StructureCharacterRequiredException(String message) {
        super(message);
    }

    public StructureCharacterRequiredException(String message,
            char character) {
        super(message + "\nCharacter: " + Character.toString(character));
    }

}
