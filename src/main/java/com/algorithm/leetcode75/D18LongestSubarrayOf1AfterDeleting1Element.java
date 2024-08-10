package com.algorithm.leetcode75;

public class D18LongestSubarrayOf1AfterDeleting1Element {
    /*
        https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75

        Given a binary array nums, you should delete one element from it. Return the size
        of the longest non-empty subarray containing only 1's in the resulting array.
        Return 0 if there is no such subarray.

        Example 1:
        Input: nums = [1,1,0,1]
        Output: 3
        Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

        Example 2:
        Input: nums = [0,1,1,1,0,1,1,0,1]
        Output: 5
        Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

        Example 3:
        Input: nums = [1,1,1]
        Output: 2
        Explanation: You must delete one element.
     */

    public static void main(String[] args) {
        int[] arr = {1,1,0,1};
        System.out.println(longestSubarray(arr));
    }

    static int longestSubarray(int[] nums) {
        if(nums.length == 0) return 0;

        int zero = 0; int count = 0; int maxOneCount = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 1){
                    count++;
                }else{
                    if(zero < 1){
                        zero++;
                        continue;
                    }else{
                        break;
                    }
                }
            }
            maxOneCount = Math.max(maxOneCount, count);
            count = 0;
        }
        if(maxOneCount == nums.length) return maxOneCount - 1;
        return maxOneCount;
    }
}
