// https://www.interviewbit.com/problems/zigzag-string/#

import java.util.*;

public class ZigZag {
    public static String convert(String A, int B) {
        if (B <= 1) {
            return A;
        }

        StringBuilder[] zigzag = new StringBuilder[B];
        for (int i = 0; i < B; i++) {
            zigzag[i] = new StringBuilder();
        }

        int i = 0;
        while (i < A.length()) {
            for(int row = 0; row < B && i < A.length(); row++, i++){
                zigzag[row].append(A.charAt(i));
            }
            for(int row = B - 2; row > 0 && i < A.length(); row--, i++){
                zigzag[row].append(A.charAt(i));
            }
        }

        StringBuilder output = new StringBuilder();
        for (StringBuilder level : zigzag) {
            output.append(level);
        }

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println("ABCDE, 3: " + convert("ABCDE", 3));
        System.out.println("PAYPALISHIRING, 3: " + convert("PAYPALISHIRING", 3));
    }
}
