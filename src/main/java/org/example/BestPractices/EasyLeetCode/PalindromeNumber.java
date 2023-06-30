package org.example.BestPractices.EasyLeetCode;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            for (int j = s.length() - 1; j >= s.length() / 2; j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
