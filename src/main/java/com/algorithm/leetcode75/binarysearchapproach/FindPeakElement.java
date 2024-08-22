package com.algorithm.leetcode75.binarysearchapproach;

public class FindPeakElement {
    /*
        https://leetcode.com/problems/find-peak-element/description/

        A peak element is an element that is strictly greater than its neighbors.
        Given a 0-indexed integer array nums, find a peak element, and return its index.
        If the array contains multiple peaks, return the index to any of the peaks.
        You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered
        to be strictly greater than a neighbor that is outside the array.
        You must write an algorithm that runs in O(log n) time.

        Example 1:
        Input: nums = [1,2,3,1]
        Output: 2
        Explanation: 3 is a peak element and your function should return the index number 2.

        Example 2:
        Input: nums = [1,2,1,3,5,6,4]
        Output: 5
        Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
     */

    public static void main(String[] args) {
        int [] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }

    private static int findPeakElement(int[] arr) {
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
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        return start; //or end as both are equal
    }
}
