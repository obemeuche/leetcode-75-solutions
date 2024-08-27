package com.algorithm.leetcode.leetcodeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LuckyNumbersInAMatrix {
    /*
        https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/

        Given an m x n matrix of distinct numbers, return all lucky numbers in
        the matrix in any order. A lucky number is an element of the matrix such
        that it is the minimum element in its row and maximum in its column.

        Example 1:
        Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
        Output: [15]
        Explanation: 15 is the only lucky number since it is the minimum in its row and
        the maximum in its column.

        Example 2:
        Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
        Output: [12]
        Explanation: 12 is the only lucky number since it is the minimum in its row
        and the maximum in its column.

        Example 3:
        Input: matrix = [[7,8],[1,2]]
        Output: [7]
        Explanation: 7 is the only lucky number since it is the minimum in its row
        and the maximum in its column.
     */

    static List<Integer> luckyNumbers (int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int[] minRow = new int[rowLength];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        int[] maxCol = new int[colLength];

        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col < colLength; col++){
                int element = matrix[row][col];

                minRow[row] = Math.min(minRow[row], element);
                maxCol[col] = Math.max(maxCol[col], element);
            }
        }
        System.out.println("minRow: " + Arrays.toString(minRow));
        System.out.println("maxCol: " + Arrays.toString(maxCol));


        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col < colLength; col++){
                int element = matrix[row][col];
                if(element == minRow[row] && element == maxCol[col]){
                    System.out.println(element + " " + minRow[row]+ " " + maxCol[col]);
                    return Collections.singletonList(element);
                }
            }
        }
        return new ArrayList<>();

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(luckyNumbers(matrix));
    }
}
