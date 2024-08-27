package com.algorithm.leetcode.dailycodingproblem;

import java.util.HashSet;
import java.util.Set;

public class D4 {
    /*
        This problem was asked by Stripe.
        Given an array of integers, find the first missing positive integer in linear
        time and constant space. In other words, find the lowest positive integer that
        does not exist in the array. The array can contain duplicates and negative numbers as well.

        For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
        You can modify the input array in-place
     */

    public static void main(String[] args) {
        int [] nums = {1, 2, 0};
        System.out.println(lowestPositiveInteger(nums));
    }

    static int lowestPositiveInteger(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        //add all elements in a hashset to eliminate duplicates
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if(num > 0) set.add(num);
        }
        //iterate 2ru the length of array + 1
        //check where index is not found in set and return index
        for (int i = 1; i <= arr.length; i++) {
            if(!set.contains(i)) return i;
        }
        return -1;
    }
}
