import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static void fillBoard(int rowCount, int colCount, int topLeftCellsCut, int botRightCellsCut) {
        int numOfCellsToFill = (rowCount * colCount) - (topLeftCellsCut + botRightCellsCut);

        if(isOdd(numOfCellsToFill)) {
            System.out.println("NO");
            return;
        } else if((rowCount == colCount) && isOdd(topLeftCellsCut) && isOdd(botRightCellsCut)) {
            System.out.println("NO");
            return;
        } else if(isOdd(topLeftCellsCut) && isOdd(botRightCellsCut) && isEven(rowCount) && isEven(colCount)) {
            System.out.println("NO");
            return;
        }

        // place -1 at positions where board is "cut"
        int[][] board = new int[rowCount][colCount];
        for(int i = 0; i < topLeftCellsCut; i++)
            board[0][i] = -1;
        for(int i = 0; i < botRightCellsCut; i++)
            board[rowCount - 1][(colCount - 1) - i] = -1;

        // there is a solution, print yes and how many dominoes to place
        System.out.println("YES");
        System.out.println(numOfCellsToFill / 2);

        int dominoNumber = 1;
        // iterate over each row, placing dominoes where available
        for(int row = 0; row < rowCount; row++) {
            // count number of empty cells in the current row
            int numOfEmptyCellsInRow = 0;
            for(int col = 0; col < colCount; col++) {
                if(board[row][col] == 0) numOfEmptyCellsInRow++;
            }

            // handle odd number of empty cells (place vertical domino to far left or far right)
            if(isOdd(numOfEmptyCellsInRow)) {
                if(row == 0 && board[row + 1][colCount - 1] != -1) {
                    board[row][colCount - 1] = dominoNumber;
                    board[row + 1][colCount - 1] = dominoNumber;
                    System.out.println((row + 1) + " " + (colCount) + " " + (row + 2) + " " + colCount);
                } else if(row == 0) {
                    board[row][topLeftCellsCut] = dominoNumber;
                    board[row + 1][topLeftCellsCut] = dominoNumber;
                    System.out.println((row + 1) + " " + (topLeftCellsCut) + " " + (row + 2) + " " + topLeftCellsCut);
                } else {
                    if(board[row][0] > 0) {
                        board[row][colCount - 1] = dominoNumber;
                        board[row + 1][colCount - 1] = dominoNumber;
                        System.out.println((row + 1) + " " + (colCount) + " " + (row + 2) + " " + colCount);
                    } else {
                        board[row][0] = dominoNumber;
                        board[row + 1][0] = dominoNumber;
                        System.out.println((row + 1) + " 1 " + (row + 2) + " 1");
                    }
                }
                dominoNumber++;
            }

            // handle even num of empty cells (place horizontal dominos until end of row reached)
            for(int col = 0; col < colCount; col++) {
                if(board[row][col] == 0) {
                    board[row][col] = dominoNumber;
                    board[row][col + 1] = dominoNumber;
                    System.out.println((row + 1) + " " + (col + 1) + " " + (row + 1) + " " + (col + 2));
                    col++;
                    dominoNumber++;
                }
            }
        }

        // print board after dominos have been placed
        // printDominoBoard(board);
    }

    static boolean isOdd(int n) {
        return (n % 2) == 1;
    }

    static boolean isEven(int n) {
        return (n % 2) == 0;
    }

    static void printDominoBoard(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nmxy = scan.nextLine().split(" ");

        int n = Integer.parseInt(nmxy[0].trim());

        int m = Integer.parseInt(nmxy[1].trim());

        int x = Integer.parseInt(nmxy[2].trim());

        int y = Integer.parseInt(nmxy[3].trim());

        fillBoard(n, m, x, y);
    }
}
