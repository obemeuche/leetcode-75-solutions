package com.algorithm.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D21DifferenceOfTwoArrays {
    /*
        https://leetcode.com/problems/find-the-difference-of-two-arrays/submissions/1352318322/?envType=study-plan-v2&envId=leetcode-75

        Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
        answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
        answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
        Note that the integers in the lists may be returned in any order.

        Example 1:
        Input: nums1 = [1,2,3], nums2 = [2,4,6]
        Output: [[1,3],[4,6]]
        Explanation:
        For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
        For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].

        Example 2:
        Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
        Output: [[3],[]]
        Explanation:
        For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
        Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
     */

    public static void main(String[] args) {
        int [] nums1 = {1,2,3,3};
        int [] nums2 = {1,1,2,2};

        System.out.println(findDifference(nums1, nums2));
    }

    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int j : nums2) {
            set2.add(j);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(Integer i : set1) {
            if(!set2.contains(i)) {
                list1.add(i);
            }
        }

        for(Integer i : set2) {
            if(!set1.contains(i)) {
                list2.add(i);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        return res;
    }
}
