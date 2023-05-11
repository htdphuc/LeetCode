package org.example.BestPractices.EasyLeetCode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        boolean isValid = isValid("(){}}");
        System.out.println(isValid);
    }
    public static boolean isValid(String s) {
        Stack<Character> opens = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                opens.push(currentChar);
            } else {
                if (!opens.isEmpty()) {
                    char topChar = opens.pop();
                    if ((currentChar == ')' && topChar != '(')
                        || (currentChar == '}' && topChar != '{')
                        || (currentChar == ']' && topChar != '[')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return opens.isEmpty();
    }
}
