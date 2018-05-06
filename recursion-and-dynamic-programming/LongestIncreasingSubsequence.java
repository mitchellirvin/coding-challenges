/*
https://www.interviewbit.com/problems/longest-increasing-subsequence/

L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
L(i) = 1, if no such j exists.
To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
*/

import java.util.*;

public class LongestIncreasingSubsequence {
    public static int lis(final List<Integer> A) {
        int[] lis = new int[A.size()];
        Arrays.fill(lis, 1);

        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int max = 1;
        for (int n : lis) {
            max = Math.max(max, n);
        }

        return max;
    }

    public static void printSeq(ArrayList<Integer> chosen) {
        for (int n : chosen) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(1);
        test.add(6);
        test.add(3);
        test.add(4);
        test.add(2);
        test.add(9);
        printSeq(test);
        System.out.println(lis(test));
    }
}
