package com.gavyn;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class GetParamsTest {
    private String[] args;
    private boolean shouldThrowError;
    private PrimeNumberGenerator primeNumberGenerator;


    @Before
    public void initialize() {
        primeNumberGenerator = new PrimeNumberGenerator();
    }

    public GetParamsTest(String[] args, boolean shouldThrowError) {
        this.args = args;
        this.shouldThrowError = shouldThrowError;
    }

    @Parameterized.Parameters
    public static Collection argsAndResults() {
        return Arrays.asList(new Object[][] {
                {new String[]{"1", "1"}, false},
                {new String[]{"1", "1.0"}, true},
                {new String[]{"1.0", "1"}, true},
                {new String[]{"1.0", "1.0"}, true},
                {new String[]{"a", "1"}, true},
                {new String[]{"1", "a"}, true},
                {new String[]{"a", "a"}, true}
        });
    }

    @Test
    public void testGetParams() {
        try {
            primeNumberGenerator.getParams(args);
            assertTrue(!shouldThrowError);
        } catch (NumberFormatException e) {
            assertTrue(shouldThrowError);
        }
    }
}
