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
public class DoubleConsonantDiscriminatorTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"bb", true, false, true,  false},
            {"bh", true, true,  true,  false},
            {"bs", true, true,  true,  true},
            {"cc", true, false, true,  false},
            {"cr", true, true,  true,  false},
            {"hw", true, true,  false, false},
            {"hy", true, true,  false, false},
            {"py", true, true,  true,  true},
            {"tr", true, true,  true,  true},
            {"wx", true, true,  true,  false},
            {"zz", true, false, true,  false}
        });
    }

    private boolean expectedIsValid,
        expectedIsValidForFirstPosition,
        expectedIsValidForMiddlePosition,
        expectedIsValidForLastPosition;
    private String doubleConsonant;
    private DoubleConsonantDiscriminator discriminator;

    public DoubleConsonantDiscriminatorTest(String doubleConsonant,
        boolean expectedIsValid,
        boolean expectedIsValidForFirstPosition,
        boolean expectedIsValidForMiddlePosition,
        boolean expectedIsValidForLastPosition) {

        this.doubleConsonant = doubleConsonant;
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
        discriminator = new DoubleConsonantDiscriminator();
    }

    @Test
    public void isValid() {
        Assert.assertEquals(
            this.expectedIsValid,
            discriminator.isValid(this.doubleConsonant)
        );
    }

    @Test
    public void getValidPositions() throws PositionsNotFoundException {
        Assert.assertTrue(
            Arrays.equals(
                new boolean[] {
                    this.expectedIsValidForFirstPosition,
                    this.expectedIsValidForMiddlePosition,
                    this.expectedIsValidForLastPosition
                },
                discriminator.getValidPositions(this.doubleConsonant)
            )
        );
    }

    @Test(expected = PositionsNotFoundException.class)
    public void getValidPositionsException()
        throws PositionsNotFoundException {
        Assert.assertTrue(
            Arrays.equals(
                new boolean[] {false, false, false},
                discriminator.getValidPositions(this.doubleConsonant + "#")
            )
        );
    }

}
