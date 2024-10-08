package com.algorithm.leetcode.interviews;

import java.util.Arrays;

public class Github {
    /*
        there is a small, one way bridge that can carry a maximum weight of U units at a time,
        there is also a line of N cars waiting to cross the bridge. The weights of the cars are given
        as an array weight. The weight of the kth car in line is weight[k] (for K in range [0...n-1].
        The car that will enter the bridge first weighs weight[0], the car that will enter second
        weights weight[1] and so on.

        At most two cars can be on the bridge at the same time. To begin, the first two cars in line will
        enter the bridge. Then the third car will enter the bridge as soon as the first car leaves the bridge,
        the fourth car will enter when the second car leaves, and so on. The cars leave the bridge in the same
        order they entered it.
        However, this may lead to a situation where cars exceed the bridge's weight limit. To prevent
        such a situation, some drivers have to turn back. When a driver turns back, all drivers behind
        them in line move one position closer to the bridge. The driver who turns back is removed from
        the line and will not try to cross the bridge again.
        Your task is to find the minimum number of drivers that must turn back so that the bridge will
        not be overloaded.

        Write a function:
        class Solution i public int solution(int U, intll weight) : }
        that given an integer U representing the weight limit of the bridge and an array weight
        of N integers representing the weihts cars in line, returns the minimum number of drivers
        that must turn back so that the bridge will not be overloaded.

        For U = 9 and weight = [5, 3, 8, 1, 8, 7, 7, 6|, the function should return 4. After the 3rd, 5th, 6th
        and 7th cars turn back, the weights of the remaining cars in line are (5, 3, 1, 6]. Notice that instead of
        the 5th, 6th and 7th cars, any three of the last four cars can turn back to obtain an optimal answer.
        The cars will then cross the bridge as follows:
        the 1st car (weight 5) enters the bridge;
        the 2nd car (weight 3) enters the bridge, the total weight of cars on the bridge is 5 + 3 = 8;
        the 1st car (weight 5) leaves the bridge;
        the 3rd car (weight 1) enters the bridge, the total weight of cars on the bridge is 3 + 1 = 4;
        the 2nd car (weight 3) leaves the bridge;
        the 4th car (weight 6) enters the bridge, the total weight of cars on the bridge is 1 + 6 = 7;
        the 3rd car (weight 1) leaves the bridge;
        the 4th car (weight 6) leaves the bridge.
        During this process, the total weight of cars on the bridge does not exceed 9.

        For U = 7 and weight = [7, 6, 5, 2, 7, 4, 5, 4], the function should return 5. After the 1st, 2nd, 5th,
        6th and 7th cars turn back, the weights of the remaining cars in line are [5, 2, 4). Notice
        that instead of the 6th and 7th cars, any two of the last three cars can turn back to obtain
        an optimal answer.

        For U = 7 and weight = [3, 4, 3, 1], the function should return 0. There is no need for any car to
        turn back
        write an efficient algorithm for the following assumptions
        N is an integer within the range [1..100,000]
        each element of array weight is an integer within the range [1..1,000,000,000]
        U is an integer within the range [1..1,000,000,000]
     */

    public static void main(String[] args) {
        int U = 9;
        int[] weights = {3, 4, 3, 1};
//        int result = solution(U, weights);
        int result = solution2(U, weights);
        System.out.println("Minimum number of drivers that must turn back: " + result);
    }

    static int solution(int U, int[] weight) {
        int currentWeight = 0;
        int driversTurnedBack = 0;

        Arrays.sort(weight);
        System.out.println(Arrays.toString(weight));
        int first = 0;
        for (int w : weight) {
            if (currentWeight + w > U) {
                driversTurnedBack++;
                currentWeight = currentWeight - weight[first];
                first++;
            } else {
                currentWeight += w;
            }
        }
        return driversTurnedBack;
    }

    static int solution2(int U, int[] weight){

        int leaving = 0;
        int[] trip = new int[2];
        int startingIndex = -1;


        //initial first 2 weights
        for(int i = 0; i < weight.length - 1; i++){
            int first = weight[i];
            int second = weight[i+1];
            int sum = first + second;
            if(sum <= U){
                trip[0] = first;
                trip[1] = 2;
                startingIndex = i+2;
                break;
            }
            leaving++;
        }

        //subsequent cars
        for(int i = startingIndex; i < weight.length; i++){
            int toCompare = trip[1];
            int curr = weight[i];
            int sum = toCompare + curr;
            if(sum > U){
                leaving++;
            }else{
                pushForward(trip,curr);
            }
        }

        return leaving;
    }

    //trip organizer helper
    static void pushForward(int[] arr, int next){
        arr[0] = arr[1];
        arr[1] = next;
    }
}
