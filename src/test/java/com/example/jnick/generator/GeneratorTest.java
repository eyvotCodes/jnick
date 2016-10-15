package com.example.jnick.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author fabian
 */
@RunWith(value = Parameterized.class)
public class GeneratorTest {

    @Parameters
    public static Iterable<Object[]> data() {
        /*
        * Calculate the number of combinations:
        * alphabeth.length ^ combinationLength = numberOfCombinations
        *
        * Order:
        * alphabetLength, combinationLength, expectedHeight, expectedLeafs
        * */
        return Arrays.asList(new Object[][] {
            {8, 2, 2,   64}, // 8^2 =   64
            {7, 3, 3,  343}, // 7^3 =  343
            {6, 4, 4, 1296}, // 6^4 = 1296
            {6, 5, 5, 7776}  // 6^5 = 7776
        });
    }


    private int     alphabethLength, combinationLength;
    private int     expectedHeight, expectedLeafs;
    private char[]  alphabet;

    private Generator generator;

    public GeneratorTest(int alphabethLength, int combinationLength,
            int expectedHeight, int expectedLeafs) {

        this.alphabethLength    = alphabethLength;
        this.combinationLength  = combinationLength;
        this.expectedHeight     = expectedHeight;
        this.expectedLeafs      = expectedLeafs;
    }


    @Before
    public void initValues() {
        generator = new Generator();
        alphabet = generator.generateAlphabet(this.alphabethLength);
    }

    @Test
    public void generateTree() {
        ArrayList<Node> root = generator.generateRootNodes(alphabet);
        ArrayList<Node> tree = generator.generateTree(
            root, alphabet, this.combinationLength
        );

        Assert.assertEquals(
            this.expectedHeight,
            generator.getTreeHeight(tree)
        );

        Assert.assertEquals(
            this.expectedLeafs,
            generator.getLeafsNumber(tree)
        );
    }

}
