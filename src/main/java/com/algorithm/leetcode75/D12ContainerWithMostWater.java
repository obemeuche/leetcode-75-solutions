package com.algorithm.leetcode75;

import java.util.Arrays;

public class D12ContainerWithMostWater {
    /*
    You are given an integer array height of length n. There are n vertical
    lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container
    contains the most water. Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

    Example 1:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

    Example 2:
    Input: height = [1,1]
    Output: 1

    Constraints:
    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
    * */

    static int maxArea(int[] height) {
        //area of rectangle = height * width
        //create two pointer variables to track the min height coming from left and right and to also get the width of the tank. left starts from 0 while right starts from the ending.
        //create a maxArea variable to track the maxArea calculated on each iteration
        //using a while loop with condition left < right, iterate the tank.
        //get the current area by multiplying the width (right - left) and the height(min height so the tank doesn't overflow)

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right){
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;

    }

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println((maxArea(height)));
    }
}
