package com.algorithm.leetcode75;

public class D11IsSubsequence {
    /*
    * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    * A subsequence of a string is a new string that is formed from the original string by
    * deleting some (can be none) of the characters without disturbing the relative positions
    * of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    Example 1:
    Input: s = "abc", t = "ahbgdc"
    Output: true

    Example 2:
    Input: s = "axc", t = "ahbgdc"
    Output: false

    Constraints:
    0 <= s.length <= 100
    0 <= t.length <= 104
    s and t consist only of lowercase English letters.
    * */

    static boolean isSubsequence(String s, String t) {
        //step 1: check if s is empty or its length is greater than length t
        if(s.isEmpty()) return true;
        if(s.length() > t.length()) return false;
        //step 2: create a count variable to count the times no of characters in t are found in s
        //step 3: iterate t and increase the count if char in t equals char in s
        //step 4: check if length of s == count and return true.
        int count = 0;
        for(int i = 0; i < t.length(); i++){
             if(s.length() == count) return true;
            if(t.charAt(i) == s.charAt(count)){
                count++;
            }
        }
        return s.length() == count;
    }

    public static void main(String[] args) {
        String s = "b";
        String t = "abc";
        System.out.println(isSubsequence(s, t));
    }
}
