// https://www.interviewbit.com/problems/min-sum-path-in-triangle/

import java.util.*;

public class MinSumPathInTriangle {
    public static int minimumTotalBottomUp(ArrayList<ArrayList<Integer>> a) {
        int size = a.size();
        int[] dp = new int[size];

        for (int i = 0; i < a.get(size - 1).size(); i++) {
            dp[i] = a.get(size - 1).get(i);
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < a.get(i).size(); j++) {
                dp[j] = a.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    // top down
	public static int minimumTotalTopDown(ArrayList<ArrayList<Integer>> a) {
	    ArrayList<ArrayList<Integer>> triangleSum = new ArrayList<>();

	    for (int i = 0; i < a.size(); i++) {
	        ArrayList<Integer> sumRow = new ArrayList<>();
	        for (int j = 0; j < a.get(i).size(); j++) {
	            int minToCurrentPosition = a.get(i).get(j);
	            if (i == 0) {
	                sumRow.add(minToCurrentPosition);
	            } else if (j == 0) {
	                minToCurrentPosition += triangleSum.get(i - 1).get(j);
	                sumRow.add(minToCurrentPosition);
	            } else if (j == a.get(i).size() - 1) {
	                minToCurrentPosition += triangleSum.get(i - 1).get(j - 1);
	                sumRow.add(minToCurrentPosition);
	            } else {
	                minToCurrentPosition +=
	                    Math.min(triangleSum.get(i - 1).get(j), triangleSum.get(i - 1).get(j - 1));
	                sumRow.add(minToCurrentPosition);
	            }
	        }
	        triangleSum.add(new ArrayList<Integer>(sumRow));
	        sumRow.clear();
	    }

        // printGrid(triangleSum);

	    return triangleSum.get(triangleSum.size() - 1)
	        .stream()
	        .mapToInt(Integer::valueOf)
	        .min()
	        .getAsInt();
	}

    public static void printGrid(ArrayList<ArrayList<Integer>> grid) {
        for (ArrayList<Integer> row : grid) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(2);
        triangle.add(new ArrayList<Integer>(row));
        row.clear();
        row.add(3);
        row.add(4);
        triangle.add(new ArrayList<Integer>(row));
        row.clear();
        row.add(6);
        row.add(5);
        row.add(1);
        triangle.add(new ArrayList<Integer>(row));
        row.clear();
        row.add(2);
        row.add(7);
        row.add(0);
        row.add(3);
        triangle.add(new ArrayList<Integer>(row));

        printGrid(triangle);
        System.out.println("min path: " + minimumTotalBottomUp(triangle));
    }
}
