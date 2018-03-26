import java.util.*;
import java.lang.*;

public class InterleavingStrings {
    public static boolean isInterleave(String A, String B, String C) {
        return isInterleave(A, B, C, 0, 0, 0);
    }

    public static boolean isInterleave(String A, String B, String C, int indexA, int indexB, int indexC) {
        // base case, we've reached the end of the interleaved string
        if(indexC == C.length()) {
            return true;
        }

        boolean answer = false;

        if (indexA < A.length() && A.charAt(indexA) == C.charAt(indexC)) {
            answer |= isInterleave(A, B, C, indexA + 1, indexB, indexC + 1);
        }
        if (indexB < B.length() && B.charAt(indexB) == C.charAt(indexC)) {
            answer |= isInterleave(A, B, C, indexA, indexB + 1, indexC + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.print("Should yield 'true': ");
        System.out.println(isInterleave("noUdRp97xFvpifeSXGwOjcVNhHo9N2D", "6iZItw9A3fj86uYx04tvWKLtl9BK",
            "n6ioUdRpZ97ItwxF9Av3fj86upYxif0eS4XtvWKLtlG9wOBKjcVNhHo9N2D"));
    }
}
