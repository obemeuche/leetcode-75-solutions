package com.algorithm.leetcode75;

import java.util.Scanner;

public class AFewPracticeAlgo {

    static void fibonnacci(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();

        int previous = 0;
        int next = 1;
        int count = 2;
        int sum = 0;
        while (count <= n) {
            sum = previous + next;
            previous = next;
            next = sum;
            count++;
        }
        System.out.println("value at nth index is " + sum);
    }

    static void countNumOccurrence(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int nums = sc.nextInt();
        System.out.print("Enter nth number : ");
        int n = sc.nextInt();

        int count = 0;
        while (nums > 0){
            int rem = nums % 10;
            if(rem == n){
                count++;
            }
            nums = nums / 10;
        }

        System.out.println("count is " + count);
    }

    static void reverseNum(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int number = sc.nextInt();

        int newNumber = 0;
        while(number > 0){
            int rem = number % 10;
            number /= 10;

            newNumber = newNumber * 10 + rem;
        }
        System.out.println("New num: " + newNumber);
    }


    public static void main(String[] args) {
//        fibonnacci();
//        countNumOccurrence();
        reverseNum();
    }
}
