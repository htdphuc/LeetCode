package org.example.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        //4. Longest Substring Without Repeating Characters
        int maxLength = lengthOfLongestSubstring_v2("abcabcbb");
        System.out.println(maxLength);

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
        int[] result2 = twoSum_HashMap(nums, target);
        for(int i: result2) {
            System.out.print(i);
        }
    }

    //4. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring_v2(String s) {
        int maxLength = 0;
        Map<Character, Integer> characters = new HashMap<>();
        for (int right=0, left=0; right<s.length(); right++) {
            char currentChar = s.charAt(right);
            if (characters.containsKey(currentChar) && characters.get(currentChar) >= left) {
                left = characters.get(currentChar) + 1;
            }
            maxLength = Math.max(maxLength, right -left + 1);
            characters.put(currentChar, right);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i=0; i<s.length(); i++) {
            StringBuilder currentSubString = new StringBuilder();
            for (int j=i; j<s.length(); j++) {
                if (currentSubString.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }
                currentSubString.append(s.charAt(j));
                /*if (currentSubString.length() > maxLength) {
                    maxLength = currentSubString.length();
                }*/
                maxLength = Math.max(maxLength, currentSubString.length());
            }
        }
        return maxLength;
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
    public static int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length - 1; i++) {
            int temp = 0;
            for (int j=1; j<nums.length; j++) {
                temp = nums[i] + nums[j];
                if (temp == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum_HashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (hashMap.get(target - num) != null) {
                return new int[] {hashMap.get(target - num), i};
            }
            hashMap.put(num, i);
        }
        return nums;
    }

    public static int[] twoSum_HashMap_v2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer complementIndex = hashMap.get(nums[i]);
            if (complementIndex != null) {
                return new int[] {i, complementIndex};
            }
            hashMap.put(target - nums[i], i);
        }
        return nums;
    }
}
