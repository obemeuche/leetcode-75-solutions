package com.algorithm.leetcode.interviews;

import java.util.Random;
import java.util.Scanner;

public class OnwardTechnology {
     /*
    1. Employee ID Generator
    Use Case: Generate 20 unique employee IDs for a new company. Each employee ID:
    Is 8 characters long.
    Starts with 2 uppercase letters representing the department (e.g., HR, IT, FN),
    followed by 6 numbers (e.g., HR123456).
    Ensure that each ID starts with the correct department prefix.
    The rest of the ID contains 6 random numbers.
    Generate and print 20 unique employee IDs to the console.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter The Dept: ");
        String id = sc.nextLine();
        if (id.length() > 2){
            id = id.substring(0, 2);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(id.toUpperCase() + generateRandomNumber());
        }

    }


    static String generateRandomNumber(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

}
