// https://www.interviewbit.com/problems/min-jumps-array/

import java.util.*;

public class MinJumpArray {
    public static int jump(ArrayList<Integer> A) {
        if (A.size() <= 1) {
            return 0;
        } else if (A.get(0) == 0) {
            return -1;
        }

        int maxJump = A.get(0);
        int stepsRemaining = A.get(0);
        int numOfJumps = 1;

        for (int i = 1; i <= maxJump; i++) {
            maxJump = Math.max(maxJump, A.get(i) + i);
            if (i == A.size() - 1) {
                return numOfJumps;
            }

            stepsRemaining--;
            if (stepsRemaining == 0) {
                numOfJumps++;
                stepsRemaining = maxJump - i;
            }
        }

        return -1;
    }

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.print(item.toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(1);
        test.add(1);
        test.add(2);
        test.add(4);
        printList(test);
        System.out.println("Min jumps to end of array: " + jump(test));
    }
}
