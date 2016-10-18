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
public class SingleConsonantDiscriminatorTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"f", true, true, true, false},
            {"b", true, true, true, false},
            {"n", true, true, true, true},
            {"d", true, true, true, true},
            {"r", true, true, true, true},
            {"l", true, true, true, true},
            {"v", true, true, true, false},
            {"y", true, true, true, false},
            {"t", true, true, true, true},
            {"s", true, true, true, true}
        });
    }

    private boolean expectedIsValid,
                    expectedIsValidForFirstPosition,
                    expectedIsValidForMiddlePosition,
                    expectedIsValidForLastPosition;
    private String  singleConsonant;
    private SingleConsonantDiscriminator discriminator;

    public SingleConsonantDiscriminatorTest(String singleConsonant,
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
        discriminator = new SingleConsonantDiscriminator();
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
