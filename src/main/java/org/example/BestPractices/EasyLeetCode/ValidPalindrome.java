package org.example.BestPractices.EasyLeetCode;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder currentString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                currentString.append(s.charAt(i));
            }
        }

        String s1 = currentString.toString().toLowerCase();
        for (int i = 0; i < s1.length() / 2; i++) {
            for (int j = s1.length() - 1; j >= s1.length() / 2; j--) {
                if (s1.charAt(i) != s1.charAt(j)) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        String s1 = "";
        System.out.println(isPalindrome(s1));

        String s2 = "race a car";
        System.out.println(isPalindrome(s2));
    }
}
