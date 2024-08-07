package com.algorithm.leetcode75.interviews;

import java.util.Arrays;

public class ApexonTest {
    public static void main(String[] args) {

    }

    static int minCoins(int coins[], int V) {
        /*
            You are given coins of different denominations and a total amount of money.
            Write a function to compute the fewest number of coins that you need to make up
            that amount. If that amount of money cannot be made up by any combination of
            the coins, return -1.

            E.g. for the sample coins array {1,5,10,25} the value 55 could be made up
            of 3 coins, 5 (1x) and 25 (2x).
        */

        // Your code here
        Arrays.sort(coins);
        int minCount = 0;
        for(int i = coins.length -1; i >= 0;){
            if(V == 0) return minCount;
            if(V >= coins[i]){
                V -= coins[i];
                minCount++;
                System.out.println("coin: " + coins[i]);
                System.out.println("mincount1: " + minCount);
            }else{
                i--;
            }
        }
        System.out.println("mincount2: " + minCount);
        return minCount;
    }


    static String compress(String str) {
        /*
            Implement a method which performs basic string compression by counting
            sequences of repeating characters. Given “AABBBCCCD” it should return “A2B3C3D1”.

            Sample Input: AABA ABCDE KKKKK
            Sample Output: A2B1A1 A1B1C1D1E1 K5
         */

        // Your code here
        if(str.length() == 0) return "";

        //AABCA:
        //A2B1C1A1
        //AABBBCCCD
        int count = 0;
        int currentPosition = 0;
        char [] charArray = str.toCharArray();
        char currentCharacter = charArray[0];
        for(int i = 0; i < charArray.length;){
            char letter = charArray[0];
            if(currentCharacter == letter){
                count++;

            }else{
                i++;
            }


        }
        return "";
    }
}
