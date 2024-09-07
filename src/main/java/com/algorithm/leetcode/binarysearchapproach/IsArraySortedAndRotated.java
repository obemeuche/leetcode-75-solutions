package com.algorithm.leetcode.binarysearchapproach;

public class IsArraySortedAndRotated {
    /*
        https://www.geeksforgeeks.org/check-if-an-array-is-sorted-and-rotated/

        Given an array arr[] of size n, the task is to return true if it was originally
        sorted in non-decreasing order and then rotated (including zero rotations).
        Otherwise, return false. The array may contain duplicates.

        Examples:
        Input: arr[] = { 3, 4, 5, 1, 2 }
        Output: YES
        Explanation: The above array is sorted and rotated
        Sorted array: {1, 2, 3, 4, 5}
        Rotating this sorted array clockwise
        by 3 positions, we get: { 3, 4, 5, 1, 2}

        Input: arr[] = {3, 4, 6, 1, 2, 5}
        Output: NO
        Explanation: The above array can’t be rotated clockwise to form the sorted array.
     */

    public static void main(String[] args) {
//        int [] arr = {3, 4, 5, 1, 2};
        int [] arr = {3, 4, 6, 1, 2, 5};
        System.out.println(isRotatedAndSorted(arr));
    }

    private static boolean isRotatedAndSorted(int[] arr) {
        int n = findPivot(arr);
        if(n == - 1) return false;
        return true;
//        return findPivot(arr) + 1 == 0;
    }

    private static int findPivot(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (end > mid && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        //return count == 1 && arr[arr.length - 1] < arr[0];
        return -1;
    }
}
