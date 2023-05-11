package org.example.BestPractices.EasyLeetCode;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(numbers, 1));

        Arrays.binarySearch(numbers, 1);
    }

    public static int binarySearch(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int middlePosition = (low + high) / 2;
            int middleNumber = numbers[middlePosition];
            if (target == middleNumber) {
                return middlePosition;
            }
            if (target < middleNumber) {
                high = middlePosition - 1;
            } else {
                low = middlePosition + 1;
            }
        }
        return -1;
    }
}
