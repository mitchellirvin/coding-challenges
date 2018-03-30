// https://www.cdn.geeksforgeeks.org/program-nth-catalan-number/
// https://www.interviewbit.com/problems/unique-binary-search-trees-ii/

import java.util.*;

public class CatalanNumber {
    // Cn = sum from 1 to n of (C(i) * C(n - i))
    public static int getCatalanNumberRecursive(int n) {
        if (n <= 1) {
            return 1;
        }

        int catalanNumber = 0;
        for (int i = 1; i <= n; i++) {
            catalanNumber += getCatalanNumberRecursive(i - 1) * getCatalanNumberRecursive(n - i);
        }

        return catalanNumber;
    }

    public static int getCatalanNumberDp(int n) {
        int[] catalanNumbers = new int[n + 1];
        catalanNumbers[0] = 1;
        catalanNumbers[1] = 1;

        int sum = 2;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                catalanNumbers[i] += (catalanNumbers[j - 1] * catalanNumbers[i - j]);
            }
        }

        return catalanNumbers[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number... type E to exit");
        while (scanner.hasNextInt()) {
            int next = scanner.nextInt();
            System.out.println("Catalan of " + next + ": " + getCatalanNumberDp(next));
            System.out.println("Please enter a number... type E to exit");
        }
    }
}
