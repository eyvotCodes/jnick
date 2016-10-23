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
public class SixCharsNickname extends Nickname {

    private final int NICKNAME_LENGTH = 6;


    public SixCharsNickname(String nickname)
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
        // Only add structures with length = 6.
        validStructures.add("CCVVCV");
        validStructures.add("CCVCVC");
        validStructures.add("CVCCVV");
        validStructures.add("CVCCVC");
        validStructures.add("CVCVCC");
        validStructures.add("CVCVCV");
        validStructures.add("CVCVVC");
        validStructures.add("VCVCCC");
        validStructures.add("VCVCCV");
        validStructures.add("VCVCVC");
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
