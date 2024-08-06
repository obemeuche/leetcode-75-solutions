package com.algorithm.leetcode75.others;

public class BinarySearch {
    public static void main(String[] args) {
//        int [] arr = {1,2,3,4,5,6,7,8,9}; int target = 9;
        int [] arr = {9,8,7,6,5,4,3,2}; int target = 6;
//        System.out.println(binarySearch(arr, target));
        System.out.println(orderAgnosticBS(arr, target));
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
           int  mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] < target)
            {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }


    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        //checking if array is ascending or descending
        boolean isAscending = arr[end] > arr[start];

        while (start <= end) {
            int  mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if(isAscending){
                if (arr[mid] < target)
                {
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }else {
                if (arr[mid] > target)
                {
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
