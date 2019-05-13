package com.gavyn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args) {
        int minNum, maxNum;
        if (args.length == 2) {
            // Use arguments passed if there were any.
            minNum = Integer.parseInt(args[0]);
            maxNum = Integer.parseInt(args[1]);
        } else {
            // Otherwise, ask for them.
            Scanner reader = new Scanner(System.in);

            // Read in the range.
            System.out.println("Enter Number 1: ");
            minNum = reader.nextInt();
            System.out.println("Enter Number 2: ");
            maxNum = reader.nextInt();
        }

        List<Integer> primes;
        PrimeNumberGenerator generator = new PrimeNumberGenerator();
        // If the first number is larger, pass it as max.
        if (minNum > maxNum) {
            primes = generator.generate(maxNum, minNum);
        } else {
            primes = generator.generate(minNum, maxNum);
        }

        // Iterate through the results, printing them out.
        for (int i = 0; i < primes.size(); i++) {
            System.out.println(primes.get(i));
        }
    }

    List<Integer> generate(int startingValue, int endingValue) {
        // Create the list of primes to return.
        List<Integer> primes = new ArrayList<>();
        // Add any numbers in the inclusive range that are prime.
        for (int i = startingValue; i <= endingValue; i++) {
            if (this.isPrime(i)) {
                primes.add(i);
            }
        }
        // Return the list.
        return primes;
    }
    
    boolean isPrime(int value) {
        // 0 and 1 are special cases.
        if (value == 0 || value == 1) {
            return false;
        }

        // Start at the floor of the square root and step down.
        for (int i = (int) Math.floor(Math.sqrt(value)); i > 1; i--) {
            if (value % i == 0) {
                return false;
            }
        }

        // If it made it here, it is prime.
        return true;
    }
}
