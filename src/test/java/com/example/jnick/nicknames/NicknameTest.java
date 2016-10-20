package com.example.jnick.nicknames;

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
            {"aegon", stringify(new String[] {"ae", "g", "o", "n"})},

            {"aa",    stringify(new String[] {"aa"})},
            {"cc",    stringify(new String[] {"cc"})},
            {"aaa",   stringify(new String[] {"aaa"})},
            {"ccc",   stringify(new String[] {"ccc"})},
            {"aaaa",  stringify(new String[] {"aaaa"})},
            {"cccc",  stringify(new String[] {"cccc"})},
            {"acccc", stringify(new String[] {"a", "cccc"})},
            {"caaaa", stringify(new String[] {"c", "aaaa"})},
            {"aaaac", stringify(new String[] {"aaaa", "c"})},
            {"cccca", stringify(new String[] {"cccc", "a"})},

            {"aaccaacc",
                stringify(
                    new String[] {"aa", "cc", "aa", "cc"})},
            {"acaacaaa",
                stringify(
                    new String[] {"a", "c", "aa", "c", "aaa"})},
            {"ccacaaacccaaaaa",
                stringify(
                    new String[] {"cc", "a", "c", "aaa", "ccc", "aaaaa"})},
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
    public void tokenize() {
        Assert.assertEquals(
            this.expectedTokens,
            stringify(nickameFiveChars.tokenize())
        );
    }

    private static String stringify(String[] array) {
        return Arrays.toString(array);
    }

}
