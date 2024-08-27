package com.algorithm.leetcode.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RippleTest {
    /*
        https://leetcode.com/problems/merge-intervals/description/

        Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping
        intervals, and return an array of the non-overlapping intervals that cover all the
        intervals in the input.

        Example 1:
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

        Example 2:
        Input: intervals = [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */

    public static void main(String[] args) {
        int [][] intervals = {{1,3},{8,10},{15,18},{2,6}};
//        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    static int[][] merge(int[][] intervals) {
        //sort the 2D array
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        System.out.println("sorted array: " + Arrays.deepToString(intervals));
        int [] prev = intervals[0];
        //create a list or int array variable to store merged arrays
        List<int[]> merged = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            //get current interval
            int [] curr = intervals[i];
            //check if current starting time is less than or equal to previous ending time
            //find the max current ending time and previous ending time and replace with previous ending time
            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            }else{
                //if not, merge prev time to merge variable
                merged.add(prev);
                //replace previous time with current time
                prev = curr;
            }
        }
        //add the last previous time
        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
}
