package com.gavyn;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IsPrimeTest {
    private Integer num;
    private Boolean expectedResult;
    private PrimeNumberGenerator primeNumberGenerator;

    @Before
    public void initialize() {
        primeNumberGenerator = new PrimeNumberGenerator();
    }

    public IsPrimeTest(Integer num, Boolean expectedResult) {
        this.num = num;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                {2, true},
                {3, true},
                {5, true},
                {7, true},
                {11, true},
                {13, true},
                {19, true},
                {7901, true},
                {7907, true},
                {7919, true},
                {4, false},
                {6, false},
                {8, false},
                {9, false},
                {12, false},
                {14, false},
                {20, false},
                {7902, false},
                {7908, false},
                {7920, false},
                {-1, false},
                {0, false},
                {1, false}
        });
    }

    @Test
    public void testIsPrime() {
        assertEquals(expectedResult, primeNumberGenerator.isPrime(num));
    }
}
