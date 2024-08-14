package com.algorithm.leetcode75.otherleetcodeproblems;

import java.util.Arrays;

public class FirstAndLastPositionOfSortedArray {
    /*
        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1354961076/

        Given an array of integers nums sorted in non-decreasing order, find the starting
        and ending position of a given target value. If target is not found in the array, return [-1, -1].
        You must write an algorithm with O(log n) runtime complexity.

        Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]

        Example 2:
        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]

        Example 3:
        Input: nums = [], target = 0
        Output: [-1,-1]
     */

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10}; int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int[] result = new int[2];
        int start = 0; int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return new int[]{mid-1, mid};
            }else if(nums[mid] < target){
                start = mid + 1;
            }else
                end = mid - 1;
        }
        return new int[]{-1, -1};
    }
}
