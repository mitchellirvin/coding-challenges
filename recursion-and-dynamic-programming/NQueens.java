// https://www.interviewbit.com/problems/nqueens/

import java.util.*;

public class NQueens {

    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();
        ArrayList<String> board = generateBoard(a);

        nQueens(0, board, a, solutions);

        return solutions;
    }

    public static void nQueens(int row, ArrayList<String> board, int queens, ArrayList<ArrayList<String>> solutions) {
        // base case, row == size of board
        if (row == queens) {
            solutions.add(new ArrayList<String>(board));
        }

        // iterate over row
            // if next position for queen does not threaten others
                // place queen, recur for next row
        for (int col = 0; col < queens; col++) {
            if (doesNotThreaten(board, row, col)) {
                board.set(row, getRowString(col, queens));
                nQueens(row + 1, new ArrayList<String>(board), queens, solutions);
            }
        }
    }

    // where row and col are position of newly placed queen
    // return true is newly placed queen threatens any others
    public static boolean doesNotThreaten(ArrayList<String> board, int row, int col) {
        for (int i = 0; i < row; i++) {
            int queenIndexInRow = getQueenIndexInRow(board.get(i));
            if (queenIndexInRow == col || Math.abs(queenIndexInRow - col) == Math.abs(i - row)) {
                return false;
            }
        }

        // System.out.println(board);
        // System.out.println("Placing at: " + row + ", " + col + " did not threaten.");
        return true;
    }

    public static int getQueenIndexInRow(String row) {
        for (int i = 0; i < row.length(); i++) {
            if (row.charAt(i) == 'Q') {
                return i;
            }
        }

        // error case, should never receive a row without a queen
        return -1;
    }

    public static String getRowString(int col, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (i == col) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }

        // System.out.println(sb.toString());
        return sb.toString();
    }

    public static ArrayList<String> generateBoard(int n) {
        ArrayList<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            board.add("");
        }

        return board;
    }

    public static void main(String[] args) {
        System.out.println("For 2 Queens: ");
        System.out.println(solveNQueens(2));

        System.out.println("For 4 Queens: ");
        System.out.println(solveNQueens(4));
    }
}
