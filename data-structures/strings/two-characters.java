// https://www.hackerrank.com/challenges/two-characters/problem
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int twoCharacters(String s) {
        Set<Character> charSet = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
        }
        Character[] charArr = charSet.toArray(new Character[charSet.size()]);

        int longestVerifiedString = 0;
        for(int j = 0; j < charArr.length - 1; j++) {
            for(int k = j + 1; k < charArr.length; k++) {
                // [^ab] - matches everything that is not a or b
                String pattern = "([^" + charArr[j] + charArr[k] + "])";
                // returns the string with just the two characters
                String twoCharString = s.replaceAll(pattern, "");
                if(isAlternatingChars(twoCharString)) {
                    longestVerifiedString = Math.max(longestVerifiedString, twoCharString.length());
                }
            }
        }

        return longestVerifiedString;
    }

    static boolean isAlternatingChars(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int result = twoCharacters(s);
        System.out.println(result);
        in.close();
    }
}
