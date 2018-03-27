/*
Given a string, find the longest substring that contains only two unique characters.
For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb"
*/

import java.util.*;

public class LongestSubstringOfNChars {
    public static String longestSubstring(String s, int n) {

        // use structure(s) to represent "window"
        HashMap<Character, Integer> window = new HashMap<>();

        int frontOfWindow = 0;
        int distinctChars = 0;
        String curr = "";
        String max = "";

        for (int i = 0; i < s.length(); i++) {
            System.out.println("curr: " + curr + ", " + distinctChars);
            curr += s.charAt(i);
            if (window.containsKey(s.charAt(i))) {
                window.put(s.charAt(i), window.get(s.charAt(i)) + 1);
            } else {
                if (distinctChars == n) {
                    while (distinctChars == n) {
                        curr = curr.substring(1);   // remove char from front of string
                        if(removeCharFromWindow(window, s.charAt(frontOfWindow)) == 0) {
                            distinctChars--;
                            window.remove(s.charAt(frontOfWindow));
                        }
                        frontOfWindow++;
                    }
                } else {
                    window.put(s.charAt(i), 1);
                    distinctChars++;
                }
            }
            if (curr.length() > max.length()) {
                max = curr;
            }
        }

        return max;
    }

    public static int removeCharFromWindow(HashMap<Character, Integer> window, char c) {
        if(!window.containsKey(c)) {
            return -1;
        }

        window.put(c, window.get(c) - 1);

        return window.get(c);
    }

    public static void main(String[] args) {
        System.out.println("final answer: ");
        System.out.println("abcbbbbcccbdddadacb, 2: " + longestSubstring("abcbbbbcccbdddadacb", 2));
    }
}
