package com.example.jnick.discriminators;

import com.example.jnick.discriminators.exceptions.PositionsNotFoundException;

/**
 * @author fabian
 */
public class SingleVocalDiscriminator extends Discriminator {

    private       boolean[][]   positionsMatrix;
    private final short
        A = 0, E = 1, I = 2, O = 3, U = 4;

    private final String        SINGLE_VOCALS = "a-e-i-o-u";


    public SingleVocalDiscriminator() {
        initPositionsMatrix();
    }


    /**
     * {@inheritDoc}
     * */
    @Override public boolean isValid(String singleCharacter) {
        for(String singleVocal:SINGLE_VOCALS
                .split(CHARACTER_SEPARATOR)) {
            if(singleCharacter.equals(singleVocal)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * */
    @Override public short getCollectionSize() {
        return (short)
            SINGLE_VOCALS
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    /**
     * {@inheritDoc}
     * */
    @Override public boolean[] getValidPositions(String singleVocal)
            throws PositionsNotFoundException {
        switch(singleVocal) {
            case "a": return positionsMatrix[A];
            case "e": return positionsMatrix[E];
            case "i": return positionsMatrix[I];
            case "o": return positionsMatrix[O];
            case "u": return positionsMatrix[U];
        } throw new PositionsNotFoundException(
            POSITIONS_NOT_FOUND_MESSAGE,
            singleVocal
        );
    }

    /**
     * Initializes the matrix that contains all positions about
     * single vocal tokens.
     * */
    private void initPositionsMatrix() {
        this.positionsMatrix =
            new boolean[getCollectionSize()][NUMBER_OF_POSITIONS];
        positionsMatrix[A] = new boolean[] {true,true,true};
        positionsMatrix[E] = new boolean[] {true,true,true};
        positionsMatrix[I] = new boolean[] {true,true,true};
        positionsMatrix[O] = new boolean[] {true,true,true};
        positionsMatrix[U] = new boolean[] {true,true,true};
    }

}