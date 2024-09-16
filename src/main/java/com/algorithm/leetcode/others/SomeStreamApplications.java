package com.algorithm.leetcode.others;

import java.util.Arrays;
import java.util.List;

public class SomeStreamApplications {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sumOfEvenNumbers(list));
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



}
