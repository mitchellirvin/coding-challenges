//

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class SearchMatrix {

    public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        if (a.size() == 0) {
            return 0;
        }

        int lo = 0;
        int hi = a.size() - 1;
        int mid = -1;

        // binary search on first column
        while (lo <= hi) {
            mid = (hi + lo) / 2;

            if (a.get(mid).get(0) == b) {
                return 1;
            } else if (a.get(mid).get(0) < b) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        lo = 0;
        hi = a.get(mid).size() - 1;
        int row = mid;
        // ensure we're on the lower bound of the previous search
        if (a.get(mid).get(0) > b && mid != 0) {
            row--;
        }

        // binary search on lower bound row if neither value matches exactly
        while (lo <= hi) {
            mid = (hi + lo) / 2;

            if (a.get(row).get(mid) == b) {
                return 1;
            } else if (a.get(row).get(mid) < b) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return 0;
    }

    public static ArrayList<ArrayList<Integer>> generateTestMatrix() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<Integer>(asList(1, 3, 5, 7));
        ArrayList<Integer> row2 = new ArrayList<Integer>(asList(10, 11, 16, 20));
        ArrayList<Integer> row3 = new ArrayList<Integer>(asList(23, 30, 34, 50));
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        return matrix;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = generateTestMatrix();
        System.out.println("Matrix to search: ");
        System.out.println(matrix);

        System.out.println("Contains 12: " + searchMatrix(matrix, 12));
        System.out.println("Contains 50: " + searchMatrix(matrix, 50));
        System.out.println("Contains 1: " + searchMatrix(matrix, 1));
        System.out.println("Contains 5: " + searchMatrix(matrix, 5));
        System.out.println("Contains 30: " + searchMatrix(matrix, 30));
        System.out.println("Contains 6: " + searchMatrix(matrix, 6));
    }

}
