package com.algorithm.leetcode.leetcode75;

public class D4CanPlaceFlowers {

    /*
    * You have a long flowerbed in which some of the plots are planted,
    * and some are not. However, flowers cannot be planted in adjacent plots.
    * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
    * and 1 means not empty, and an integer n, return true if n new flowers can be
    * planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

    Example 1:
    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: true

    Example 2:
    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: false

    Constraints:
    1 <= flowerbed.length <= 2 * 104
    flowerbed[i] is 0 or 1.
    There are no two adjacent flowers in flowerbed.
    0 <= n <= flowerbed.length
    * */

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //step 1: check if n = 0
        //step 1b: create a count variable to keep track of adjacent plots that are empty.
        //step 2: iterate through the array.
        //step 4: compare left and right values to know if empty, increase count variable
        //step 5: if empty, compare with value n and count. if n <= count, return true, else false.
        //(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 1)
        //[0,0,0], n=2
        //[1,0,1]
        if (n == 0) {
            return true;
        }
        //check if flowerbed length is 1 and is empty (0)
        if(flowerbed.length == 1 && flowerbed[0] == 0) {
            return n < 2;
        }
        //check if flowerbed length is 1 and is not empty (1)
        if(flowerbed.length == 1 && flowerbed[0] == 1) {
            return n == 0;
        }

        int count = 0;
        for(int i = 0; i < flowerbed.length; i++)
        {
            //check the beginning of the flowerbed
            if(i == 0){
                if(flowerbed[i] == 0 && flowerbed[i + 1] == 0){
                    count++;
                    i++;
                }
                continue;
            }

            //check the ending of the flowerbed
            if(i == flowerbed.length - 1){
                if(flowerbed[i] == 0 && flowerbed[i - 1] == 0){
                    count++;
                }
                continue;
            }

            if(flowerbed[i] == 0)
            {
                if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                    count++;
                    i++;
                }
            }
        }
        System.out.println("count: " + count);
        return n <= count;
    }

    public static void main(String[] args) {

    }

}
