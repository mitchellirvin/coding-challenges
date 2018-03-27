// https://www.interviewbit.com/problems/unique-paths-in-a-grid/

import java.util.*;

public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        if (A == null) {
            return 0;
        }

        return uniquePathsWithObstacles(A, 0, 0);
    }

    public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A, int row, int col) {
        // System.out.print(row + ", " + col + " | ");

        // base case
        if(A.get(row).get(col) == 1) {
            return 0;
        } else if (row == A.size() - 1 && col == A.get(0).size() - 1) {
            return 1;
        }

        int paths = 0;
        // try going down
        if ((row < A.size() - 1) && (A.get(row + 1).get(col) != 1)) {
            paths += uniquePathsWithObstacles(A, row + 1, col);
        }
        // try going right
        if ((col < A.get(0).size() - 1) && (A.get(row).get(col + 1) != 1)) {
            paths += uniquePathsWithObstacles(A, row, col + 1);
        }

        return paths;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        B.add(0);
        B.add(0);
        B.add(0);
        A.add(new ArrayList<>(B));
        B.set(1, 1);
        A.add(new ArrayList<>(B));
        B.set(1, 0);
        A.add(new ArrayList<>(B));
        System.out.println("Should result in 2 ways: ");
        System.out.println("    " + uniquePathsWithObstacles(A));
    }
}
