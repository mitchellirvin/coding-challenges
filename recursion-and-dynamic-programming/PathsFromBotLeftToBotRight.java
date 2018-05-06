/*
Given the length and width of a matrix, output the number of paths from bottom
left to bottom right.

You can only move these ways, starting from bottom left:
up one, right one
right one
down one, right one
*/

public class PathsFromBotLeftToBotRight {
    public static int pathsFromBotLeftToBotRight(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        // one way from our starting square
        matrix[0][0] = 1;

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                matrix[row][col] = Math.max(matrix[row][col], sumThreeRowsFromPreviousColumn(matrix, row, col));
            }
        }

        System.out.println("DP Paths Matrix: ");
        printMatrix(matrix);

        return matrix[0][cols - 1];
    }

    public static int sumThreeRowsFromPreviousColumn(int[][] matrix, int row, int col) {
        if (col == 0) {
            return 0;
        }

        int sum = 0;
        sum += matrix[row][col - 1];
        if (row > 0) {
            sum += matrix[row - 1][col - 1];
        }
        if (row < matrix.length - 1) {
            sum += matrix[row + 1][col - 1];
        }

        return sum;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int n : matrix[i]) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("3 x 4 matrix: " + pathsFromBotLeftToBotRight(3, 4));
    }
}
