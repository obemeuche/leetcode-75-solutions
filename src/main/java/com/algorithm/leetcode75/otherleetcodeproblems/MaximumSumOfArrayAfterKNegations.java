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
        int [] nums = {-4,-2,-3}; int k = 4;
        System.out.println(largestSumAfterKNegations(nums, k));
    }

    static int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        //[-1, 0, 2, 3]
        int i = 0;
        while(k > 0){
            if(nums[i] != 0){
                nums[i] *= -1;
                k--;
                if(nums[i] > nums[i + 1]) i++;
            }else{
                nums[i] *= -1;
                k--;
                System.out.println(nums[i]);
            }
        }
        System.out.println(Arrays.toString(nums));
        return Arrays.stream(nums).sum();
    }
}
