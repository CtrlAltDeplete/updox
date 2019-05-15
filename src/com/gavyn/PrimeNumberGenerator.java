package com.gavyn;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args) {
        List<Integer> params, primes;
        PrimeNumberGenerator generator = new PrimeNumberGenerator();

        try {
            params = generator.getParams(args);
        } catch (NumberFormatException e) {
            params = new ArrayList<>();
            System.out.println(e.toString());
            System.exit(0);
        }
        primes = generator.generate(params.get(0), params.get(1));

        // Iterate through the results, printing them out.
        for (int i = 0; i < primes.size(); i++) {
            System.out.println(primes.get(i));
        }
        if (primes.size() == 0) {
            System.out.println("No primes in range.");
        }
    }

    List<Integer> getParams(String[] args) {
        List<Integer> params = new ArrayList<>();
        int numOne, numTwo;
        numOne = 0;
        numTwo = 0;

        if (args.length == 2) {
            try {
                numOne = Integer.parseInt(args[0]);
                numTwo = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Input must be Integer.");
            }
        } else {
            Scanner reader = new Scanner(System.in);

            // Read in the range.
            try {
                System.out.println("Enter Number 1: ");
                numOne = reader.nextInt();
                System.out.println("Enter Number 2: ");
                numTwo = reader.nextInt();
            } catch (InputMismatchException e) {
                throw new NumberFormatException("Input must be Integer.");
            }
        }

        params.add(numOne);
        params.add(numTwo);
        return params;
    }

    List<Integer> generate(int startingValue, int endingValue) {
        // Swap the starting and ending values if needed.
        if (startingValue > endingValue) {
            int temp = startingValue;
            startingValue = endingValue;
            endingValue = temp;
        }

        // Create the list of primes to return.
        List<Integer> primes = new ArrayList<>();
        // Add any numbers in the inclusive range that are prime.
        for (int i = startingValue; i <= endingValue; i++) {
            if (this.isPrime(i)) {
                primes.add(i);
            }
            if (i % 2 == 1 && i != 1) {
                i++;
            }
        }
        // Return the list.
        return primes;
    }
    
    boolean isPrime(final int value) {
        // 0 and 1 are special cases.
        if (value < 2) {
            return false;
        } else if (value == 2) {
            return true;
        }

        List<Integer> previousPrimes = generate(2, (int) Math.floor(Math.sqrt(value)));

        // Start at the floor of the square root and step down.
        for (int i = 0; i < previousPrimes.size(); i++) {
            if (value % previousPrimes.get(i) == 0) {
                return false;
            }
        }

        // If it made it here, it is prime.
        return true;
    }
}
