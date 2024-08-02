package com.algorithm.leetcode75.otherleetcodeproblems;

import java.util.*;

public class TopKElement {
    /*
        https://leetcode.com/problems/top-k-frequent-elements/description/

        Given an integer array nums and an integer k, return the k most frequent elements.
        You may return the answer in any order.

        Example 1:
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]

        Example 2:
        Input: nums = [1], k = 1
        Output: [1]
     */

    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // Convert the HashMap to a List of Map.Entry objects and sort it
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        System.out.println("list: " + list);
        List <Integer> newList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            newList.add(entry.getKey());
        }

        int [] result = new int[k];
        System.out.println((newList));
        for(int i = 0; i < newList.subList(0, k).size(); i++){
            result[i] = newList.get(i);
        }
        return result;

    }

    public static void main(String[] args) {
        int [] nums = {5,-3,9,1,7,7,9,10,2,2,10,10,3,-1,3,7,-9,-1,3,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 3)));
    }
}
