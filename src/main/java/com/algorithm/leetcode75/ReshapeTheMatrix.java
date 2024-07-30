package com.algorithm.leetcode75;

import java.util.Arrays;

public class ReshapeTheMatrix {
    /*
        https://leetcode.com/problems/reshape-the-matrix/description/

        In MATLAB, there is a handy function called reshape which can reshape an
         x n matrix into a new one with a different size r x c keeping its original data.
         You are given an m x n matrix mat and two integers r and c representing the
         number of rows and the number of columns of the wanted reshaped matrix.
         The reshaped matrix should be filled with all the elements of the original
         matrix in the same row-traversing order as they were. If the reshape operation
         with given parameters is possible and legal, output the new reshaped matrix;
         Otherwise, output the original matrix.

    Example 1:
    Input: mat = [[1,2],[3,4]], r = 1, c = 4
    Output: [[1,2,3,4]]

    Example 2:
    Input: mat = [[1,2],[3,4]], r = 2, c = 4
    Output: [[1,2],[3,4]]
     */
    static int[][] matrixReshape(int[][] mat, int r, int c) {
        int matRow = mat.length;
        int matCol = mat[0].length;
        //check if product of dimention of mat array is not equal to product of r and c.
        // If not equal, return mat array. This means we can't fill the elements
        // perfectly in one of the matrix.
        if(matRow * matCol != r * c) return mat;

        //create a new 2D array with row and col size equals r and c respectively.
        int [][] reshaped = new int[r][c];
        int rowIndex = 0, colIndex = 0;

        //Traversing the mat matrix and storing its values in new matrix output cols wise
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[row].length; col++){
                reshaped[rowIndex][colIndex] = mat[row][col];
                colIndex++;
                if(colIndex == c){
                    colIndex = 0;
                    rowIndex++;
                }
            }
        }
//        System.out.println(Arrays.deepToString(reshaped));
        return reshaped;

    }

    public static void main(String[] args) {
        int [][] arr = {{1,2},{3,4}}; int r = 1; int c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(arr, r, c)));
    }
}
