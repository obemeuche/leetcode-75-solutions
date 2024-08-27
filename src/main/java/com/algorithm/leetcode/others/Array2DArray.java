package com.algorithm.leetcode.others;

import java.util.Arrays;
import java.util.Random;

public class Array2DArray {

    static int[][] fill2DArray()
    {
        Random rand = new Random();

        int [][] arr = new int[3][3];
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[row].length; col++){
                arr[row][col] = rand.nextInt(50) + 1;
            }
        }
        System.out.println((Arrays.deepToString(arr)));
        return arr;
    }

    static int [] findTarget (int [][] arr, int target){
        /*
           --> col
     row   1    2   3
      |    3    4   5
           6    7   8
        */

        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[row].length; col++){
                if(arr[row][col] == target){
                    return new int []{row,col};
                }
            }
        }
        return new int []{-1,-1};
    }

    public static void main(String[] args) {
        int [][] arr = fill2DArray();
        System.out.println(Arrays.toString(findTarget(arr, 50)));
    }
}
