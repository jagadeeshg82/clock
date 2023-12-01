package com.example.clock.util;

public class NumberToWordsConverter {

    private static final String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TEENS = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        }
        return convertNumberToWordsHelper(number);
    }

    private static String convertNumberToWordsHelper(int number) {
        if (number < 0) {
            return "negative " + convertNumberToWordsHelper(-number);
        }
        if (number < 10) {
            return UNITS[number];
        }
        if (number < 20) {
            return TEENS[number - 10];
        }
        if (number < 100) {
            return TENS[number / 10] + " " + convertNumberToWordsHelper(number % 10);
        }
        if (number < 1000) {
            return UNITS[number / 100] + " hundred " + convertNumberToWordsHelper(number % 100);
        }
        if (number < 1_000_000) {
            return convertNumberToWordsHelper(number / 1000) + " thousand " + convertNumberToWordsHelper(number % 1000);
        }
        if (number < 1_000_000_000) {
            return convertNumberToWordsHelper(number / 1_000_000) + " million " + convertNumberToWordsHelper(number % 1_000_000);
        }
        if (number < 1_000_000_000_000L) {
            return convertNumberToWordsHelper(number / 1_000_000_000) + " billion " + convertNumberToWordsHelper(number % 1_000_000_000);
        }
        // Add more cases as needed

        return "implementation_needed";
    }
}
