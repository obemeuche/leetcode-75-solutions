package com.algorithm.leetcode75.otherleetcodeproblems;

public class PeakIndexInAMountainArray {
    /*
        https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

        You are given an integer mountain array arr of length n where the values increase
        to a peak element and then decrease.
        Return the index of the peak element.
        Your task is to solve it in O(log(n)) time complexity.
        Example 1:
        Input: arr = [0,1,0]
        Output: 1

        Example 2:
        Input: arr = [0,2,1,0]
        Output: 1

        Example 3:
        Input: arr = [0,10,5,2]
        Output: 1

        Constraints:
        3 <= arr.length <= 105
        0 <= arr[i] <= 106
        arr is guaranteed to be a mountain array.
     */

    public static void main(String[] args) {
        int [] arr = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] arr) {
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
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        return start;
    }
}
