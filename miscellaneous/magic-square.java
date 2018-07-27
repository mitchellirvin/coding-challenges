import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
    To generate a magic square
    1. Ask the user for an odd number
    2. Create an n by n array.
    3. Follow these steps to create a magic square.
        a. Place a 1 in the middle of the first row.
        b. Subtract 1 from the row and add 1 to the column.
            i. If possible place the next number at that position.
            ii. If not possible, follow these steps.
                If in row -1, then change to last row
                If in last column change to first column
                If blocked, then drop down to next row (from original position)
                If in the upper right corner, then drop down to next row.
    4. Print the array
    */
    static int[][] possibleSquares = {
        {8, 1, 6, 3, 5, 7, 4, 9, 2},
        {6, 1, 8, 7, 5, 3, 2, 9, 4},
        {4, 9, 2, 3, 5, 7, 8, 1, 6},
        {2, 9, 4, 7, 5, 3, 6, 1, 8},
        {8, 3, 4, 1, 5, 9, 6, 7, 2},
        {4, 3, 8, 9, 5, 1, 2, 7, 6},
        {6, 7, 2, 1, 5, 9, 8, 3, 4},
        {2, 7, 6, 9, 5, 1, 4, 3, 8},
    };

    // assuming we already have the possible squares
    static int formingMagicSquare(int[][] s) {
        int cost = Integer.MAX_VALUE;
        for(int k = 0; k < possibleSquares.length; k++) {
            int currCost = 0;
            for(int i = 0; i < s.length; i++) {
                for(int j = 0; j < s[i].length; j++) {
                    currCost += Math.abs(s[i][j] - possibleSquares[k][(i * s.length) + j]);
                }
            }

            if(currCost < cost) cost = currCost;
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}
