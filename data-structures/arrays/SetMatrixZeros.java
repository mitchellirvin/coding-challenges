// https://www.interviewbit.com/problems/set-matrix-zeros/#

import java.util.*;

public class SetMatrixZeros {
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    HashSet<Integer> cols = new HashSet<>();
	    HashSet<Integer> rows = new HashSet<>();

	    for (int row = 0; row < a.size(); row++) {
	        for (int col = 0; col < a.get(row).size(); col++) {
	            if (a.get(row).get(col) == 0) {
	                cols.add(col);
	                rows.add(row);
	            }
	        }
	    }

	    for (int row = 0; row < a.size(); row++) {
	        for (int col = 0; col < a.get(row).size(); col++) {
	            if (rows.contains(row) || cols.contains(col)) {
	                a.get(row).set(col, 0);
	            }
	        }
	    }
	}

    public static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            for (Integer val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        row1.add(0);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        row2.add(1);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(0);
        row3.add(1);
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        System.out.println("Before: ");
        printMatrix(matrix);
        setZeroes(matrix);
        System.out.println("After: ");
        printMatrix(matrix);
    }
}
