// https://www.interviewbit.com/problems/largest-rectangle-in-histogram/

import java.util.*;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(ArrayList<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }

        Stack<Integer> bars = new Stack<>();
        int poppedIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int maxArea = 0;

        int i = 0;
        while (i < A.size()) {
            if (bars.empty() || A.get(bars.peek()) <= A.get(i)) {
                bars.push(i);
                i++;
            } else {
                poppedIndex = bars.pop();
                if (bars.empty()) {
                    leftIndex = 0;
                    rightIndex = i;
                } else {
                    leftIndex = bars.peek();
                    rightIndex = i - 1;
                }
                System.out.print("left: " + leftIndex + ", " + " right: " + rightIndex + ", min bar: " + A.get(poppedIndex));
                System.out.println(". area: " + (A.get(poppedIndex) * (rightIndex - leftIndex)));
                maxArea = Math.max(maxArea, A.get(poppedIndex) * (rightIndex - leftIndex));
            }
        }

        System.out.println("out of initial loop, calculating remaining areas from bars on stack.");

        while (!bars.empty()) {
            poppedIndex = bars.pop();
            if (bars.empty()) {
                leftIndex = 0;
                rightIndex = i;
            } else {
                leftIndex = bars.peek();
                rightIndex = i - 1;
            }
            System.out.print("left: " + leftIndex + ", " + " right: " + rightIndex + ", min bar: " + A.get(poppedIndex));
            System.out.println(". area: " + (A.get(poppedIndex) * (rightIndex - leftIndex)));
            maxArea = Math.max(maxArea, A.get(poppedIndex) * (rightIndex - leftIndex));
        }

        return maxArea;
    }

    public static void printHistogram(ArrayList<Integer> histogram) {
        for (int n : histogram) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> histogram = new ArrayList<>();
        histogram.add(2);
        histogram.add(1);
        histogram.add(5);
        histogram.add(6);
        histogram.add(2);
        histogram.add(3);
        printHistogram(histogram);
        System.out.println("Max rectangle area: " + largestRectangleArea(histogram));
    }
}
