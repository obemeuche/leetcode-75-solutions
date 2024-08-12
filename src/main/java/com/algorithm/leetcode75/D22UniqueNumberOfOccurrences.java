package com.algorithm.leetcode75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class D22UniqueNumberOfOccurrences {
    /*
        https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75

        Given an array of integers arr, return true if the number of occurrences of each value in
        the array is unique or false otherwise.

        Example 1:
        Input: arr = [1,2,2,1,1,3]
        Output: true
        Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

        Example 2:
        Input: arr = [1,2]
        Output: false

        Example 3:
        Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
        Output: true
     */

    public static void main(String[] args) {
        int [] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
    }

    static boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        System.out.println(map);

        HashSet<Integer> set = new HashSet<>();
        for (int value : map.values()) {
            if (!set.add(value)) return false;
        }
        return true;
    }
}
