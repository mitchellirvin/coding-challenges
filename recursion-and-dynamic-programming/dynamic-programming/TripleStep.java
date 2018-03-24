// https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem

public class TripleStep {
    // dynamic programming, top down solution
    public static int waysToClimbTopDown(int n) {
        return waysToClimbTopDownHelper(n, new int[n + 1]);
    }

    public static int waysToClimbTopDownHelper(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        memo[n] = waysToClimbTopDownHelper(n - 1, memo)
                + waysToClimbTopDownHelper(n - 2, memo)
                + waysToClimbTopDownHelper(n - 3, memo);

        return memo[n];
    }

    // dynamic programming, bottom up solution
    public static int waysToClimbBottomUp(int n) {
        int[] waysToClimbEachStep = new int[n];
        waysToClimbEachStep[0] = 1;
        waysToClimbEachStep[1] = 2;
        waysToClimbEachStep[2] = 4;

        for (int i = 3; i < n; i++) {
            waysToClimbEachStep[i] =
                waysToClimbEachStep[i - 1]
                + waysToClimbEachStep[i - 2]
                + waysToClimbEachStep[i - 3];
        }

        return waysToClimbEachStep[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("ways to climb 7 stairs (bottom up): " + waysToClimbBottomUp(7) + " ways.");
        System.out.println("ways to climb 7 stairs (top down): " + waysToClimbTopDown(7) + " ways.");
    }
}
