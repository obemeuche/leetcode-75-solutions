package com.algorithm.leetcode75.binarysearchapproach;

public class SearchInRotatedArray {
    /*
        There is an integer array nums sorted in ascending order (with distinct values).
        Prior to being passed to your function, nums is possibly rotated at an unknown
        pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k],
        nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

        Given the array nums after the possible rotation and an integer target, return the index
        of target if it is in nums, or -1 if it is not in nums.
        You must write an algorithm with O(log n) runtime complexity.

        Example 1:
        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4

        Example 2:
        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1

        Example 3:
        Input: nums = [1], target = 0
        Output: -1
     */

    public static void main(String[] args) {
        int[] arr = {6,7,1,2,3,4,5}; int target = 6;
//        int[] arr = {5,1,3}; int target = 1;
//        int[] arr = {1,3}; int target = 0;

        //[1,3] target = 3;
        System.out.println(searchInRotatedArray(arr, target));
    }

    static int searchInRotatedArray(int[] nums, int target) {
        int peakIndex = findPivotIndex(nums);
        //check from left position
        boolean isAsc = true;
        int leftIndex = binarySearch(nums, target, 0, peakIndex);
        if (leftIndex != -1) {
            return leftIndex;
        }
        //check from the right position
        return binarySearch(nums, target, peakIndex, nums.length - 1);
    }

    private static int findPivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        //ans will be when start = end
        //5,1,3-5   1,3-0
        while (start != end) {
            int mid = (start + end) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("Pivot index is: " + start);
        return start; //or end as both are equal
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
