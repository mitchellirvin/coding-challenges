// https://www.interviewbit.com/problems/palindrome-partitioning-ii/

import java.util.*;

public class PalindromePartitioning {
    public static int minPalindromePartition(String s) {
        // Get the length of the string
        int n = s.length();

        /*
            minCutsMatrix[i][j] = Minimum cuts to palindrome partition substring from i to j
            isPalindromeMatrix[i][j] = true if substring from i to j is palindrome
            Note that minCutsMatrix[i][j] is 0 if isPalindromeMatrix[i][j] is true
        */
        int[][] minCutsMatrix = new int[n][n];
        boolean[][] isPalindromeMatrix = new boolean[n][n];

        // Every substring of length 1 is a palindrome
        for (int i = 0; i < n; i++) {
            isPalindromeMatrix[i][i] = true;
            minCutsMatrix[i][i] = 0;
        }

        // Bottom up, consider each substring
        for (int subStringLength = 2; subStringLength <= n; subStringLength++) {
            // for each substring of length subStringLength
            for (int i = 0; i < n - subStringLength + 1; i++) {
                // end of substring
                int j = i + subStringLength - 1;

                // If subStringLength is 2, then we just need to compare two characters.
                // Else need to check the two bookend characters and value of isPalindromeMatrix[i + 1][j - 1]
                if (subStringLength == 2) {
                    isPalindromeMatrix[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    isPalindromeMatrix[i][j] = (s.charAt(i) == s.charAt(j))
                        && isPalindromeMatrix[i + 1][j - 1];
                }

                // if substring from i to j is a palindrome, 0 cuts required
                if (isPalindromeMatrix[i][j] == true) {
                    minCutsMatrix[i][j] = 0;
                } else {
                    // Try every cut possible, keeping the min
                    minCutsMatrix[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k <= j - 1; k++) {
                        minCutsMatrix[i][j] = Integer.min(minCutsMatrix[i][j],
                                minCutsMatrix[i][k] + minCutsMatrix[k + 1][j] + 1);
                    }
                }
            }
        }

        // Return the min cut value for complete string: substring from i to n - 1
        return minCutsMatrix[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println("Should yield 7: " + minPalindromePartition("racecarmitchpoopy"));
        System.out.println("Should yield 59: " + minPalindromePartition("dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg"));
        System.out.println("Should yield 1: " + minPalindromePartition("ababb"));
        System.out.println("Should yield 1: " + minPalindromePartition("bbab"));
    }
}
