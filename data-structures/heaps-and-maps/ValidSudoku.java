// https://www.interviewbit.com/problems/valid-sudoku/

import java.util.*;

public class ValidSudoku {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int isValidSudoku(final List<String> A) {
        if (A.size() != 9) {
            return 0;
        }

        int[][] board = new int[A.size()][A.size()];

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).length(); j++) {
                if (A.get(i).charAt(j) != '.') {
                    board[i][j] = (int) A.get(i).charAt(j);
                }
            }
        }

        return (validateRows(board) &&
            validateCols(board) &&
            validateSquares(board)) ? 1 : 0;
    }

    public static boolean validateRows(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Integer> currRow = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (!currRow.contains(board[i][j]) && board[i][j] != 0) {
                    currRow.add(board[i][j]);
                } else if (currRow.contains(board[i][j]) && board[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean validateCols(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Integer> currCol = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (!currCol.contains(board[j][i]) && board[j][i] != 0) {
                    currCol.add(board[j][i]);
                } else if (currCol.contains(board[j][i]) && board[j][i] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean validateSquares(int[][] board) {
        for (int outerRow = 0; outerRow < 9; outerRow += 3) {
            for (int outerCol = 0; outerCol < 9; outerCol += 3) {
                HashSet<Integer> currSquare = new HashSet<>();
                for (int row = outerRow; row < outerRow + 3; row++) {
                    for (int col = outerCol; col < outerCol + 3; col++) {
                        if (!currSquare.contains(board[row][col]) && board[row][col] != 0) {
                            currSquare.add(board[row][col]);
                        } else if (currSquare.contains(board[row][col]) && board[row][col] != 0) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> board = new ArrayList<>();
        board.add("53..7....");
        board.add("6..195...");
        board.add(".98....6.");
        board.add("8...6...3");
        board.add("4..8.3..1");
        board.add("7...2...6");
        board.add(".6....28.");
        board.add("...419..5");
        board.add("....8..79");

        System.out.println("Testing board: ");
        for (String s : board) {
            System.out.println(s);
        }
        System.out.println("Is valid, should yield 1: " + isValidSudoku(board));
    }
}
