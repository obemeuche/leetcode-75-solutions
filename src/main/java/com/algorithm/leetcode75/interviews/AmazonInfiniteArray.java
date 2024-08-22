package com.algorithm.leetcode75.interviews;

public class AmazonInfiniteArray {
    // https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    // Find position of an element in a sorted array of infinite numbers
    public static void main(String[] args) {
        int [] arr = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170}; int target = 10;
        System.out.println(infiniteArray(arr, target));
    }

    static int infiniteArray(int[] arr, int target) {
        //since array is infinite, we can't get the length using arr.length
        //we take the end in bits and then double the length
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            //temp to hold new start position
            int temp = end + 1;
            //double the box between start and end position
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target) {
                return mid;
            }else if(target > arr[mid]) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
