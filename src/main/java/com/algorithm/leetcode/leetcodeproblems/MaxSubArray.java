package com.algorithm.leetcode.leetcodeproblems;

public class MaxSubArray {
    /*
        https://leetcode.com/problems/maximum-subarray/description/

        Given an integer array nums, find the subarray with the largest sum, and return its sum.

        Example 1:
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: The subarray [4,-1,2,1] has the largest sum 6.

        Example 2:
        Input: nums = [1]
        Output: 1
        Explanation: The subarray [1] has the largest sum 1.

        Example 3:
        Input: nums = [5,4,-1,7,8]
        Output: 23
        Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     */

    static int maxSubArray(int[] nums) {
        //create 2 variables. the currentSum to hold the summation of the
        // elements in the array and the maxSum, which will be the max value returned.
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        //iterate the nums array, summing each element.
        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            //check is currentSum is less than 0, point it back to 0.
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int [] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
