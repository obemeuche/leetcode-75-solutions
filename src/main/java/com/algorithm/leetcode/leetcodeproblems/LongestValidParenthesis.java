package com.algorithm.leetcode.leetcodeproblems;

import java.util.Stack;

public class LongestValidParenthesis {
    /*
        https://leetcode.com/problems/longest-valid-parentheses/description/

        Given a string containing just the characters '(' and ')', return the
        length of the longest valid (well-formed) parentheses substring

        Example 1:
        Input: s = "(()"
        Output: 2
        Explanation: The longest valid parentheses substring is "()".

        Example 2:
        Input: s = ")()())"
        Output: 4
        Explanation: The longest valid parentheses substring is "()()".

        Example 3:
        Input: s = ""
        Output: 0
     */

    public static void main(String[] args) {
        String s = "(()";
//        String s = ")()())";
//        String s = "(()())";
        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParentheses_NotOptimized(s));
    }

    private static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    private static int longestValidParentheses_NotOptimized(String s) {

        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                count++;
            } else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                count++;
            } else {
                continue;
            }

            if (s.length() - 1 == i && !stack.isEmpty() && stack.peek() == '(') {
                int j = stack.size();
                count = count - j;
            }
        }
        return count;
    }
}
