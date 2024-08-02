package com.algorithm.leetcode75.otherleetcodeproblems;

public class D15MaximumAverageSubarray {
    /*
        https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75

        You are given an integer array nums consisting of n elements, and an integer k.
        Find a contiguous subarray whose length is equal to k that has the maximum
        average value and return this value. Any answer with a calculation error less
        than 10-5 will be accepted.

        Example 1:
        Input: nums = [1,12,-5,-6,50,3], k = 4
        Output: 12.75000
        Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

        Example 2:
        Input: nums = [5], k = 1
        Output: 5.00000
     */

    static double findMaximumAverageSubarray(int[] array, int k) {
        //get the average of the first k elements
        //iterate again, starting from k and use a sliding window to slide through
        //use a pointer to track the elements as the window adjusts
        double sum = 0;
        double maxAvg = 0;
        for(int i = 0; i < k; i++){
            sum += array[i];
        }
        maxAvg = sum / k;

        int starter = 0;
        for(int i = k; i < array.length; i++){
            sum = sum + array[i] - array[starter];
            maxAvg = Math.max(maxAvg, sum/k);
            starter++;
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        int [] array = {1,12,-5,-6,50,3}; int k = 4;
        System.out.println(findMaximumAverageSubarray(array, k));
    }
}
