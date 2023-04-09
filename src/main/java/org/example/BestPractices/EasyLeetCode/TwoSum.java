package org.example.BestPractices.EasyLeetCode;

import java.util.HashMap;

public class TwoSum {
    /*1. Two sum
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * Example: Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/

    // Complexity O(N**2)
    public static int[] solution(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length-1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] solution_better(int[] nums, int target) {
        HashMap<Integer, Integer> elememts = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer currentIndex = elememts.get(nums[i]);
            if (currentIndex != null) {
                return new int[] {currentIndex, i};
            }
            elememts.put(target - nums[i], i);
        }
        return null;
    }
}
