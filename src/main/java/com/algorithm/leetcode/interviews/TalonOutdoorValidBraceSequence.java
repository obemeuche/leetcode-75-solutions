package com.algorithm.leetcode.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TalonOutdoorValidBraceSequence {
    /*
        You are given a list of strings, where each string contains only the characters (), {}, and [].
        Write a function that determines if each string is a valid sequence of braces.
        A string is considered valid if:
        Every opening brace ((, {, [) has a corresponding closing brace (), }, ]).
        Braces must close in the correct order. For example, "{[()]}" is valid but "{[}]" is not.
        Your task is to implement a function that returns a list of strings, where each entry is
        either "YES" (if the corresponding input string is valid) or "NO" (if it is not).
     */

    public static void main(String[] args) {
        List<String> input = Arrays.asList("{}[]()", "{[}]", "({[]})", "[()]", "([)]");
        System.out.println(matchingBraces(input));
    }

    public static List<String> matchingBraces(List<String> braces){
        List<String> returnMatchingBraces = new ArrayList<>();

        for (String brace : braces) {
            if (isValidBraces(brace)){
                returnMatchingBraces.add("YES");
            }else {
                returnMatchingBraces.add("NO");
            }
        }
        return returnMatchingBraces;
    }

    private static boolean isValidBraces(String brace) {
        Stack<Character> stack = new Stack<>();

        for (char c : brace.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }else if(c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else if(c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
