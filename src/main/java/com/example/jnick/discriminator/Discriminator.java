package com.example.jnick.discriminator;

/**
 * @author fabian
 */
public abstract class Discriminator {

    protected final String CHARACTER_SEPARATOR = "-";
    protected final String CHARACTER_BLANK     = "";

    public Discriminator() {}

    public abstract boolean     isValid(String token);
    public abstract boolean[]   getValidPositions(String token);

}
