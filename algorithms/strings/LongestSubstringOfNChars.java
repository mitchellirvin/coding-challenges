// https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/

import java.util.*;

public class LongestSubstringOfNChars {
    public static String longestSubstring(String s, int n) {

        // use structure(s) to represent "window"
        HashMap<Character, Integer> windowMap = new HashMap<>();
        ArrayList<Character> windowList = new ArrayList<>();

        // for each char in s
            // if char not in window
                // if distinct elements >= n
                    // remove from left until distinct chars < n
            // add char to window
            // if length of window > current max, update max

        return "";
    }

    public static void main(String[] args) {
        System.out.println("aabbbcccaaacccbbaaa, 3: " + longestSubstring("aabbbcccaaacccbbaaa", 3));
    }
}
