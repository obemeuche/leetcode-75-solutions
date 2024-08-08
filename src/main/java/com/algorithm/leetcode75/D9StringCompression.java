package com.algorithm.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D9StringCompression {
    /*
    * Given an array of characters chars, compress it using the following algorithm:
    * Begin with an empty string s. For each group of consecutive repeating characters in chars:

    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.
    The compressed string s should not be returned separately, but instead, be
    stored in the input character array chars. Note that group lengths that
    are 10 or longer will be split into multiple characters in chars.

    After you are done modifying the input array, return the new length of the array.
    You must write an algorithm that uses only constant extra space.

    Example 1:
    Input: chars = ["a","a","b","b","c","c","c"]
    Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
    Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

    Example 2:
    Input: chars = ["a"]
    Output: Return 1, and the first character of the input array should be: ["a"]
    Explanation: The only group is "a", which remains uncompressed since it's a single character.

    Example 3:
    Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
    Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

    Constraints:
    1 <= chars.length <= 2000
    chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
    * */

    static int compress(char[] chars) {
        //step 1: sort array
        //create a count variable to count the no of times the same character is seen
        //iterate through the array picking the fist char
        //create a second loop

        int currentPosition = 0;

        for(int i = 0; i < chars.length; i++){
            char letter = chars[i];

            int count = 0;
            while(i < chars.length && chars[i] == letter){
                count++;
                i++;
            }

            chars[currentPosition] = letter;
            currentPosition++;
            if(count > 1){
                char [] ch = String.valueOf(count).toCharArray();
                for(char c : ch){
                    chars[currentPosition] = c;
                    currentPosition++;
                }
            }
            i--;
        }
        System.out.println(chars);
        return currentPosition;

    }

    static int compress2(char[] chars) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        char letter = chars[0];
        for(int i = 0; i < chars.length;){
            if(letter != chars[i]){
                if(count > 1) {
                    sb.append(letter).append(count);
                }else {
                    sb.append(letter);
                }
                count = 0;
                letter = chars[i];
            }else {
                count++;
                i++;
            }
        }

        sb.append(letter).append(count);
        System.out.println("sb: " + sb);
        return sb.toString().length();
    }

    public static void main(String[] args) {
//        char [] ch = {'a','a','b','b','c','c','c'};
        char [] ch = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
//        System.out.println(compress(ch));
        System.out.println(compress2(ch));
    }

}
