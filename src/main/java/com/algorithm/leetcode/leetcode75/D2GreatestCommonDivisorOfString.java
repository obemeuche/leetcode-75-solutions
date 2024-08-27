package com.algorithm.leetcode.leetcode75;

public class D2GreatestCommonDivisorOfString {
    static String gcdOfStrings(String str1, String str2) {
        while(true){
            //step 1: get the shorter and longer strings
            String shorterStr = str1.length() < str2.length() ? str1 : str2;
            String longerStr = str1.length() < str2.length() ? str2 : str1;
            //step 2: check if both strings are equal.
            if(longerStr.equals(shorterStr)) return shorterStr;

            if(longerStr.startsWith(shorterStr)){
                str1 = longerStr.substring(shorterStr.length());
                str2 = shorterStr;
            }else{
                return "";
            }
        }

    }

    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2));
    }
}
