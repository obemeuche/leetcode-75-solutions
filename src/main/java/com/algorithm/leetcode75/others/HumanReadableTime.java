package com.algorithm.leetcode75.others;

public class HumanReadableTime {
    /*
        https://www.codewars.com/kata/52685f7382004e774f0001f7/java

        Write a function, which takes a non-negative integer (seconds) as input and
        returns the time in a human-readable format (HH:MM:SS)

        HH = hours, padded to 2 digits, range: 00 - 99
        MM = minutes, padded to 2 digits, range: 00 - 59
        SS = seconds, padded to 2 digits, range: 00 - 59
        The maximum time never exceeds 359999 (99:59:59)
     */

    public static void main(String[] args) {
        System.out.println(readableTime(51789));
    }

    static String readableTime(int seconds){
        if(seconds < 0 || seconds > 359999) return null;

        if(seconds == 0) return "00:00:00";
        //check the hours
        int hours = seconds / 3600;

//        if(hours < 10) {
//            hours = Integer.parseInt("0" + hours);
//        }
        //get the remaining minutes
        seconds -= hours * 3600;
        int minutes = seconds / 60;
//        if(minutes < 10) {
//            minutes = Integer.parseInt("0" + minutes);
//        }
        //check for seconds
        seconds -= minutes * 60;
        int second = seconds;
//        if(second < 10) {
//            second = Integer.parseInt("0" + second);
//            System.out.println(second);
//        }
        return String.format("%02d:%02d:%02d", hours, minutes, second);
//        return hours + ":" + minutes + ":" + second;
    }
}
