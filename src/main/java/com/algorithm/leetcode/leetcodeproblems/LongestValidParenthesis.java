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
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParentheses2(s));
    }

    private static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    private static int longestValidParentheses2(String s) {
        //String s = "(()())";
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
//                System.out.println("stack: " + stack);
                count++;
            }else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                count++;
            }else{
                count--;
            }
        }
        return count;
    }
}
