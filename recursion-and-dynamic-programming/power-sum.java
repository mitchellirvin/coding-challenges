// https://www.hackerrank.com/challenges/the-power-sum/problem
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int powerSum(int value, int exponent) {
        return powerSum(value, exponent, 1);
    }

    static int powerSum(int value, int exponent, int base) {
        int currentPower = (int) Math.pow(base, exponent);

        // exceeded the num we're trying to match
        if(currentPower > value) return 0;
        // the exponential product is equal to the remaining value
        else if(currentPower == value) return 1;

        // first recursive call is trying to see if the current base was a part of the solution
        // second recursive call is exploring the path that the current base was not a part of the solution
        return powerSum(value, exponent, base + 1) + powerSum(value - currentPower, exponent, base + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        int result = powerSum(X, N);
        System.out.println(result);
        in.close();
    }
}
