package com.algorithm.leetcode.binarysearchapproach;

public class RotationCountInRotatedArray {
    /*
        Given an array arr[] of size N having distinct numbers sorted in increasing order and
        the array has been right rotated (i.e, the last element will be cyclically shifted to the
        starting position of the array) k number of times, the task is to find the value of k.
     */

    public static void main(String[] args) {
//        int[] arr = {15, 18, 2, 3, 6, 12};
//        int[] arr = {7, 9, 11, 12, 5};
        int[] arr = {7, 9, 11, 12, 15};
        System.out.println(rotationCount(arr));
    }

    private static int rotationCount(int [] arr){
        //validate array is not empty
        if (arr == null || arr.length == 0) return 0;
        //find the index of the peakElement in the rotated array
        int peak = findPivot(arr);
        //and return the count of the peak element in the array
        return peak + 1;

    }

    private static int findPivot(int [] arr){
        int start = 0; int end = arr.length - 1;
        while (start != end){
            int mid = (start + end) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if (arr[mid] >= arr[start]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
