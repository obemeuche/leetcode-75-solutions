package com.algorithm.leetcode75;

import java.util.Arrays;
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

    static boolean isPrimeNumber(){
        // note: prime numbers are numbers divisible by 1 and itself only without a remainder
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int num = scanner.nextInt();

        if (num <= 1) return false;

        int c = 2;
        while(c < num){
            if (num % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }

    static boolean isPrimeNumberOptimized(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int num = scanner.nextInt();

        if(num <= 1) return false;
        int c = 2;
        while (c * c < num){
            if(num % c == 0) return false;
            c++;
        }
        return true;
    }

    static boolean isArmStrong(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Number: ");
        int num = scanner.nextInt();
        int originalNum = num;

        int sum = 0;

        while(num > 0){
            int rem = num % 10;
            sum += (rem * rem * rem);
            num /= 10;
        }
        System.out.println("sum: " + sum);
        return sum == originalNum;
    }

    //reversing an array by creating a new array object
    static void reverseArray(int [] array){
        int startIndex = 0;
        int [] newArray = new int[array.length];
        for(int i = array.length-1; i >= 0; i--){
            newArray[startIndex] = array[i];
            startIndex++;
        }

        System.out.println(Arrays.toString(newArray));
    }

    //reversing an array using same array by swapping elements using 2 pointers.
    static void reverseArr(int [] arr){
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while(startIndex < endIndex){
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

        System.out.println(Arrays.toString(arr));
    }

    //reversing a string by converting to a char array and using 2 pointers to swap characters
    static void reverseString(String s){
        char [] sArray = s.toCharArray();
        int startIndex = 0;
        int endIndex = sArray.length - 1;

        while(startIndex < endIndex){
            char temp = sArray[startIndex];
            sArray[startIndex] = sArray[endIndex];
            sArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

        System.out.println(new String(sArray));
    }



    public static void main(String[] args) {
//        fibonnacci();
//        countNumOccurrence();
//        reverseNum();
//        boolean ans = isPrimeNumberOptimized();
//        boolean ans = isArmStrong();
//        System.out.println(ans);

//        int [] a ={2,3,4,5,6,9};
//        reverseArray(a);
//        reverseArr(a);

        String name = "Uchechi Obeme";
        reverseString(name);
    }
}
