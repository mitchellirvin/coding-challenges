// https://www.interviewbit.com/problems/distinct-subsequences/

public class DistinctSubsequences {
    public static int distinctSubsequences(String A, String B) {
        if (A.length() < B.length()) {
            return 0;
        } else if (A.equals(B)) {
            return 1;
        }

        int[][] matrix = new int[A.length() + 1][B.length() + 1];

        for (int col = 0; col <= B.length(); col++) {
            matrix[0][col] = 0;
        }
        for (int row = 0; row <= A.length(); row++) {
            matrix[row][0] = 1;
        }

        for (int row = 1; row <= A.length(); row++) {
            for (int col = 1; col <= B.length(); col++) {
                if (A.charAt(row - 1) == B.charAt(col - 1)) {
                    matrix[row][col] = matrix[row - 1][col - 1]
                        + matrix[row - 1][col];
                } else {
                    matrix[row][col] = matrix[row - 1][col];
                }
            }
        }

        return matrix[A.length()][B.length()];

        // return recursive(A, B, "", 0);
    }

    public static int recursive(String superSequence, String subSequence, String build, int index) {
       if (build.length() == subSequence.length() || index >= superSequence.length()) {
           if (build.equals(subSequence)) {
               return 1;
           }
           return 0;
       }

       int num = 0;
       // explore without curr char
       num += recursive(superSequence, subSequence, build, index + 1);
       // explore with curr char
       build += superSequence.charAt(index);
       num += recursive(superSequence, subSequence, build, index + 1);

       return num;
    }

    public static void main(String[] args) {
        System.out.println("Distinct subsequences of row in roewowrow: " + distinctSubsequences("roewowrow", "row"));
    }
}
