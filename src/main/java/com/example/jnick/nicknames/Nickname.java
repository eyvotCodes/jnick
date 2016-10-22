package com.example.jnick.nicknames;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.jnick.discriminators.*;
import com.example.jnick.nicknames.exceptions.InvalidLengthForStructureException;

/**
 * @author fabian
 */
public abstract class Nickname {

    private String nickname;

    private Discriminator
        svd = new SingleVowelDiscriminator(),
        scd = new SingleConsonantDiscriminator(),
        dvd = new DoubleVowelDiscriminator(),
        dcd = new DoubleConsonantDiscriminator(),
        tcd = new TripleConsonantDiscriminator();

    protected final String  INVALID_LENGTH_FOR_STRUCTURE_MESSAGE
                                = "\nError: invalid length for structure.";
    protected final String  INVALID_LENGTH_FOR_NICKNAME_MESSAGE
                                = "\nError: invalid length for nickname.";

    protected ArrayList<String> validStructures;


    public Nickname(String nickname) {
        this.nickname = nickname;
        this.validStructures = new ArrayList<String>();
    }


    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override public String toString() {
        return String.format(
            "Nickname: %s\nTokens: %s\nValid: %b",
            this.getNickname(),
            Arrays.toString(this.tokenize()),
            this.isValid()
        );
    }


    /**
     * Set valid structures for nicknames.
     * <p>
     * Basically, structures describes the syntax for nicknames.
     * */
    public abstract void setValidStructures();

    /**
     * Set valid structures for nicknames.
     * <p>
     * Basically, structures describes the syntax for nicknames.
     *
     * @param structures specific valid structures.
     * */
    public abstract void setValidStructures(ArrayList<String> structures)
        throws InvalidLengthForStructureException;

    /**
     * Checks if a combination is valid as nickname.
     *
     * @return is valid or not.
     * */
    public boolean isValid() {
        boolean isValidNickname = false;
        for(String structure:validStructures) {
            if(!isValidNickname) {
                if(isValidStrcture(structure)) {
                    isValidNickname = checkNickname(structure);
                } else break;
            } else break;
        }
        return isValidNickname;
    }

    /**
     * A little crazy data structure to tokenize any nickname of any length.
     *
     * @return nickname tokens.
     * */
    public String[] tokenize() {
        char    currentCharacter    =  0,
                previousCharacter   =  0;

        String  currentType         = "",
                currentToken        = "",
                currentLargeToken   = "",
                previousType        = "",
                previousToken       = "",
                previousLargeToken  = "";

        boolean isLargeToken        = false;

        ArrayList<String>
                partialTokens       = new ArrayList<String>();

        for(char character:nickname.toCharArray()) {
            currentCharacter = character;
            currentType      = Util.getCharacterType(currentCharacter);
            currentToken     = Character.toString(currentCharacter);

            if(currentType.equals(previousType)) {
                if(previousLargeToken.length() <= 0) {
                    currentLargeToken += previousToken + currentToken;
                }else {
                    currentLargeToken += previousLargeToken + currentToken;
                }
                isLargeToken = true;
            }

            if(isLargeToken) {
                partialTokens.remove(partialTokens.size() - 1);
                partialTokens.add(currentLargeToken);
                previousLargeToken = currentLargeToken;
                currentLargeToken = "";
                isLargeToken = false;
            } else {
                partialTokens.add(currentToken);
                previousLargeToken = "";
            }

            previousCharacter = currentCharacter;
            previousType      = currentType;
            previousToken     = Character.toString(previousCharacter);
        }

        String[] tokens =  new String[partialTokens.size()];
        return partialTokens.toArray(tokens);
    }

    /**
     * A flexible automaton that checks the syntax given in the structures
     * to determine if a nickname is valid or not.
     * <p>
     * The automaton is adaptive to any length of nickname.
     * */
    private boolean checkNickname(String structure) {
        boolean isValid = false;
        String[] tokens = tokenize();
        String[] structureTokensType =
            Util.getStructureTokensType(structure);

        if(tokens.length == structureTokensType.length) {
            for(int i=0; i<tokens.length; i++) {
                switch(tokens[i].length()) {
                    case 1:
                        if(i <= 0) {
                            if(svd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    ) {
                                isValid = true;
                            } else if(scd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    ) {
                                isValid = true;
                            } else {
                                isValid = false;
                                i = tokens.length;
                            }
                        } else {
                            if(svd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    && Util.canBeSequence(
                                    tokens[i-1].charAt(
                                        tokens[i-1].length() - 1
                                    ),
                                    tokens[i].charAt(0))
                                    ) {
                                isValid = true;
                            } else if(scd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    && Util.canBeSequence(
                                    tokens[i-1].charAt(
                                        tokens[i-1].length() - 1
                                    ),
                                    tokens[i].charAt(0))
                                    ) {
                                isValid = true;
                            } else {
                                isValid = false;
                                i = tokens.length;
                            }
                        }
                        break;

                    case 2:
                        if(i <= 0) {
                            if(dvd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    ) {
                                isValid = true;
                            } else if(dcd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    ) {
                                isValid = true;
                            } else {
                                isValid = false;
                                i = tokens.length;
                            }
                        } else {
                            if(dvd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    && Util.canBeSequence(
                                    tokens[i-1].charAt(
                                        tokens[i-1].length() - 1
                                    ),
                                    tokens[i].charAt(0))
                                    ) {
                                isValid = true;
                            } else if(dcd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    && Util.canBeSequence(
                                    tokens[i-1].charAt(
                                        tokens[i-1].length() - 1
                                    ),
                                    tokens[i].charAt(0))
                                    ) {
                                isValid = true;
                            } else {
                                isValid = false;
                                i = tokens.length;
                            }
                        }
                        break;

                    case 3:
                        if(i <= 0) {
                            if(tcd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    ) {
                                isValid = true;
                            } else {
                                isValid = false;
                                i = tokens.length;
                            }
                        } else {
                            if(tcd.isValid(tokens[i])
                                    && Util.getTokenType(tokens[i])
                                    .equals(structureTokensType[i])
                                    && Util.canBeSequence(
                                    tokens[i-1].charAt(
                                        tokens[i-1].length() - 1
                                    ),
                                    tokens[i].charAt(0))
                                    ) {
                                isValid = true;
                            } else {
                                isValid = false;
                                i = tokens.length;
                            }
                        }
                        break;

                    default:
                        return false;
                }
            }
        }
        return isValid;
    }

    /**
     * Checks if a structure is valid.
     *
     * @param   structure structure to check.
     * @return            valid or not.
     * */
    private boolean isValidStrcture(String structure) {
        for(String validStructure:validStructures) {
            if(structure.equals(validStructure)) return true;
        }
        return false;
    }

}
