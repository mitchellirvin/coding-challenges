// https://www.interviewbit.com/problems/rotate-matrix/

class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int row = 0;
        int col = 0;
        int temp = 0;
        int toPlace = 0;

        for (int j = 0; j < n / 2; j++) {
            toPlace = matrix[j][j];
            for (int i = 0; i < n - 1 - (j * 2); i++) {

                // 1st shift
                row = i + j;
                col = n - 1 - j;
                temp = matrix[row][col];
                // System.out.println("At: " + row + ", " + col + ": assigning " + toPlace);
                matrix[row][col] = toPlace;
                toPlace = temp;

                // 2nd shift
                row = col;
                col = n - 1 - i - j;
                temp = matrix[row][col];
                // System.out.println("At: " + row + ", " + col + ": assigning " + toPlace);
                matrix[row][col] = toPlace;
                toPlace = temp;

                // 3rd shift
                row = col;
                col = 0 + j;
                temp = matrix[row][col];
                // System.out.println("At: " + row + ", " + col + ": assigning " + toPlace);
                matrix[row][col] = toPlace;
                toPlace = temp;

                // 4th shift
                row = 0 + j;
                col = i + j;
                temp = matrix[row][col];
                // System.out.println("At: " + row + ", " + col + ": assigning " + toPlace);
                matrix[row][col] = toPlace;

                toPlace = matrix[row][col + 1];
            }

            printMatrix(matrix);
        }

    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("\n Matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[1][0] = 2;
        matrix[1][1] = 2;
        matrix[1][2] = 1;
        matrix[1][3] = 3;
        matrix[2][0] = 3;
        matrix[2][1] = 1;
        matrix[2][2] = 2;
        matrix[2][3] = 2;
        matrix[3][0] = 4;
        matrix[3][1] = 3;
        matrix[3][2] = 2;
        matrix[3][3] = 1;

        int[][] second = new int[2][2];
        second[0][0] = 1;
        second[0][1] = 2;
        second[1][0] = 2;
        second[1][1] = 1;
        printMatrix(second);
        rotate(second);

        printMatrix(matrix);
        rotate(matrix);
    }
}
