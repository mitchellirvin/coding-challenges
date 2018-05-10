// https://www.interviewbit.com/problems/repeating-subsequence/

import java.util.*;

public class RepeatingSubsequence {
    public static int anytwo(String A) {
        if (A.length() < 2) {
            return 0;
        }

        HashMap<Character, Integer> charToCountMap = new HashMap<>();

        for (char c : A.toCharArray()) {
            if (!charToCountMap.containsKey(c)) {
                charToCountMap.put(c, 1);
            } else {
                charToCountMap.put(c, charToCountMap.get(c) + 1);
                if (charToCountMap.get(c) > 2) {
                    return 1;
                }
            }
        }

        String removedUniques = "";

        for (char c : A.toCharArray()) {
            if (charToCountMap.get(c) > 1) {
                removedUniques += c;
            }
        }

        if (isPalindrome(removedUniques)) {
            int mid = removedUniques.length() / 2;
            if ((removedUniques.length() % 2 == 1) &&
                removedUniques.charAt(mid) == removedUniques.charAt(mid - 1)) {
                    return 1;
                }
            return 0;
        }

        return 1;
    }

    public static boolean isPalindrome(String A) {
        for(int i = 0; i < A.length() / 2; i++){
            if(A.charAt(i) != A.charAt(A.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("For string abba: " + anytwo("abba"));
        System.out.println("For string abba: " + anytwo("abab"));
    }
}
