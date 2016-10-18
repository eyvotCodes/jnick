package com.example.jnick.discriminators;

import com.example.jnick.discriminators.exceptions.PositionsNotFoundException;
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
    private String tripleConsonant;
    private TripleConsonantDiscriminator discriminator;

    public TripleConsonantDiscriminatorTest(String tripleConsonant,
        boolean expectedIsValid,
        boolean expectedIsValidForFirstPosition,
        boolean expectedIsValidForMiddlePosition,
        boolean expectedIsValidForLastPosition) {

        this.tripleConsonant = tripleConsonant;
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
            discriminator.isValid(this.tripleConsonant)
        );
    }

    @Test()
    public void getValidPositions() throws PositionsNotFoundException {
        Assert.assertTrue(
            Arrays.equals(
                new boolean[] {
                    this.expectedIsValidForFirstPosition,
                    this.expectedIsValidForMiddlePosition,
                    this.expectedIsValidForLastPosition
                },
                discriminator.getValidPositions(this.tripleConsonant)
            )
        );
    }

    @Test(expected = PositionsNotFoundException.class)
    public void getValidPositionsException()
            throws PositionsNotFoundException {
        Assert.assertTrue(
            Arrays.equals(
                new boolean[] {false, false, false},
                discriminator.getValidPositions(this.tripleConsonant + "#")
            )
        );
    }

}
