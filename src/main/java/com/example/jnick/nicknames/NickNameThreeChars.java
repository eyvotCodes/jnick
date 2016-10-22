package com.example.jnick.nicknames;

import com.example.jnick
          .nicknames.exceptions
          .InvalidLengthForNicknameException;
import com.example.jnick.nicknames
          .exceptions
          .InvalidLengthForStructureException;

import java.util.ArrayList;

/**
 * @author fabian
 */
public class NickNameThreeChars extends Nickname {

    private final int NICKNAME_LENGTH = 3;


    public NickNameThreeChars(String nickname)
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
    @Override
    public void setValidStructures() {
        // CAUTION:
        // Only add structures with length = 3.
        validStructures.add("CCV");
        validStructures.add("CVC");
        validStructures.add("CVV");
        validStructures.add("VCV");
        validStructures.add("VVC");
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public void setValidStructures(ArrayList<String> structures)
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
