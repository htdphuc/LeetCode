package org.example.Easy;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        // 125. Valid Palindrome
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s1));

        // 121. Best Time to Buy and Sell Stock
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);

        //3. Merge two sorted lists
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode mergeNode = mergeTwoLists(n1, l1);
        printListNode(mergeNode);

        //2. Valid Parentheses
        String s = "([])[{}])";
        boolean isValid = isValid(s);
        System.out.println(isValid);

        //1. twoSum
        int[] nums = {3,2,4};
        int target = 6;
        int[] result1 = twoSum(nums, target);
        for(int i: result1) {
            System.out.print(i);
        }
        System.out.println();
        int[] result2 = twoSum_HashMap_v2(nums, target);
        for(int i: result2) {
            System.out.print(i);
        }
    }

    // 125. Valid Palindrome
    /* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
    * Alphanumeric characters include letters and numbers.
    * Given a string s, return true if it is a palindrome, or false otherwise.
    * Input: s = "A man, a plan, a canal: Panama"
    * Output: true
    * Explanation: "amanaplanacanalpanama" is a palindrome.*/
    public static boolean isPalindrome(String s) {
        StringBuilder currentString = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                currentString.append(s.charAt(i));
            }
        }
        String cleanedString = currentString.toString().toLowerCase();
        for (int i = 0; i < cleanedString.length() / 2; i++) {
            for (int j = cleanedString.length() - 1; j >= cleanedString.length() / 2; j--) {
                if (cleanedString.charAt(i) != cleanedString.charAt(j)) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    // 121. Best Time to Buy and Sell Stock
    /*You are given an array prices where prices[i] is the price of a given stock on the i-th day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    //3. Merge two sorted lists
    public static ListNode mergeTwoLists_Recursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            ListNode nextL1 = list1.next;
            ListNode nextElement = mergeTwoLists(nextL1, list2);
            list1.next = nextElement;
            return list1;
        } else {
            mergeTwoLists(list2, list1);
            return list2;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode currentNode = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }

        if (list1 != null) {
            currentNode.next = list1;
            list1 = list1.next;
        }
        if (list2 != null) {
            currentNode.next = list2;
            list2 = list2.next;
        }

        return dummyNode.next;
    }

    private static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    //2. Valid Parentheses
    public static boolean isValid(String s) {
        Stack myStack = new Stack();
        char c = s.charAt(0);
        if (c == ')' || c == '}' || c == ']') {
            return false;
        }
        for (int i=0; i<s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                myStack.push(s.charAt(i));
            } else {
                if (!myStack.isEmpty()) {
                    char top = (char) myStack.pop();
                    if (top != '(' && c == ')'
                            || top != '{' && c == '}'
                            || top != '[' && c == ']') {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    //1. twoSum: O(n^2)
    /* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    * You may assume that each input would have exactly one solution, and you may not use the same element twice.
    * You can return the answer in any order.
    * EX: Input: nums = [3,2,4], target = 6
          Output: [1,2] */
    public static int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length - 1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[] {i, j};
                }
            }
        }
        return nums;
    }

    public static int[] twoSum_HashMap_v2(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer complementIndex = complements.get(nums[i]);
            if (complementIndex != null) {
                return new int[] {i, complementIndex};
            }
            complements.put(target - nums[i], i);
        }
        return nums;
    }
}
