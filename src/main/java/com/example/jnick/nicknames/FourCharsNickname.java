package com.example.jnick.nicknames;

import com.example.jnick
          .nicknames.exceptions
          .InvalidLengthForNicknameException;
import com.example.jnick
          .nicknames.exceptions
          .InvalidLengthForStructureException;

import java.util.ArrayList;

/**
 * @author fabian
 */
public class FourCharsNickname extends Nickname {

    private final int NICKNAME_LENGTH = 4;


    public FourCharsNickname(String nickname)
            throws InvalidLengthForNicknameException {
        super(nickname);
        if(nickname.length() != NICKNAME_LENGTH) {
            throw new InvalidLengthForNicknameException(
                INVALID_LENGTH_FOR_NICKNAME_MESSAGE,
                NICKNAME_LENGTH
            );
        } else {
            setValidStructures();
        }
    }


    /**
     * {@inheritDoc}
     * */
    @Override public void setValidStructures() {
        // CAUTION:
        // Only add structures with length = 4.
        validStructures.add("CCVC");
        validStructures.add("CCVV");
        validStructures.add("CVCV");
        validStructures.add("CVVC");
        validStructures.add("VCCV");
        validStructures.add("VCVC");
        validStructures.add("VVCV");
    }

    /**
     * {@inheritDoc}
     * */
    @Override public void setValidStructures(ArrayList<String> structures)
            throws InvalidLengthForStructureException {
        validStructures.clear();
        for(String structure:structures) {
            if(structure.length() != NICKNAME_LENGTH) {
                throw new InvalidLengthForStructureException(
                    INVALID_LENGTH_FOR_STRUCTURE_MESSAGE,
                    NICKNAME_LENGTH
                );
            } else {
                validStructures.add(structure);
            }
        }
    }
}
