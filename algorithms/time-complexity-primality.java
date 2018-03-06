import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // O(sqrt(n))
    static String isPrime(int n) {
        if(n == 1) return "Not prime";

        for(int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n % i == 0) return "Not prime";
        }
        return "Prime";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++) {
            int n = in.nextInt();
            System.out.println(isPrime(n));
        }
    }
}
