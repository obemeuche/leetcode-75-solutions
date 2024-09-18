package com.algorithm.leetcode.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SomeStreamOperations {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("guava", "banana", "carrot", "apple", "farm", "guava", "dove", "apple");

        System.out.println(sumOfEvenNumbers(list));
        System.out.println(countString(words));
        System.out.println(squareOfIntegers(list));
        System.out.println(maxElement(list));
        System.out.println(concat(words));
        System.out.println(toUpperCaseAndSorting(words));
        System.out.println(findAverage(list));
        System.out.println(uniqueWords(words));
        System.out.println(checkEven(list));
        System.out.println(ifNumExist(list));
    }

    // 1. Find the sum of all even numbers in a list of integers.
    private static int sumOfEvenNumbers(List<Integer> numbers) {
        int sum;
        sum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        return sum;
    }

    // 2. Find and print the count of strings that have length greater than 5.
    private static int countString(List<String> list){
        return (int) list.stream().
                filter(str -> str.length() >= 5).
                count();
    }

    // 3. Implement a function that takes a list of integers as input and returns a new list containing the square of each element.
    private static List<Integer> squareOfIntegers(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
    }

    // 4. Find the maximum element in a list of integers.
    private static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
    }

    // 5. Concatenate all the strings in a list into a single string.
    private static String concat(List<String> list) {
        return list.stream().collect(Collectors.joining(" "));
    }

    // 6. Convert each string to uppercase and then sort them in alphabetical order.
    private static List<String> toUpperCaseAndSorting(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }

    // 7. Find the average of all the numbers in a list of doubles using Streams.
    private static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average().getAsDouble();
    }

    // 8. Create a new list that contains only unique words (remove duplicates)
    private static List<String> uniqueWords(List<String> words) {
        return words.stream()
                .distinct().collect(Collectors.toList());
    }

    // 9. Check if all elements in a List satisfy a given condition using streams.
    private  static boolean checkEven(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num % 2 == 0);
    }

    // 10. Check if a list contains a specific element using streams.
    private static boolean ifNumExist(List<Integer> numbers) {
        return numbers.stream().anyMatch(num -> num.equals(11));
    }
}
