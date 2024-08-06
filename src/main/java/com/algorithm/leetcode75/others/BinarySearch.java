package com.algorithm.leetcode75.others;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9}; int target = 9;
        System.out.println(binarySearch(arr, target));
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int steps = 0;

        while (start <= end) {
            steps++;
           int  mid = (start + end) / 2;
            if (arr[mid] == target) {
                System.out.println(steps);
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
}
