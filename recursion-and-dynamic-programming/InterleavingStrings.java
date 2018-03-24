import java.util.*;
import java.lang.*;

public class InterleavingStrings {
    public static int isInterleave(String A, String B, String C) {
        return isInterleave(A, B, C, 0, 0, 0);
    }

    public static int isInterleave(String A, String B, String C, int indexA, int indexB, int indexC) {
        printTabs(indexC);
        System.out.println(C.charAt(indexC) + ": " + A.charAt(indexA) + ", " + B.charAt(indexB));

        // base case
        if (indexA == A.length() || indexB == B.length()) {
            while (indexA < A.length()) {
                if (C.charAt(indexC) == A.charAt(indexA)) {
                    indexA++;
                } else {
                    return 0;
                }
                indexC++;
            }
            while (indexB < B.length()) {
                if (C.charAt(indexC) == B.charAt(indexB)) {
                    indexB++;
                } else {
                    return 0;
                }
                indexC++;
            }
            return 1;
        }

        // if both chars match, try both and return true if either results in true
        if (A.charAt(indexA) == B.charAt(indexB) && A.charAt(indexA) == C.charAt(indexC)) {
            return Math.max(isInterleave(A, B, C, indexA + 1, indexB, indexC + 1),
                isInterleave(A, B, C, indexA, indexB + 1, indexC + 1));
        } else if (A.charAt(indexA) == C.charAt(indexC)) {
            return isInterleave(A, B, C, indexA + 1, indexB, indexC + 1);
        } else if (B.charAt(indexB) == C.charAt(indexB)) {
            return isInterleave(A, B, C, indexA, indexB + 1, indexC + 1);
        } else {
            return 0;
        }
    }

    public static void printTabs(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }

    public static void main(String[] args) {
        isInterleave("3TCD", "6CWA", "36TCWCDA");
    }
}
