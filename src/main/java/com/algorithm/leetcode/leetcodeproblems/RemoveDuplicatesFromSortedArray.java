package com.algorithm.leetcode.leetcodeproblems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    /*
        https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

        Given an integer array nums sorted in non-decreasing order,
        remove the duplicates in-place such that each unique element appears only once.
        The relative order of the elements should be kept the same. Then return the
        number of unique elements in nums.
        Consider the number of unique elements of nums to be k, to get accepted,
        you need to do the following things:
        Change the array nums such that the first k elements of nums contain
        the unique elements in the order they were present in nums initially.
        The remaining elements of nums are not important as well as the size of nums.
        Return k.

        Example 1:
        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).

        Example 2:
        Input: nums = [0,0,1,1,1,2,2,3,3,4]
        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
     */

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(nums));
    }

    static int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        //0,0,1,1,1,2,2,3,3,4
        //initiate a pointer variable called currentPosition to track the current position of the array
        int currentPosition = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[currentPosition - 1]){
                nums[currentPosition] = nums[i];
                currentPosition++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return currentPosition;
    }


    //won't pass criteria for ordering the array
    static int removeDuplicates2(int[] nums) {
        if(nums.length == 1) return 0;

        int first = nums[0];
        int position = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != first){
                nums[position] = nums[i];
                first = nums[i];
                position++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return position;
    }
}
