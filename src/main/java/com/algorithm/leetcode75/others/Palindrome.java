package com.algorithm.leetcode75.others;

public class Palindrome {
    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        //check for null
        if (s == null || s.isEmpty()) return false;

        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
