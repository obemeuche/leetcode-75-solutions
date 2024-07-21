package com.algorithm.leetcode75;

import java.util.Arrays;

public class MinimumPackages {
    /*
    * The first question was about a given number of items, and 2 types of packages,
    * first one could carry 5 items and the second only 1 and the question was:
    * What is the minimal number of packages required to carry all the items with given
    * number of packages? So you actually had 3 parameters, the number of items,
    * the number of large packages and small packages and you should have returned
    * the minimal packages that could carry the items. If the packages were not enough
    * to carry the items the function should return -1. There was a static function ready to populate.
    * */

    static int noOfMinimumPackages(int item, int [] packages) {

        Arrays.sort(packages);
        int usedPackageCount = 0;
        for(int i = packages.length - 1; i >= 0; i--) {
            if(item == 0) return usedPackageCount;
            item -= packages[i];
            usedPackageCount++;
        }
        if(item > 0) return -1;
        return usedPackageCount;
    }


    static int noOfMinimumPackages(int item, int largePackage, int smallPackage) {

        int usedPackageCount = 0;

        int [] packages = new int[largePackage + smallPackage];
        Arrays.fill(packages, 0, largePackage, 5);
        Arrays.fill(packages, packages.length-smallPackage, packages.length, 1);
        System.out.println(Arrays.toString(packages));

        for (int aPackage : packages) {
            if (item <= 0) return usedPackageCount;
            item -= aPackage;
            usedPackageCount++;
        }
        if(item > 0) return -1;

        return usedPackageCount;
    }

    public static void main(String[] args) {
//        System.out.println(noOfPackages(10, new int[]{5,2}));
        System.out.println(noOfMinimumPackages(8,4, 2));
    }
}
