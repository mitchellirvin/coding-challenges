// https://www.interviewbit.com/problems/nqueens/

import java.util.*;

public class NQueens {

    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();
        ArrayList<String> board = generateBoard(a);

        nQueensHelper(0, board, a, solutions);

        return solutions;
    }

    public static void nQueensHelper(int row, ArrayList<String> board, int numberOfQueens, ArrayList<ArrayList<String>> solutions) {
        // base case, row == size of board
        if (row == numberOfQueens) {
            solutions.add(new ArrayList<String>(board));
            return;
        }

        // iterate over row
            // if next position for queen does not threaten others
                // place queen, recur for next row
        for (int col = 0; col < numberOfQueens; col++) {
            if (doesNotThreaten(board, row, col)) {
                placeQueen(board, row, col, numberOfQueens);
                nQueensHelper(row + 1, new ArrayList<String>(board), numberOfQueens, solutions);
            }
        }
    }

    // where row and col are position of newly placed queen
    // return true if newly placed queen does not threaten any other queens
    public static boolean doesNotThreaten(ArrayList<String> board, int row, int col) {
        for (int i = 0; i < row; i++) {
            int queenIndexInRow = getQueenIndexInRow(board.get(i));
            if (queenIndexInRow == col || Math.abs(queenIndexInRow - col) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }

    public static void placeQueen(ArrayList<String> board, int rowIndex, int col, int numberOfQueens) {
        String rowContents = getRowContents(col, numberOfQueens);
        // wipes any previous queen placements on current row
        board.set(rowIndex, rowContents);
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

    public static String getRowContents(int col, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (i == col) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }

        return sb.toString();
    }

    public static ArrayList<String> generateBoard(int n) {
        ArrayList<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            board.add("");
        }

        return board;
    }

    public static <T> void printBoards(ArrayList<ArrayList<T>> boards) {
        if (boards.size() == 0) {
            System.out.println("No solutions.");
        }

        for (int i = 0; i < boards.size(); i++) {
            System.out.println("\nSolved Board: " + (i + 1));
            ArrayList<T> board = boards.get(i);
            for (T row : board) {
                System.out.println(row);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("For 2 Queens: ");
        printBoards(solveNQueens(2));

        System.out.print("For 4 Queens: ");
        printBoards(solveNQueens(4));

        System.out.print("For 5 Queens: ");
        printBoards(solveNQueens(5));
    }
}
