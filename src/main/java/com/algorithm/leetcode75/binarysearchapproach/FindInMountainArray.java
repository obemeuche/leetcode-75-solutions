package com.algorithm.leetcode75.binarysearchapproach;

public class FindInMountainArray {
    /*
        https://leetcode.com/problems/find-in-mountain-array/description/

        (This problem is an interactive problem.)
        You may recall that an array arr is a mountain array if and only if:
        arr.length >= 3
        There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
        Given a mountain array mountainArr, return the minimum index such that
        mountainArr.get(index) == target. If such an index does not exist, return -1.
        You cannot access the mountain array directly. You may only access the array using a
        MountainArray interface:

        MountainArray.get(k) returns the element of the array at index k (0-indexed).
        MountainArray.length() returns the length of the array.
        Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.
        Also, any solutions that attempt to circumvent the judge will result in disqualification.

        Example 1:
        Input: array = [1,2,3,4,5,3,1], target = 3
        Output: 2
        Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

        Example 2:
        Input: array = [0,1,2,4,2,1], target = 3
        Output: -1
        Explanation: 3 does not exist in the array, so we return -1.
     */

    public static void main(String[] args) {
        int[] arr = {1,5,2}; int target = 2;
        System.out.println(findInMountainArray(arr, target));
    }

    static int findInMountainArray(int[] nums, int target) {
        //find peak element in the mountain array
        int peak = findPeakElement(nums);

        //check for target in left and right of both sides
        boolean isAsc = true;
        int leftIndex = binarySearch(nums, target, 0, peak, isAsc);
        if(leftIndex != -1){
            return leftIndex;
        }

        return binarySearch(nums, target, peak, nums.length - 1, false);
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
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        return start; //or end as both are equal
    }

    static int binarySearch(int[] arr, int target, int start, int end, boolean isAsc) {
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == target){
                System.out.println("middle: " + mid);
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
