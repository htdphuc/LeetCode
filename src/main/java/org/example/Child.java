package org.example;

public class Child {
    static void func(int num) {
        num += 30;
    }
    public static void main(String[] args) {
        System.out.println(checkPrime(5));
    }

    public static boolean checkPrime(int v) {
        if (v <= 1) {
            // Numbers less than or equal to 1 are not prime
            return false;
        }
        // Check if the number is divisible by any number from 2 to sqrt(v)
        for (int i = 2; i <= Math.sqrt(v); i++) {
            if (v % i == 0) {
                // If the number is divisible by i, it is not prime
                return false;
            }
        }
        // If the number is not divisible by any number from 2 to sqrt(v), it is prime
        return true;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeNums = new int[nums1.length + nums2.length];
        int i=0;
        int j=0;
        int k=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergeNums[k] = nums1[i];
                i++;
            } else {
                mergeNums[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            mergeNums[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            mergeNums[k] = nums1[j];
            j++;
            k++;
        }

        if (mergeNums.length % 2 == 1) {
            return mergeNums[mergeNums.length / 2];
        }
        return ((double)mergeNums[mergeNums.length / 2] + (double)mergeNums[(mergeNums.length / 2) - 1]) / 2;
    }

}

