// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestRegionInGrid {

    private static HashSet<String> visited = new HashSet<>();

    public static int getBiggestRegion(int[][] matrix) {
        visited.clear();
        int biggestRegion = 0;

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(!visited.contains(row + ":" + col) && matrix[row][col] == 1) {
                    // depth first search to fetch size of current region
                    biggestRegion = Math.max(biggestRegion, getSizeOfRegion(row, col, matrix));
                }
                visited.add(row + ":" + col);
            }
        }

        return biggestRegion;
    }

    private static int getSizeOfRegion(int row, int col, int[][] matrix) {
        // out of matrix bounds
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) return 0;
        if(matrix[row][col] == 0) return 0;

        int sizeOfRegion = 1;
        // marks cell as "visited" for base case
        matrix[row][col] = 0;
        sizeOfRegion += getSizeOfRegion(row - 1, col - 1, matrix);
        sizeOfRegion += getSizeOfRegion(row - 1, col, matrix);
        sizeOfRegion += getSizeOfRegion(row - 1, col + 1, matrix);
        sizeOfRegion += getSizeOfRegion(row, col - 1, matrix);
        sizeOfRegion += getSizeOfRegion(row, col + 1, matrix);
        sizeOfRegion += getSizeOfRegion(row + 1, col - 1, matrix);
        sizeOfRegion += getSizeOfRegion(row + 1, col, matrix);
        sizeOfRegion += getSizeOfRegion(row + 1, col + 1, matrix);

        return sizeOfRegion;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
