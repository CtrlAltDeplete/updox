package com.gavyn;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result testResults = JUnitCore.runClasses(IsPrimeTest.class);

        for (Failure failure : testResults.getFailures()) {
            System.out.println(failure.toString());
        }

        testResults = JUnitCore.runClasses(GenerateTest.class);

        for (Failure failure : testResults.getFailures()) {
            System.out.println(failure.toString());
        }

        testResults = JUnitCore.runClasses(GetParamsTest.class);

        for (Failure failure : testResults.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
