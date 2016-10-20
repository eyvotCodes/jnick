package com.example.jnick.nicknames;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.jnick.discriminators.Util;

/**
 * @author fabian
 */
public abstract class Nickname {

    private String nickname;


    public Nickname(String nickname) {
        this.nickname = nickname;
    }


    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    /**
     * Checks if a combination is valid as nickname.
     *
     * @return is valid or not.
     * */
    public abstract boolean isValid();

    /**
     * A crazy data structure to tokenize any nickname of any length.
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

    @Override public String toString() {
        return String.format(
            "Nickname: %s\nTokens: %s\nValid: %b",
            this.getNickname(),
            Arrays.toString(this.tokenize()),
            this.isValid()
        );
    }

}
