package com.algorithm.leetcode75;

import java.util.HashSet;

public class D1MergeStringsAlternately {
    /*
    * You are given two strings word1 and word2. Merge the strings by adding letters
    * in alternating order, starting with word1. If a string is longer than the other,
    * append the additional letters onto the end of the merged string. Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d

Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
    *
    * */

    public String mergeAlternately(String word1, String word2) {
        //step 1: create a stringbulder variable to store result
        StringBuilder builder = new StringBuilder();
        //step 2: compare both length of the string parameter
        int minLength = Math.min(word1.length(), word2.length());
        //step 3: iterate through the shorter length using a for loop
        for(int i = 0; i < minLength; i++){
            builder.append(word1.charAt(i)).append(word2.charAt(i));
        }
        //step 4: while in the for loop, access the values of word1 and word2. Append them using the stringbulider variable starting with word1.
        //step 5: identify the longer string and do a substring of the remaining unaccessed words.
        String longerWord = word1.length() > word2.length() ? word1:word2;
        //step 5a: if no longer word, return builder, else step 6.
        if(longerWord.length() == minLength){
            return builder.toString();
        }
        //step 6: append the unaccessed word to the string builder and return the builder.
        builder.append(longerWord.substring(minLength));
        return builder.toString();
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
    }
}
