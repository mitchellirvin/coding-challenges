// https://www.hackerrank.com/challenges/permutation-equation/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PermutationEquation {

    static int[] permutationEquation(int[] p) {
        HashMap<Integer, Integer> xToValueMap = new HashMap<>();
        for (int i = 1; i <= p.length; i++) {
            xToValueMap.put(p[i - 1], i);
        }

        int[] y = new int[p.length];
        for (int i = 1; i <= p.length; i++) {
            y[i - 1] = xToValueMap.get(xToValueMap.get(i));
        }

        return y;
    }

    public static void main(String[] args) {
        /*
            Sample input:
            3
            2 3 1
            Should yield:
            2 3 1
        */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for (int p_i = 0; p_i < n; p_i++) {
            p[p_i] = in.nextInt();
        }
        int[] result = permutationEquation(p);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
