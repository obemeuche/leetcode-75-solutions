package com.algorithm.leetcode.others;

import java.util.Arrays;
import java.util.List;

public class SomeStreamApplications {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sumOfEvenNumbers(list));
        System.out.println(countString());
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

}
