package com.algorithm.leetcode75.interviews;

public class Nutmeg {
    public static void main(String[] args) {
//        String input = "A4b3C2";
//        String input = "A2bf3C5e1";
        String input = "2b1f3C5e1";
//        System.out.println(decompressString(input));
        System.out.println(decompressString2(input));
    }

    //input - A4b3C2
    //output - AAAAbbbCC

    private static String decompressString(String input) {
        if (input == null || input.isEmpty()) return null;

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            int count = 0;
            if (Character.isAlphabetic(c) && Character.isDigit(input.charAt(i + 1))) {
                count = Character.getNumericValue(input.charAt(i + 1));
                i++;
            }else{
                output.append(c);
            }
//            for (int j = 0; j < digit; j++) {
//                output.append(c);
//            }
            output.append(String.valueOf(c).repeat(Math.max(0, count)));
        }
        return output.toString();
    }

    static String decompressString2(String input) {
        if (input == null || input.isEmpty()) return null;
        StringBuilder output = new StringBuilder();
        //"2b1f3C5e1"
        //A4b3C2
        char previous = input.charAt(0);
        output.append(previous);
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!Character.isDigit(currentChar)) {
                output.append(currentChar);
                continue;
            }
            int count = 0;
            if (Character.isDigit(currentChar)) {
                count = Character.getNumericValue(currentChar);
//                i++;
            }

            for (int j = 0; j < count; j++) {
                output.append(previous);
            }
            previous = currentChar;

        }
        return output.toString();
    }

}
