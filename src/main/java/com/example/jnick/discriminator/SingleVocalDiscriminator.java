package com.example.jnick.discriminator;

/**
 * @author fabian
 */
public class SingleVocalDiscriminator extends Discriminator {

    private final int           A = 0, E = 1, I = 2, O = 3, U = 4;
    private       boolean[][]   positionsMatrix;

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
    @Override public boolean[] getValidPositions(String singleVocal) {
        switch(singleVocal) {
            case "a": return positionsMatrix[A];
            case "e": return positionsMatrix[E];
            case "i": return positionsMatrix[I];
            case "o": return positionsMatrix[O];
            case "u": return positionsMatrix[U];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    /**
     * {@inheritDoc}
     * */
    @Override public int getCollectionSize() {
        return SINGLE_VOCALS
                .split(CHARACTER_SEPARATOR)
                .length;
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
