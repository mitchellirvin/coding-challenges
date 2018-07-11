/**
Given an integer k and a string s, find the length of the longest substring that
contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct
characters is "bcb".
*/

import java.util.HashMap;

public class LongestSubstringWithKDistinctChars {

    public static String longestSubstring(String s, int distinctChars) {
        HashMap<Character, Integer> charsInWindow = new HashMap<>();
        String longest = "";
        int front = 0;

        for (int i = 0; i < s.length(); i++) {
            charsInWindow.put(s.charAt(i), charsInWindow.getOrDefault(s.charAt(i), 0) + 1);

            while (charsInWindow.size() > distinctChars) {
                charsInWindow.put(s.charAt(front), charsInWindow.get(s.charAt(front)) - 1);
                if (charsInWindow.get(s.charAt(front)) == 0) {
                    charsInWindow.remove(s.charAt(front));
                }
                front++;
            }

            if ((i + 1) - front > longest.length()) {
                longest = s.substring(front, i + 1);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println("Given abcba and 2: " + longestSubstring("abcba", 2));
        System.out.println("Given abcba and 3: " + longestSubstring("abcba", 3));
        System.out.println("Given bcbbcaadd and 2: " + longestSubstring("bcbbcaadd", 2));
        System.out.println("Given a and 4: " + longestSubstring("a", 4));
    }

}
