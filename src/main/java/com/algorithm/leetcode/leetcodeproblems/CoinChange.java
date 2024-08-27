package com.algorithm.leetcode.leetcodeproblems;

import java.util.Arrays;

public class CoinChange {
    /*
        https://leetcode.com/problems/coin-change/

        You are given an integer array coins representing coins of different denominations and
        an integer amount representing a total amount of money. Return the fewest number of
        coins that you need to make up that amount. If that amount of money cannot be made
        up by any combination of the coins, return -1.
        You may assume that you have an infinite number of each kind of coin.

        Example 1:
        Input: coins = [1,2,5], amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1

        Example 2:
        Input: coins = [2], amount = 3
        Output: -1

        Example 3:
        Input: coins = [1], amount = 0
        Output: 0
     */

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25}; int amount = 55;
        System.out.println(coinChange(coins, amount));
    }

    static int coinChange(int[] coins, int amount) {
        //sort the coins array
        Arrays.sort(coins);
        System.out.println("coins: " + Arrays.toString(coins));

        int minCount = 0;
        //iterate the array starting from the last index
        for(int i = coins.length - 1; i >= 0;){
            if(amount == 0) return minCount;
            if(amount >= coins[i]){
                System.out.println("coins: " + coins[i]);
                amount -= coins[i];
                minCount++;
            }else{
                System.out.println("coins: " + coins[i]);
                i--;
            }
        }
        System.out.println("minCount: " + minCount);
        System.out.println("amount: " + amount);
        if(amount > 0) return -1;

        return minCount;
    }
}
