import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


// problem: https://www.hackerrank.com/contests/101hack53/challenges/cut-board
public class Solution {

    static void fillBoard(int rowCount, int colCount, int topLeftCellsCut, int botRightCellsCut) {
        if(((rowCount * colCount) - (topLeftCellsCut + botRightCellsCut)) % 2 == 1) {
            System.out.println("NO");
            return;
        } else if((rowCount == colCount)
                && (topLeftCellsCut % 2 == 1)
                && (botRightCellsCut % 2 == 1)) {
            System.out.println("NO");
            return;
        } else if((topLeftCellsCut % 2 == 1) && (botRightCellsCut % 2 == 1)
                 && (rowCount % 2 == 0) && (colCount % 2 == 0)) {
            System.out.println("NO");
            return;
        }

        int[][] board = new int[rowCount][colCount];
        for(int i = 0; i < topLeftCellsCut; i++)
            board[0][i] = -1;
        for(int i = 0; i < botRightCellsCut; i++)
            board[rowCount - 1][(colCount - 1) - i] = -1;

        System.out.println("YES");
        System.out.println(((rowCount * colCount) - (topLeftCellsCut + botRightCellsCut)) / 2);
        int dominoNumber = 1;
        for(int row = 0; row < rowCount; row++) {
            int numOfEmptyCellsInRow = 0;
            for(int col = 0; col < colCount; col++) {
                if(board[row][col] == 0) numOfEmptyCellsInRow++;
            }

            // handle odd number of empty cells (place vertical domino)
            if(numOfEmptyCellsInRow % 2 == 1) {
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

            // place horizontal dominos
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


        // for(int i = 0; i < rowCount; i++) {
        //     for(int j = 0; j < colCount; j++) {
        //         System.out.print(board[i][j] + "\t");
        //     }
        //     System.out.print("\n");
        // }
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
