package com.gavyn;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class GenerateTest {
    private Integer minNum;
    private Integer maxNum;
    private List<Integer> expectedPrimes;
    private PrimeNumberGenerator primeNumberGenerator;


    @Before
    public void initialize() {
        primeNumberGenerator = new PrimeNumberGenerator();
    }

    public GenerateTest(Integer minNum, Integer maxNum, List<Integer> expectedPrimes) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.expectedPrimes = expectedPrimes;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                {1, 102, List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101)},
                {102, 1, List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101)},
                {7900, 7920, List.of(7901, 7907, 7919)},
                {7920, 7900, List.of(7901, 7907, 7919)},
                {-102, -1, List.of()},
                {-1, -102, List.of()},
                {-5, 1, List.of()},
                {1, -5, List.of()},
                {3, 3, List.of(3)},
                {10, 10, List.of()}
        });
    }

    @Test
    public void testIsPrime() {
        assertEquals(expectedPrimes, primeNumberGenerator.generate(minNum, maxNum));
    }
}
