package com.example.jnick.nicknames;

import java.util.ArrayList;

/**
 * @author fabian
 */
public class NicknameFiveChars extends Nickname {

    private final
        ArrayList<String> VALID_STRUCTURES = new ArrayList<String>();


    public NicknameFiveChars(String nickname) {
        super(nickname);
        initValidStructures();
    }


    @Override public boolean isValid() {
        return false;
    }


    /**
     * Adds all structures for nicknames of 5 characters.
     * */
    private void initValidStructures() {
        VALID_STRUCTURES.add("CVCVV");
        VALID_STRUCTURES.add("CVCCV");
        VALID_STRUCTURES.add("CVCCC");
        VALID_STRUCTURES.add("CVCVC");
        VALID_STRUCTURES.add("CCVCC");
        VALID_STRUCTURES.add("CCVCV");
        VALID_STRUCTURES.add("CVVCV");
        VALID_STRUCTURES.add("VCCCV");
        VALID_STRUCTURES.add("VCCVC");
        VALID_STRUCTURES.add("VCVCC");
        VALID_STRUCTURES.add("VCVCV");
        VALID_STRUCTURES.add("VCVVC");
        VALID_STRUCTURES.add("VVCVC");
    }

}
