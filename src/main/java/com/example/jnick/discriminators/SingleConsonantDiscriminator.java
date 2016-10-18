package com.example.jnick.discriminators;

/**
 * @author fabian
 */
public class SingleConsonantDiscriminator extends Discriminator {

    private       boolean[][] positionsMatrix;
    private final short
        B =  0, C =  1, D =  2, F =  3, G =  4, H =  5, J =  6, K =  7,
        L =  8, M =  9, N = 10, P = 11, Q = 12, R = 13, S = 14, T = 15,
        V = 16, W = 17, X = 18, Y = 19, Z = 20;

    private final static String SINGLE_CONSONANTS
        = "b-c-d-f-g-h-j-k-l-m-n-p-q-r-s-t-v-w-x-y-z";


    public SingleConsonantDiscriminator() {
        initPositionsMatrix();
    }


    /**
     * {@inheritDoc}
     * */
    @Override public boolean isValid(String singleCharacter) {
        for(String singleConsonant:SINGLE_CONSONANTS
                .split(CHARACTER_SEPARATOR)) {
            if(singleCharacter.equals(singleConsonant)) {
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
            SINGLE_CONSONANTS
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    /**
     * {@inheritDoc}
     * */
    @Override public boolean[] getValidPositions(String singleConsonant) {
        switch(singleConsonant) {
            case "b": return positionsMatrix[B];
            case "c": return positionsMatrix[C];
            case "d": return positionsMatrix[D];
            case "f": return positionsMatrix[F];
            case "g": return positionsMatrix[G];
            case "h": return positionsMatrix[H];
            case "j": return positionsMatrix[J];
            case "k": return positionsMatrix[K];
            case "l": return positionsMatrix[L];
            case "m": return positionsMatrix[M];
            case "n": return positionsMatrix[N];
            case "p": return positionsMatrix[P];
            case "q": return positionsMatrix[Q];
            case "r": return positionsMatrix[R];
            case "s": return positionsMatrix[S];
            case "t": return positionsMatrix[T];
            case "v": return positionsMatrix[V];
            case "w": return positionsMatrix[W];
            case "x": return positionsMatrix[X];
            case "y": return positionsMatrix[Y];
            case "z": return positionsMatrix[Z];
        }
        return POSITION_NOT_FOUND_ERROR;
    }

    /**
     * Initializes the matrix that contains all positions about
     * single consonant tokens.
     * */
    private void initPositionsMatrix() {
        this.positionsMatrix =
            new boolean[getCollectionSize()][NUMBER_OF_POSITIONS];
        positionsMatrix[B] = new boolean[] {true,true,false};
        positionsMatrix[C] = new boolean[] {true,true,false};
        positionsMatrix[D] = new boolean[] {true,true,true};
        positionsMatrix[F] = new boolean[] {true,true,false};
        positionsMatrix[G] = new boolean[] {true,true,true};
        positionsMatrix[H] = new boolean[] {true,false,false};
        positionsMatrix[J] = new boolean[] {true,true,true};
        positionsMatrix[K] = new boolean[] {true,true,true};
        positionsMatrix[L] = new boolean[] {true,true,true};
        positionsMatrix[M] = new boolean[] {true,true,true};
        positionsMatrix[N] = new boolean[] {true,true,true};
        positionsMatrix[P] = new boolean[] {true,true,false};
        positionsMatrix[Q] = new boolean[] {true,true,false};
        positionsMatrix[R] = new boolean[] {true,true,true};
        positionsMatrix[S] = new boolean[] {true,true,true};
        positionsMatrix[T] = new boolean[] {true,true,true};
        positionsMatrix[V] = new boolean[] {true,true,false};
        positionsMatrix[W] = new boolean[] {true,true,true};
        positionsMatrix[X] = new boolean[] {true,true,true};
        positionsMatrix[Y] = new boolean[] {true,true,false};
        positionsMatrix[Z] = new boolean[] {true,true,true};
    }

}
