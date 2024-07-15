package com.algorithm.leetcode75;

import java.util.HashSet;

public class D2GreatestCommonDivisorOfString {
    static String gcdOfStrings(String str1, String str2) {
        //step 1: get the shorter string
        String shorterStr = str1.length() < str2.length() ? str1 : str2;
        //step 2: create a hashset variable to store the values of the shorter string, removing duplicates.
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0; i < shorterStr.length(); i++){
            hashSet.add(shorterStr.charAt(i));
        }
        //step 3: convert the hashset variable into a string object using a StringBuilder variable.
        StringBuilder uniqueStr = new StringBuilder();
        for(Character s : hashSet){
            uniqueStr.append(s);
        }
        String longerStr = str1.length() > str2.length() ? str1 : str2;
        //step 4: check how many times it is contained in the longer string.

        //if contained return the string, else return an empty string.
//        System.out.println("uniqueStr:" + uniqueStr);
//        System.out.println("longerStr:" + longerStr);
//        System.out.println("substring:" + uniqueStr.substring(uniqueStr.length()));
        if(longerStr.startsWith(uniqueStr.toString())){
            if(longerStr.substring(uniqueStr.toString().length()).startsWith(uniqueStr.toString())){
                return uniqueStr.toString();
            }
            return "";
        }
        return "";

    }

    public static void main(String[] args) {
        String str1 = "ABCDEF";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }
}
