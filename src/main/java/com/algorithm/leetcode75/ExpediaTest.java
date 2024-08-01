package com.algorithm.leetcode75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpediaTest {
    /*
        Given an array of strings, find the K most frequently occurring words.
        Input: array: ["I", "love", "coding", "exercises", "coding", "exercises", "are",
        "the", "best", "exercises"], k: 2

        Expected Output: ["exercises", "coding"]
     */

    static List<String> occurringWords(String [] s, int k){

        Map<String, Integer> map = new HashMap<>();
        for(String word : s){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else {
                map.put(word, 1);
            }
        }

        List<String> list = new ArrayList<>();
        int temp1 = 0;
//        int temp2 = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            var value = entry.getValue();
            if(value > temp1){
                temp1 = value;
                list.add(0, entry.getKey());
            }
            System.out.println(list);
        }
        System.out.println(map);
        return list.subList(0, k);
    }

    public static void main(String[] args) {
        String [] arr = {"I", "love", "coding", "exercises", "coding", "exercises", "are",
                "the", "best", "exercises"};

        System.out.println(occurringWords(arr,2));
    }
}
