package com.example.jnick.nicknames;

import com.example.jnick.nicknames.exceptions.InvalidLengthForNicknameException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

/**
 * @author fabian
 */
@RunWith(value = Parameterized.class)
public class NicknameTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"lucio", stringify(new String[] {"l", "u", "c", "io"})},
            {"dante", stringify(new String[] {"d", "a", "nt", "e"})},
            {"harry", stringify(new String[] {"h", "a", "rry"})},
            {"lerot", stringify(new String[] {"l", "e", "r", "o", "t"})},
            {"dross", stringify(new String[] {"dr", "o", "ss"})},
            {"draco", stringify(new String[] {"dr", "a", "c", "o"})},
            {"guido", stringify(new String[] {"g", "ui", "d", "o"})},
            {"indra", stringify(new String[] {"i", "ndr", "a"})},
            {"elton", stringify(new String[] {"e", "lt", "o", "n"})},
            {"odell", stringify(new String[] {"o", "d", "e", "ll"})},
            {"icaro", stringify(new String[] {"i", "c", "a", "r", "o"})},
            {"elias", stringify(new String[] {"e", "l", "ia", "s"})},
            {"aegon", stringify(new String[] {"ae", "g", "o", "n"})}
        });
    }

    private String nickname, expectedTokens;
    private Nickname nickameFiveChars;

    public NicknameTest(String nickname, String expectedTokens) {
        this.nickname = nickname;
        this.expectedTokens = expectedTokens;
    }


    @Before
    public void initValues() {
        nickameFiveChars = new NicknameFiveChars(this.nickname);
    }

    @Test
    public void tokenize() throws InvalidLengthForNicknameException {
        Assert.assertEquals(
            this.expectedTokens,
            stringify(nickameFiveChars.tokenize())
        );
    }

    private static String stringify(String[] array) {
        return Arrays.toString(array);
    }

}
