// https://www.interviewbit.com/problems/count-and-say/#

import java.util.*;

public class CountAndSay {

    public static String countAndSay(int A) {
        StringBuilder sb = new StringBuilder();
        String s = "1";

        for (int i = 1; i < A; i++) {
            int count = 0;
            char c = '0';

            for (int j = 0; j < s.length(); j++) {
                if (j == 0) {
                    c = s.charAt(j);
                    count = 1;
                } else if (s.charAt(j) == c) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    c = s.charAt(j);
                    count = 1;
                }
            }

            sb.append(count).append(c);
            s = sb.toString();
            sb.setLength(0);
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println("Input 4, expecting 1211: " + countAndSay(4));
        System.out.println("Input 6, expecting 312211: " + countAndSay(6));
    }
}
