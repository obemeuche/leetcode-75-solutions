package com.algorithm.leetcode75.otherleetcodeproblems;

import java.util.Arrays;

public class MaximumSumOfArrayAfterKNegations {
    /*
        1005
        https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/submissions/1355898017/

        Given an integer array nums and an integer k, modify the array in the following way:
        choose an index i and replace nums[i] with -nums[i].
        You should apply this process exactly k times. You may choose the same index i multiple times.
        Return the largest possible sum of the array after modifying it in this way.

        Example 1:
        Input: nums = [4,2,3], k = 1
        Output: 5
        Explanation: Choose index 1 and nums becomes [4,-2,3].

        Example 2:
        Input: nums = [3,-1,0,2], k = 3
        Output: 6
        Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].

        Example 3:
        Input: nums = [2,-3,-1,5,-4], k = 2
        Output: 13
        Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
     */

    public static void main(String[] args) {
        int[] nums = {-4, -2, -3};
        int k = 4;
//        System.out.println(largestSumAfterKNegations(nums, k));
        System.out.println(largestSumAfterKNegations2(nums, k));
    }

    static int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        //[-4,-3,-2] [4,-3,-2]
        //[-2,4,9,9,8]
        int i = 0;
        while (k > 0) {
            nums[i] = -nums[i];
            k--;
            Arrays.sort(nums);
        }
        System.out.println(Arrays.toString(nums));
        return Arrays.stream(nums).sum();
    }

    static int largestSumAfterKNegations2(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        //[-4,-3,-2] //4, -3, -2
        //[-2,4,9,9,8]
        int pointer = 1;
        int i = 0;
        int a = 0;
        while (k > 0) {
            nums[i] = -nums[i];
            k--;
            a++;
            if (nums[i] > nums[pointer] && pointer <= nums.length - 1) {
                pointer++;
                i++;
            }
        }
        System.out.println(a);
        System.out.println(Arrays.toString(nums));
        return 0;
    }
}
