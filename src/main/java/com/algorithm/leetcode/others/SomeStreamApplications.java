package com.algorithm.leetcode.others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SomeStreamApplications {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sumOfEvenNumbers(list));
        System.out.println(countString());
        System.out.println(squareOfIntegers(list));
        System.out.println(maxElement(list));
    }

    // 1. Find the sum of all even numbers in a list of integers.
    private static int sumOfEvenNumbers(List<Integer> numbers) {
        int sum = 0;
        sum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        return sum;
    }

    //  Find and print the count of strings that have length greater than 5.
    private static int countString(){
        List<String> list = Arrays.asList("apple", "banana", "carrot", "dove", "ewi", "farm", "guava", "hurt");

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

}
