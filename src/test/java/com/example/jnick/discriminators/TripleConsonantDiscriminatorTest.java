package com.example.jnick.discriminators;

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
public class TripleConsonantDiscriminatorTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"bbr", true, false, true,  false},
            {"bby", true, false, true,  true},
            {"bry", true, true,  true,  true},
            {"ddr", true, false, true,  false},
            {"ffl", true, false, true,  false},
            {"frz", true, false, false, true},
            {"fzz", true, false, true,  false},
            {"mbr", true, false, true,  true},
            {"psy", true, true,  true,  true},
            {"wgg", true, true,  true,  false},
            {"zbr", true, false, true,  true},
            {"zff", true, false, true,  false},
            {"zzy", true, false, true,  true}
        });
    }

    private boolean expectedIsValid,
        expectedIsValidForFirstPosition,
        expectedIsValidForMiddlePosition,
        expectedIsValidForLastPosition;
    private String  singleConsonant;
    private TripleConsonantDiscriminator discriminator;

    public TripleConsonantDiscriminatorTest(String singleConsonant,
        boolean expectedIsValid,
        boolean expectedIsValidForFirstPosition,
        boolean expectedIsValidForMiddlePosition,
        boolean expectedIsValidForLastPosition) {

        this.singleConsonant = singleConsonant;
        this.expectedIsValid = expectedIsValid;

        this.expectedIsValidForFirstPosition
            = expectedIsValidForFirstPosition;

        this.expectedIsValidForMiddlePosition
            = expectedIsValidForMiddlePosition;

        this.expectedIsValidForLastPosition
            = expectedIsValidForLastPosition;
    }


    @Before
    public void initValues() {
        discriminator = new TripleConsonantDiscriminator();
    }

    @Test
    public void isValid() {
        Assert.assertEquals(
            this.expectedIsValid,
            discriminator.isValid(this.singleConsonant)
        );
    }

    @Test
    public void getValidPositions() {
        Assert.assertTrue(
            Arrays.equals(
                new boolean[] {
                    this.expectedIsValidForFirstPosition,
                    this.expectedIsValidForMiddlePosition,
                    this.expectedIsValidForLastPosition
                },
                discriminator.getValidPositions(this.singleConsonant)
            )
        );
    }

}
