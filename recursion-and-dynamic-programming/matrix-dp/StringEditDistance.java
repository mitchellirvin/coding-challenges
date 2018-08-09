// https://www.interviewbit.com/problems/edit-distance/

public class StringEditDistance {
    public static int minDistance(String A, String B) {
        return minDistance(A, B, A.length(), B.length());
    }

    public static int minDistance(String A, String B, int indexA, int indexB) {
        int[][] memo = new int[indexA + 1][indexB + 1];

        for(int i = 0; i <= indexA; i++) {
            for(int j = 0; j <= indexB; j++) {
                if (i == 0) {
                    memo[i][j] = j;
                } else if (j == 0) {
                    memo[i][j] = i;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    memo[i][j] = 1 + min(memo[i - 1][j],    // remove
                                        memo[i][j - 1],     // insert
                                        memo[i - 1][j - 1]);// replace
                }
            }
        }

        return memo[indexA][indexB];
    }

    public static int recursiveMinDistance(String A, String B, int indexA, int indexB) {
        if (indexA == A.length() || indexB == B.length()) {
            if (indexA < A.length()) {
                return A.length() - indexA;
            } else if (indexB < B.length()) {
                return B.length() - indexB;
            } else {
                return 0;
            }
        }

        if (A.charAt(indexA) == B.charAt(indexB)) {
            indexA++;
            indexB++;
            return minDistance(A, B, indexA, indexB);
        }

        // return min of removal, replacement, addition (demonstrated in that order)
        return 1 + min(
                minDistance(A, B, indexA + 1, indexB),
                minDistance(A, B, indexA + 1, indexB + 1),
                minDistance(A, B, indexA, indexB + 1)
            );
    }

    public static int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    public static void main(String[] args) {
        String s1 = "amitousy";
        String s2 = "ambitious";
        System.out.println("Number of changes to edit \"" + s1 + "\" to become \"" + s2 + "\"");
        System.out.println(minDistance(s1, s2) + " changes.");
    }
}
