// https://www.interviewbit.com/problems/painters-partition-problem/#

import java.util.*;

public class PaintersPartition {
    public static int paint(int painters, int timeToPaint, ArrayList<Integer> boards) {
        // use binary search to check at minimum how many painters it takes
        // to paint a maximum board size of *mid*, adjust mid is number of painters
        // is more than are available or otherwise

        // map boards to actual cost based on timeToPaint
        long[] actualBoards = mapToActualTime(boards, timeToPaint);
        long lo = getMinimumBoardSize(actualBoards);
        long hi = getMaximumBoardSize(actualBoards);

        while (lo < hi) {
            long mid = (lo + hi) / 2;

            if (minimumPainters(mid, actualBoards) <= painters) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return Math.toIntExact(lo % 10000003);
    }

    public static int minimumPainters(long maxTime, long[] boards) {
        int currPainters = 1;
        long currSum = 0;

        for (long board : boards) {
            currSum += board;
            if (currSum > maxTime) {
                currSum = board;
                currPainters++;
            }
        }

        return currPainters;
    }

    public static long[] mapToActualTime(ArrayList<Integer> boards, int timeToPaint) {
        return boards
            .stream()
            .mapToLong(Integer::longValue)
            .map(board -> (board * (long) timeToPaint) % 10000003)
            .toArray();
    }

    public static long getMinimumBoardSize(long[] boards) {
        return Arrays
            .stream(boards)
            .max()
            .getAsLong();
    }

    public static long getMaximumBoardSize(long[] boards) {
        return Arrays
            .stream(boards)
            .reduce((accumulator, value) -> {
                return (accumulator + value);
            })
            .getAsLong();
    }

    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>();
        boards.add(1);
        boards.add(3);
        boards.add(4);
        boards.add(6);
        System.out.print("Boards (by time to paint): ");
        System.out.println(boards);
        System.out.println("Min time to paint with 2 painters " + paint(2, 1, boards));
    }
}
