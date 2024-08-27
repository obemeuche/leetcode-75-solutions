package com.algorithm.leetcode.leetcode75;

public class D8IncreasingTripletSubSequence {
    /*
    Given an integer array nums, return true if there exists a triple of indices
     such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

    Example 1:
    Input: nums = [1,2,3,4,5]
    Output: true
    Explanation: Any triplet where i < j < k is valid.

    Example 2:
    Input: nums = [5,4,3,2,1]
    Output: false
    Explanation: No triplet exists.

    Example 3:
    Input: nums = [2,1,5,0,4,6]
    Output: true
    Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.

    Constraints:
    1 <= nums.length <= 5 * 105
    -231 <= nums[i] <= 231 - 1
    * */

    //doesn't work for all test cases
    static boolean bruteForceTrialOnIncreasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
           if(nums[i] < nums[i+1] && nums[i+1] < nums[i+2]){
               return true;
           }
        }
        return false;
    }

    static boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i <= min1) {
                min1 = i;
            }else if (i <= min2) {
                min2 = i;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {20,100,10,12,5,13};
        System.out.println(increasingTriplet(nums));
    }
}
