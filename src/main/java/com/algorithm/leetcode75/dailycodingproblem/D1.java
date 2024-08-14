package com.algorithm.leetcode75.dailycodingproblem;

import java.util.Arrays;

public class D1 {
    /*
        This problem was recently asked by Google.
        Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17
     */

    public static void main(String[] args) {
        int [] arr = {10, 15, 3, 7}; int k = 17;
        System.out.println(findSumOfK(arr, k));
    }

    static boolean findSumOfK(int[] arr, int k) {
        if (arr == null || arr.length == 0) return false;
        Arrays.sort(arr);
        int start = 0; int end = arr.length - 1;
        while (start <= end) {
            int sum = arr[start] + arr[end];
            if (sum == k) return true;
            else if (sum < k) start++;
            else end--;
        }
        return false;
    }
}
