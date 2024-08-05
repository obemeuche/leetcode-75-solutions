package com.algorithm.leetcode75.others;

public class Palindrome {
    public static void main(String[] args) {
        String s = "abcqba";
        System.out.println(isPalindrome2(s));
    }

    static boolean isPalindrome(String s) {
        //check for null
        if (s == null || s.isEmpty()) return false;

        //using 2 pointers initialized outside the loop
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean isPalindrome2(String s) {
        if (s == null || s.isEmpty()) return false;
        //using pointers inside the while loop and looping through half the length of the string
        for (int i = 0; i < s.length() / 2; i++) {
            int end = s.length() - 1-i;
            if (s.charAt(i) != s.charAt(end)) return false;
        }

        return true;
    }
}
