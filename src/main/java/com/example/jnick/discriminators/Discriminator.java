package com.example.jnick.discriminators;

/**
 * @author fabian
 */
public abstract class Discriminator {

    protected final short   NUMBER_OF_POSITIONS = 3;

    protected final String  CHARACTER_SEPARATOR = "-";
    protected final String  POSITIONS_NOT_FOUND_MESSAGE
                                = "\nError: positions not found.";

    public Discriminator() {}


    /**
     * Check if a string is valid as token.
     *
     * @param   token single, double or triple character string.
     * @return        valid or not
     * */
    public abstract boolean isValid(String characters);

    /**
     * Obtains the number of single, double or triple character tokens that
     * can be valid.
     *
     * @return number of valid tokens in a class.
     * */
    public abstract short getCollectionSize();

    /**
     * Obtains the valid positions that a token can be have into a nickname.
     *
     * @param   token valid token
     * @return        positions
     * */
    public abstract boolean[] getValidPositions(String token);

}
