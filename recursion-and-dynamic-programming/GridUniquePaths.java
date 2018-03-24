// https://www.interviewbit.com/problems/grid-unique-paths/

public class GridUniquePaths {
    public static int uniquePaths(int A, int B) {
        int[][] memo = new int[A][B];

        for (int i = 0; i < A; i++) {
            memo[i][0] = 1;
        }
        for (int i = 0; i < B; i++) {
            memo[0][i] = 1;
        }

        for (int i = 1; i < A; i++) {
            for (int j = 1; j < B; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }

        return memo[A - 1][B - 1];
    }

    // more basic recursive implementation
    public static int uniquePathsRecursive(int a, int b) {
	    if (a == 1 || b == 1) {
	        return 1;
	    } else {
	        return uniquePaths(a - 1, b) + uniquePaths(a, b - 1);
	    }
	}

    public static void main(String[] args) {
        System.out.println("4x3 grid should return 10 ways: " + uniquePaths(4, 3));
    }
}
