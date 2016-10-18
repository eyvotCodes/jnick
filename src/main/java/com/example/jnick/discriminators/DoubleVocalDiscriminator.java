package com.example.jnick.discriminators;

import com.example.jnick.discriminators.exceptions.PositionsNotFoundException;

/**
 * @author fabian
 */
public class DoubleVocalDiscriminator extends Discriminator {

    private       boolean[][] positionsMatrix;
    private final short
        AE = 0, AI = 1, EA = 2, EI =  3, EO =  4, EU =  5, IA =  6,
        IE = 7, IO = 8, OE = 9, OO = 10, UA = 11, UE = 12, UI = 13, UO = 14;

    private final String DOUBLE_VOCALS
        = "ae-ai-"
        + "ea-ei-eo-eu-"
        + "ia-ie-io-"
        + "oe-oo-"
        + "ua-ue-ui-uo";


    public DoubleVocalDiscriminator() {
        initPositionsMatrix();
    }


    /**
     * {@inheritDoc}
     * */
    @Override public boolean isValid(String doubleCharacter) {
        for(String doubleVocal:DOUBLE_VOCALS
                .split(CHARACTER_SEPARATOR)) {
            if(doubleCharacter.equals(doubleVocal)) {
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
            DOUBLE_VOCALS
                .split(CHARACTER_SEPARATOR)
                .length;
    }

    /**
     * {@inheritDoc}
     * */
    @Override public boolean[] getValidPositions(String doubleVocal)
            throws PositionsNotFoundException {
        switch(doubleVocal) {
            case "ae": return positionsMatrix[AE];
            case "ai": return positionsMatrix[AI];
            case "ea": return positionsMatrix[EA];
            case "ei": return positionsMatrix[EI];
            case "eo": return positionsMatrix[EO];
            case "eu": return positionsMatrix[EU];
            case "ia": return positionsMatrix[IA];
            case "ie": return positionsMatrix[IE];
            case "io": return positionsMatrix[IO];
            case "oe": return positionsMatrix[OE];
            case "oo": return positionsMatrix[OO];
            case "ua": return positionsMatrix[UA];
            case "ue": return positionsMatrix[UE];
            case "ui": return positionsMatrix[UI];
            case "uo": return positionsMatrix[UO];
        } throw new PositionsNotFoundException(
            POSITIONS_NOT_FOUND_MESSAGE,
            doubleVocal
        );
    }

    /**
     * Initializes the matrix that contains all positions about
     * double vocal tokens.
     * */
    private void initPositionsMatrix() {
        this.positionsMatrix =
            new boolean[getCollectionSize()][NUMBER_OF_POSITIONS];
        positionsMatrix[AE] = new boolean[] {true,true,false};
        positionsMatrix[AI] = new boolean[] {true,true,true};
        positionsMatrix[EA] = new boolean[] {true,true,true};
        positionsMatrix[EI] = new boolean[] {true,true,true};
        positionsMatrix[EO] = new boolean[] {true,true,true};
        positionsMatrix[EU] = new boolean[] {true,true,true};
        positionsMatrix[IA] = new boolean[] {true,true,true};
        positionsMatrix[IE] = new boolean[] {true,true,true};
        positionsMatrix[IO] = new boolean[] {true,true,true};
        positionsMatrix[OE] = new boolean[] {true,true,true};
        positionsMatrix[OO] = new boolean[] {false,true,false};
        positionsMatrix[UA] = new boolean[] {true,true,true};
        positionsMatrix[UE] = new boolean[] {true,true,true};
        positionsMatrix[UI] = new boolean[] {true,true,true};
        positionsMatrix[UO] = new boolean[] {true,true,true};
    }

}
