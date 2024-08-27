package com.algorithm.leetcode.leetcode75;

import java.util.ArrayList;

public class D6ReverseWordsInAString {
    /*
    * Given an input string s, reverse the order of the words. A word is defined
    * as a sequence of non-space characters. The words in s will be separated by at least one space.
    * Return a string of the words in reverse order concatenated by a single space.
    * Note that s may contain leading or trailing spaces or multiple spaces between two words.
    * The returned string should only have a single space separating the words.
    * Do not include any extra spaces.

    Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"

    Example 2:
    Input: s = "  hello world  "
    Output: "world hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.

    Example 3:
    Input: s = "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

    Constraints:
    1 <= s.length <= 104
    s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    There is at least one word in s.
    * */

    static String reverseWords(String s) {
        //step 1: convert string into an array
        //step 1a: create a new variable (arrayList) to store the string array without whitespaces.
        //step 2: remove all white spaces found and move new string array into the arrayList.
        //step 2b: create a stringbuilder variable to store the reversedWords
        //step 3: loop through the new variable starting from the last index and append to the stringbuilder.
        //step 4: convert stringbuilder into a string and trim. then return the string.

        String[] words = s.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                list.add(word);
            }
        }

        StringBuilder reversedWords = new StringBuilder();
        // String reversedWords = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            // reversedWords += list.get(i) + " ";
            reversedWords.append(list.get(i)).append(" ");
        }

        return reversedWords.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Hello  World   yes";
        System.out.println(reverseWords(s));
    }
}
