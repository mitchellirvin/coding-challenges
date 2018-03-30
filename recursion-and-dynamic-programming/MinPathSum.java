//

import java.util.*;

public class MinPathSum {
    public static int minPathSum(ArrayList<ArrayList<Integer>> A) {
        if (A.size() == 0 || A == null) {
            return 0;
        }

        int[][] costsGrid = new int[A.size()][A.get(0).size()];
        costsGrid[0][0] = A.get(0).get(0);

        // fill column 0 with costs for that path
        for (int row = 1; row < A.size(); row++) {
            costsGrid[row][0] = costsGrid[row - 1][0] + A.get(row).get(0);
        }

        // fill row 0 with costs for that path
        for (int col = 1; col < A.get(0).size(); col++) {
            costsGrid[0][col] = costsGrid[0][col - 1] + A.get(0).get(col);
        }

        // calculate min path cost for each square
        for (int row = 1; row < A.size(); row++) {
            for (int col = 1; col < A.get(0).size(); col++) {
                costsGrid[row][col] = Math.min(costsGrid[row - 1][col], costsGrid[row][col - 1])
                    + A.get(row).get(col);
            }
        }

        return costsGrid[A.size() - 1][A.get(0).size() - 1];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        // 1 3 2
        // 4 3 1
        // 5 6 1
        row.add(1);
        row.add(3);
        row.add(2);
        test.add(new ArrayList<Integer>(row));
        row.set(0, 4);
        row.set(1, 3);
        row.set(2, 1);
        test.add(new ArrayList<Integer>(row));
        row.set(0, 5);
        row.set(1, 6);
        row.set(2, 1);
        test.add(new ArrayList<Integer>(row));
        System.out.println("Min path sum should be 8");
        System.out.println("Min path sum returned is: " + minPathSum(test));
    }
}
