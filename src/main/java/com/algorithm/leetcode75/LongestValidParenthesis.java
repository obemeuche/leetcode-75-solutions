package com.algorithm.leetcode75;

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

    static int longestValidParentheses(String s) {
//        int openCount = 0;
//        int closeCount = 0;
//
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i) == '('){
//                openCount++;
//            }
//            if(s.charAt(i) == ')'){
//                closeCount++;
//            }
//        }
//        if(openCount > closeCount){
//            return closeCount * 2;
//        }else if(closeCount > openCount){
//            return openCount * 2;
//        }else {
//            return closeCount + openCount;
//        }
//    }

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

    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(longestValidParentheses(s));
    }

}
