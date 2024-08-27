package com.algorithm.leetcode.otherapplications;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one from the following options:");
        System.out.println("1.) USD to €");
        System.out.println("2.) € to USD");
        System.out.println("3.) £ to USD");

        int option = scanner.nextInt();
        convertCurrency(option, scanner);
    }

     static void convertCurrency(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.println("Please enter the amount you would like to convert: ");
                double usd = scanner.nextDouble();

                if (usd <= 0) {
                    System.out.println("Please input a number greater than zero.");
                }else {
                    System.out.println(usd + " USD is " + usd * 0.90 + " €. ");
                }
                break;
            case 2:
                System.out.println("Please enter the amount you would like to convert: ");
                double euro = scanner.nextDouble();
                if (euro <= 0) {
                    System.out.println("Please input a number greater than zero.");
                }else {
                    System.out.println(euro + " EURO is " + euro * 1.111 + " $. ");
                }
                break;
            case 3:
                System.out.println("Please enter the amount you would like to convert: ");
                double gbp = scanner.nextDouble();

                if (gbp <= 0) {
                    System.out.println("Please input a number greater than zero.");
                }else{
                    System.out.println(gbp + " GBP is " + gbp * 1.30 + " $. ");
                }
                break;
            default:
                System.out.println("Please enter a valid option.");
//                scanner.close();
        }
    }
}
