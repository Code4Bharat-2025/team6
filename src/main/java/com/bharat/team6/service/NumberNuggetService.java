package com.bharat.team6.service;

public class NumberNuggetService {
    public static String generateFact(String input) {
        try {
            int n = Integer.parseInt(input);
            if (n == 0) return "Zero is the only number that can't be represented in Roman numerals.";
            if (n == 1) return "One is the multiplicative identity.";
            if (n % 2 == 0) return n + " is even. Even numbers are divisible by 2.";
            if (isPrime(n)) return n + " is a prime number!";
            return "Fun fact: " + (n * n) + " is the square of " + n;
        } catch (Exception e) {
            return "Please enter a valid number!";
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
