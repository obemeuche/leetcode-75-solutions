package com.algorithm.leetcode.dailycodingproblem;

import java.util.Arrays;

public class D2 {
    /*
        This problem was asked by Uber.
        Given an array of integers, return a new array such that each element at index i
        of the new array is the product of all the numbers in the original array except the one at i.
        For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
        If our input was [3, 2, 1], the expected output would be [2, 3, 6].

        Follow-up: what if you can't use division?
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        int[] copy = Arrays.copyOf(arr, arr.length);
//        System.out.println("copy: " + Arrays.toString(copy));
//        System.out.println(Arrays.toString(productOfArrayExceptItself(arr)));
        System.out.println(Arrays.toString(productOfArrayExceptItselfWithoutDivision(arr)));
    }

    static int [] productOfArrayExceptItself(int[] array) {
        int product = 1;
        for (int j : array) {
            product *= j;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0){
                array[i] = productOfZero(array, i);
            }
            array[i] = product/array[i];
        }
        return array;
    }

    private static int productOfZero(int[] array, int i) {
        int product = 1;
        for (int index = 0; index < array.length; index++) {
            if (index != i){
                product *= array[index];
            }
        }
        return product;
    }


    static int [] productOfArrayExceptItselfWithoutDivision(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == array[i]){
                array[i] = productOfElements(copy, i);
            }
        }
        return array;
    }

    private static int productOfElements(int[] copy, int index) {
        int product = 1;
        for (int i = 0; i < copy.length; i++){
            if (i != index){
                product *= copy[i];
            }
        }
        return product;
    }
}
