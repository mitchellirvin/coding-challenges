// https://www.hackerrank.com/contests/101hack55/challenges/minimize-the-sum

import java.util.ArrayList; 

public class MinimizeTheSum {
    static class Pair {
        int low;
        int high;
        Pair(int low, int high) { this.low = low; this.high = high; }
    }

    static long minimumSum(int[] l, int[] r) {
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            pairs.add(new Pair(l[i], r[i]));
        }

        long cost = 0;
        Pair prev = pairs.get(0);
        for (int i = 1; i < pairs.size(); i++) {
            Pair curr = pairs.get(i);
            // jump up from prev
            if (curr.low > prev.high) {
                cost += (long) (curr.low - prev.high);
                // assign what was jumped to
                prev.low = curr.low;
                prev.high = curr.low;
            }
            // jump down from prev
            else if (curr.high < prev.low) {
                cost += (long) (prev.low - curr.high);
                // assign what was jumped to
                prev.low = curr.high;
                prev.high = curr.high;
            }
            // some overlap
            else {
                prev = getOverlappedPair(curr, prev);
            }
        }

        return (long) cost;
    }

    private static Pair getOverlappedPair(Pair curr, Pair prev) {
        int low = Math.max(curr.low, prev.low);
        int high = Math.min(curr.high, prev.high);
        return new Pair(low, high);
    }

    public static void main(String[] args) {
        int[] l = {1, 2, 6, 2, 1};
        int[] r = {3, 5, 8, 3, 2};

        System.out.println("Should yield 7: " + minimumSum(l, r));
    }
}
