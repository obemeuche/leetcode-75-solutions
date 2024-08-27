package com.algorithm.leetcode.binarysearchapproach;

public class SearchInsertPosition {
    /*
        https://leetcode.com/problems/search-insert-position/description/

        Given a sorted array of distinct integers and a target value, return the index if
        the target is found. If not, return the index where it would be if it were inserted in order.
        You must write an algorithm with O(log n) runtime complexity.

        Example 1:
        Input: nums = [1,3,5,6], target = 5
        Output: 2

        Example 2:
        Input: nums = [1,3,5,6], target = 2
        Output: 1

        Example 3:
        Input: nums = [1,3,5,6], target = 7
        Output: 4
     */

    public static void main(String[] args) {
        int [] arr = {1,3,5,6}; int target = 2;
        System.out.println(searchInsert(arr, target));
    }

    static int searchInsert(int[] nums, int target) {
        //applying binary search and instead of returning -1, return the start index after the loop breaks
        int start = 0; int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}
