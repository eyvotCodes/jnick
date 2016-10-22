package com.example.jnick.discriminators;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

/**
 * @author fabian
 */
@RunWith(value = Parameterized.class)
public class UtilTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"CVCCV", "[C, V, CC, V]"},
            {"CVCCC", "[C, V, CCC]"},
            {"CVCVC", "[C, V, C, V, C]"},
            {"CCVCC", "[CC, V, CC]"},
            {"CCVCV", "[CC, V, C, V]"},
            {"CVVCV", "[C, VV, C, V]"},
            {"VCCCV", "[V, CCC, V]"},
            {"VCCVC", "[V, CC, V, C]"},
            {"VCVCC", "[V, C, V, CC]"},
            {"VCVCV", "[V, C, V, C, V]"},
            {"VCVVC", "[V, C, VV, C]"},
            {"VVCVC", "[VV, C, V, C]"}
        });
    }

    private String structure, expectedStructureTokens;

    public UtilTest(String structure, String expectedStructureTokens) {
        this.structure = structure;
        this.expectedStructureTokens = expectedStructureTokens;
    }


    @Test
    public void getStructureTokens() {
        Assert.assertEquals(
            this.expectedStructureTokens,
            Arrays.toString(
                Util.getStructureTokens(this.structure)
            )
        );
    }

}
