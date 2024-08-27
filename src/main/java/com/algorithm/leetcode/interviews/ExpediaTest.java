package com.algorithm.leetcode.interviews;

import java.util.*;

public class ExpediaTest {
    /*
        Given an array of strings, find the K most frequently occurring words.
        Input: array: ["I", "love", "coding", "exercises", "coding", "exercises", "are",
        "the", "best", "exercises"], k: 2

        Expected Output: ["exercises", "coding"]
     */

    static String [] occurringWords(String [] s, int k)
    {
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
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            var value = entry.getValue();
            if(value > temp1){
                temp1 = value;
                list.add(0, entry.getKey());
            }
        }
        System.out.println(map);
        String [] result = new String[k];
        for(int i = 0; i < list.subList(0,k).size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    static String [] occurringWords_Optimized(String [] s, int k){
        Map<String, Integer> map = new HashMap<>();
        for(String word : s){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else {
                map.put(word, 1);
            }
        }
        // Convert the HashMap to a List of Map.Entry objects and sort it
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        System.out.println("list: " + list);
        List <String> sortedList = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : list){
            sortedList.add(entry.getKey());
        }
        String [] result = new String[k];
        for(int i = 0; i < sortedList.subList(0,k).size(); i++){
            result[i] = sortedList.get(i);
        }
        return result;

    }

    public static void main(String[] args) {
        String [] arr = {"I", "love", "coding", "exercises", "coding", "exercises", "are",
                "the", "best", "exercises"};

//        System.out.println(Arrays.toString(occurringWords(arr, 2)));

        System.out.println(Arrays.toString(occurringWords_Optimized(arr, 2)));
    }
}
