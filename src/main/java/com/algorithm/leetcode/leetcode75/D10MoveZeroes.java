package com.algorithm.leetcode.leetcode75;

import java.util.Arrays;

public class D10MoveZeroes {
    /*
    Given an integer array nums, move all 0's to the end of it while maintaining
    the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:
    Input: nums = [0]
    Output: [0]

    Constraints:
    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1

    Follow up: Could you minimize the total number of operations done?
    * */

    static void moveZeroes(int[] nums) {
        //step 1: create a pointer variable to track the nonZero elements
        //step 2: iterate the array, using the pointer, move all nonZero's to the left
        //step 3: count the number of times nonZero's were moved.
        //step 4: iterate d array and fill all other parts with zero

        int n = nums.length;
        int nonZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZero] = nums[i];
                nonZero++;
            }
        }
        //fill up the rest indexes with 0
        for (int i = nonZero; i < n; i++) {
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    static void moveZeroes_Optimized(int[] nums) {
        int n = nums.length;
        int nonZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZero];
                nums[nonZero] = temp;
                nonZero++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        moveZeroes(nums);
        moveZeroes_Optimized(nums);
    }
}
