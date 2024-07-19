package com.algorithm.leetcode75;

import java.util.Arrays;

public class D7ProductOfArrayExceptItself {
    /*
    * Given an integer array nums, return an array answer such that answer[i]
    * is equal to the product of all the elements of nums except nums[i].
    * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    * You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

    Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]

    Constraints:
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    * */

    static int [] bruteForce(int[] arr) {
        int n = arr.length;
        int [] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    temp *= arr[j];
                }
                ans[i] = temp;
            }
        }
        return ans;
    }

    //doesn't cater for 0 as we can't perform a division by 0
    static int [] productExceptItself(int[] arr) {
        int n = arr.length;
        int [] ans = new int[n];
        int temp = 1;
        for (int j : arr) {
            temp *= j;
        }
        for (int i = 0; i < n; i++) {
            ans[i] = temp / arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4};
//        int [] ans = bruteForce(arr);
//        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(productExceptItself(arr)));
    }
}
