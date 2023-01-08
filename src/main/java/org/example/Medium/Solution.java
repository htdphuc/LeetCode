package org.example.Medium;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {


        //3. Longest Substring Without Repeating Characters
        /* Given a string s, find the length of the longest substring without repeating characters.
        * Input: s = "abcabcbb"
        * Output: 3
        * */
        int maxLength = lengthOfLongestSubstring_v3("abcabcd");
        System.out.println(maxLength);
    }

    //3. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring_v3(String s) {
        int maxLength = 0;
        for (int right=0, left=0; right<s.length(); right++) {
            int indexOfFirstAppearanceInSubString = s.indexOf(s.charAt(right), left);
            if (indexOfFirstAppearanceInSubString != right) {
                left = indexOfFirstAppearanceInSubString + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring_v2(String s) {
        int maxLength = 0;
        Map<Character, Integer> characters = new HashMap<>();
        for (int right=0, left=0; right<s.length(); right++) {
            char currenrCharacter = s.charAt(right);
            if (characters.containsKey(currenrCharacter) && characters.get(currenrCharacter) >= left) {
                left = characters.get(currenrCharacter) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            characters.put(currenrCharacter, right);
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
                maxLength = Math.max(currentSubString.length(), maxLength);
                /*if (currentSubString.length() > maxLength) {
                    maxLength = currentSubString.length();
                }*/
            }
        }
        return maxLength;
    }
}
