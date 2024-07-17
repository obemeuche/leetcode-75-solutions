package com.algorithm.leetcode75;

public class D5ReverseVowelsOfAString {
    /*
    *Given a string s, reverse only all the vowels in the string and return it.
    * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear
    * in both lower and upper cases, more than once.
    * Example 1:
      Input: s = "hello"
      Output: "holle"

      * Example 2:
        Input: s = "leetcode"
        Output: "leotcede"

      Constraints:
      1 <= s.length <= 3 * 105
      s consist of printable ASCII characters.
    * */

    static String reverseVowels(String s) {
        //step 1: create a stringbuilder variable to store the vowels extracted from the string
        //step 2: convert the input string to a char array called "newChar"
        //step 4: iterate through the char array and check for vowels. if present, append to the stringbuilder.
        //step 5: if stringbuilder variable is empty, return the string as it is (meaning no vowels found)
        //step 6: if not empty, reverse the builder variable and convert to a char array.
        //step 7: iterate through the newChar array and replace all vowels with the reversed char in 6 above
        //step 8: convert newChar to string and return it.

        StringBuilder vowelBuilder = new StringBuilder();
        char [] newChar = s.toCharArray();
        for (char c : newChar) {
            if (isVowel(c)) {
                vowelBuilder.append(c);
            }
        }

        if(!vowelBuilder.isEmpty()){
            char [] reversedVowels = vowelBuilder.reverse().toString().toCharArray();

            int vowelIndex = 0;
            for (int i = 0; i < newChar.length; i++) {
                if (isVowel(newChar[i])) {
                    // Replace '0' with the vowel from reversedVowels
                    newChar[i] = reversedVowels[vowelIndex];
                    // Move to the next vowel
                    vowelIndex++;
                }
            }
            return new String(newChar);
        }

        return s;
    }

    static boolean isVowel(char c){
        return switch (c) {
            case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        String s = "0:u`bVbu`:0";
        System.out.println(reverseVowels(s));
    }
}
