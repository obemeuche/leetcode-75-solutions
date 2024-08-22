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
        int[] arr = {4,5,6,7,0,1,2}; int target = 0;

        //[1,3] target = 3;
        System.out.println(searchInRotatedArray(arr,target));
    }

    static int searchInRotatedArray(int[] nums, int target) {
        int peakIndex = findPeakElement(nums);
        //check from left position
        boolean isAsc = true;
        int leftIndex = binarySearch(nums, target, 0, peakIndex, false);
        if (leftIndex != -1){
            return leftIndex;
        }
        //check from the right position
        return binarySearch(nums, target, peakIndex + 1, nums.length - 1, true);
    }

    static int findPeakElement(int[] arr) {
        int start = 0; int end = arr.length - 1;

        //ans will be when start = end
        while(start != end){
            int mid = (start+end)/2;
            if(arr[mid] > arr[mid+1]){
                //you are in the decreasing part of the array
                //look left
                end = mid;
            }else {
                //you are in the increasing part of the array
                //look right
                start = mid+1;
            }
        }
        //start will be equal to end and pointing to the largest number
        //start and end are always trying to find the max element in the above checks
        return start; //or end as both are equal
    }

    static int binarySearch(int[] arr, int target, int start, int end, boolean isAsc) {
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target > arr[mid]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                if(target < arr[mid]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
