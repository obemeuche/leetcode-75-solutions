package com.algorithm.leetcode75;

public class D17MaxConsecutiveOnes {
    /*
        https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75

        Given a binary array nums and an integer k, return the maximum number of
        consecutive 1's in the array if you can flip at most k 0's.

        Example 1:
        Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
        Output: 6
        Explanation: [1,1,1,0,0,1,1,1,1,1,1]
        Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

        Example 2:
        Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
        Output: 10
        Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
        Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     */

    static int longestOnes(int[] nums, int k) {
        int maxOneCount = Integer.MIN_VALUE;
        int count = 0;

        int tracker = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                 tracker++;
//                 count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 1)
                {
                    count++;
                }
                if (nums[j] == 0 && tracker <= k)
                {
                    tracker++;
                    count++;
                    if(tracker > k){
                        tracker = 0;
                        count = 0;
                        break;
                    }
                }
            }
            maxOneCount = Math.max(maxOneCount, count);
        }
        return maxOneCount;
    }

    static int longestOnes_Optimized(int[] nums, int k) {
        //this approach uses sliding window

        //Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
        //Output: 6
        //Explanation: [1,1,1,0,0,1,1,1,1,1,1]
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] == 0) k--;
            if (k < 0){
                if (nums[j] == 0) k++;
                j++;
            }
            i++;
        }

        return i - j;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes_Optimized(nums, k));
    }
}
