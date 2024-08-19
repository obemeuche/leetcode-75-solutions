package com.algorithm.leetcode75.interviews;

public class Nutmeg {
    public static void main(String[] args) {
//        String input = "A4b3C2";
        String input = "A2bf3C5e1";
        System.out.println(decompressString(input));
    }

    //input - A4b3C2
    //output - AAAAbbbCC

    private static String decompressString(String input) {
        if (input == null || input.isEmpty()) return null;

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int digit = 0;

            if (Character.isAlphabetic(c) && Character.isDigit(input.charAt(i + 1))) {
                digit = Character.getNumericValue(input.charAt(i + 1));
                i++;
            }else{
                output.append(c);
            }

            for (int j = 0; j < digit; j++) {
                output.append(c);
            }
        }
        return output.toString();
    }

}
