// CTCI 6th Edition, Problem 1.5

import java.util.*;

public class OneAway {
    public static boolean oneAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }
        return oneAwayByInsertOrRemove(a, b) || oneAwayBySwitchChar(a, b);
    }

    public static boolean oneAwayByInsertOrRemove(String a, String b) {
        if (a.length() == b.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        boolean diff = false;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                if (diff) {
                    return false;
                }
                diff = true;

                if (a.length() > b.length()) {
                    j--;
                } else {
                    i--;
                }
            }
            i++;
            j++;
        }

        return true;
    }

    public static boolean oneAwayBySwitchChar(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        boolean diff = false;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                if (diff) {
                    return false;
                }
                diff = true;
            }
            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "mythics";
        String b = "mythic";
        System.out.println(a + ", " + b + " : " + oneAway(a, b));
        a = "magical";
        b = "magucal";
        System.out.println(a + ", " + b + " : " + oneAway(a, b));
        a = "poopy";
        b = "poppy";
        System.out.println(a + ", " + b + " : " + oneAway(a, b));
        a = "marvelous";
        b = "marvelusy";
        System.out.println(a + ", " + b + " : " + oneAway(a, b));
    }
}
