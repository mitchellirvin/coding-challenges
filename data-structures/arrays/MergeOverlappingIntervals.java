//

import java.util.*;

public class MergeOverlappingIntervals {
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Interval currentInterval = new Interval();
        Interval nextInterval = new Interval();
        ArrayList<Interval> mergedIntervals = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
        	@Override
        	public int compare(Interval a, Interval b) {
    			if (a.start <= b.start) {
                    return -1;
                }
                return 1;
        	}
        });

        for (int i = 0; i < intervals.size(); i++) {
            currentInterval = intervals.get(i);
            System.out.print("Current: " + currentInterval.start + ":" + currentInterval.end + " | ");

            for (int j = i + 1; j < intervals.size(); j++) {
                nextInterval = intervals.get(j);
                System.out.print("Next: " + nextInterval.start + ":" + nextInterval.end + " | ");
                // merge case
                if (currentInterval.end >= nextInterval.start) {
                    currentInterval.start = Math.min(nextInterval.start, currentInterval.start);
                    currentInterval.end = Math.max(nextInterval.end, currentInterval.end);
                    mergedIntervals.add(nextInterval);
                } else {
                    System.out.println();
                    break;
                }
                i = j;
            }
        }

        System.out.println("\nRemoving: ");
        printIntervals(mergedIntervals);
        intervals.removeAll(mergedIntervals);
        return intervals;
    }

    public static void printIntervals(ArrayList<Interval> intervals) {
        for (Interval interval : intervals) {
            System.out.print("(" + interval.start + ", " + interval.end + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Interval one = new Interval(2, 3);
        Interval two = new Interval(4, 6);
        Interval three = new Interval(1, 7);
        Interval four = new Interval(8, 10);
        Interval five = new Interval(11, 13);
        Interval six = new Interval(12, 15);
        ArrayList<Interval> test = new ArrayList<>();
        test.add(one);
        test.add(two);
        test.add(three);
        test.add(four);
        test.add(five);
        test.add(six);
        printIntervals(test);
        merge(test);
        System.out.println("Post merge: ");
        printIntervals(test);
    }
}
