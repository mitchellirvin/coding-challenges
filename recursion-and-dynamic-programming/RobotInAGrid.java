// taken from Cracking the Coding Interview, 6th Edition, Page 135
// robot must escape to the finish, but can only move right and down
// and cannot step on the "off limits" tiles

import java.util.*;

public class RobotInAGrid {
    public static HashSet<String> visited;
    public static ArrayList<ArrayList<String>> paths;

    public static void getToTheFinish(int[][] grid) {
        visited = new HashSet<>();
        paths = new ArrayList<>();
        getToTheFinish(grid, 0, 0, 0, new ArrayList<String>());
    }

    public static void getToTheFinish(int[][] grid, int currRow, int currCol, int recur, ArrayList<String> path) {
        printTabs(recur);
        System.out.println("At position: " + currRow + ", " + currCol + " | ");

        // base case: we're at the finish or we're stuck (can't move down/right)
        if (grid[currRow][currCol] == 1) {
            printTabs(recur);
            System.out.println("Our robot made it out!");
            path.add(currRow + ":" + currCol);
            if(!paths.contains(path)) {
                paths.add(new ArrayList<String>(path));
            }
        }

        String point = currRow + ":" + currCol;
        // dynamic programming, don't visit the same cell twice
        // remove this snippet to find all unique paths
        if(visited.contains(point)) {
            return;
        }
        visited.add(point);

        // step down if safe/in bounds
        if (currRow + 1 < grid.length) {
            // avoid the "landmines"
            if (grid[currRow + 1][currCol] == -1) {
                printTabs(recur);
                System.out.println("Landmine below!");
            } else {
                path.add(point);
                getToTheFinish(grid, currRow + 1, currCol, recur + 1, new ArrayList<String>(path));
                path.remove(point);
            }
        }

        // step right if safe/in bounds
        if (currCol + 1 < grid[currRow].length) {
            // avoid the "landmines"
            if (grid[currRow][currCol + 1] == -1) {
                printTabs(recur);
                System.out.println("Landmine to the right!");
            } else {
                path.add(point);
                getToTheFinish(grid, currRow, currCol + 1, recur + 1, new ArrayList<String>(path));
                path.remove(point);
            }
        }
    }

    public static void printTabs(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }

    public static void main(String[] args) {
        // our grid will be represented by a 2d array
        // cells with '9' are off limits
        int rows = 4;
        int cols = 6;
        int[][] grid = new int[rows][cols];

        // set some "off limits" cells
        grid[0][2] = -1;
        grid[2][1] = -1;
        grid[1][4] = -1;
        grid[3][3] = -1;

        // set finish line
        grid[rows - 1][cols - 1] = 1;

        // grid should look like:
        /*
            0   0   -1   0
            0   0   0   0
            0   -1   0   1
        */
        // where top left is start, bottom right is finish, and -1 is off limits

        getToTheFinish(grid);

        for (ArrayList<String> path : paths) {
            System.out.print("Path: ");
            for (String s : path) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
