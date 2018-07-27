import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class spiralMatrix {
    static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int length = (2 * A) - 1;
        int[][] spiralMatrix = new int[length][length];
        int upperRow = 0, lowerRow = length - 1, leftCol = 0, rightCol = length - 1;

        while(A > 0) {
            for(int i = leftCol; i < rightCol; i++) {
                spiralMatrix[upperRow][i] = A;
            }
            for(int i = upperRow; i <= lowerRow; i++) {
                spiralMatrix[i][rightCol] = A;
            }
            for(int i = rightCol; i > leftCol; i--) {
                spiralMatrix[lowerRow][i] = A;
            }
            for(int i = lowerRow; i >= upperRow; i--) {
                spiralMatrix[i][leftCol] = A;
            }

            A--;
            upperRow++;
            lowerRow--;
            leftCol++;
            rightCol--;
        }

        ArrayList<ArrayList<Integer>> prettySquare = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j < length; j++) {
                System.out.print(spiralMatrix[i][j] + " ");
                row.add(spiralMatrix[i][j]);
            }
            System.out.print("\n");
            prettySquare.add(row);
        }

        return prettySquare;
    }

    public static void main(String[] args) {
      prettyPrint(3);
    }
}
