package com.algorithm.leetcode.leetcode75;

public class D16MaxNoOfVowelInASubstringOfGivenLength {
    /*
        https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75

        Given a string s and an integer k, return the maximum number of vowel
        letters in any substring of s with length k.
        Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

        Example 1:
        Input: s = "abciiidef", k = 3
        Output: 3
        Explanation: The substring "iii" contains 3 vowel letters.

        Example 2:
        Input: s = "aeiou", k = 2
        Output: 2
        Explanation: Any substring of length 2 contains 2 vowels.

        Example 3:
        Input: s = "leetcode", k = 3
        Output: 2
        Explanation: "lee", "eet" and "ode" contain 2 vowels.
     */
    static int maxVowels(String s, int k) {
        //create a boolean method that returns true is it is a vowel or else false
        //using sliding window approach, iterate through the length k and get the count of all vowel characters.
        //create a maxVowelCount variable that keeps track of the max vowel count seen.
        //create a pointer variable 0 to keep track of the start of the window
        //iterate the string starting from index k
        //if vowel is seen increase count
        //if vowel is seen using the pointer index, reduce count
        //increase the pointer variable
        int count = 0;
        int maxVowelCount = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        maxVowelCount = Math.max(maxVowelCount, count);
        int pointer = 0;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(pointer))) {
                count--;
            }
            pointer++;
            maxVowelCount = Math.max(maxVowelCount, count);
        }
        return maxVowelCount;
    }

    static boolean isVowel(char s){
        return switch (s) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        String s = "abciiidef"; int k = 3;
        System.out.println(maxVowels(s,3));
    }
}
