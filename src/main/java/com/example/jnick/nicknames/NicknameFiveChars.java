package com.example.jnick.nicknames;

import com.example.jnick.nicknames.exceptions.InvalidLengthForNicknameException;
import com.example.jnick.nicknames.exceptions.InvalidLengthForStructureException;

import java.util.ArrayList;

/**
 * @author fabian
 */
public class NicknameFiveChars extends Nickname {

    private final int NICKNAME_LENGTH = 5;


    public NicknameFiveChars(String nickname) {
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
        // Only add structures with length = 5.
        validStructures.add("CVCCV");
        validStructures.add("CVCCC");
        validStructures.add("CVCVC");
        validStructures.add("CCVCC");
        validStructures.add("CCVCV");
        validStructures.add("CVVCV");
        validStructures.add("VCCCV");
        validStructures.add("VCCVC");
        validStructures.add("VCVCC");
        validStructures.add("VCVCV");
        validStructures.add("VCVVC");
        validStructures.add("VVCVC");
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
