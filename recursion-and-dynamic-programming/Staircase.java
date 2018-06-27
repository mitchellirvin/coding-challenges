/**
There's a staircase with N steps, and you can climb 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time. Generalize your function to take in X.
*/

import java.util.HashSet;

public class Staircase {
    public static int waysToClimb(int numberOfStairs) {
        int currentMinusOne = 1;
        int currentMinusTwo = 2;

        for (int i = 1; i < numberOfStairs; i++) {
            int temp = currentMinusTwo;
            currentMinusTwo = currentMinusOne + currentMinusTwo;
            currentMinusOne = temp;
        }

        return currentMinusOne;
    }

    public static int waysToClimb(int numberOfStairs, HashSet<Integer> waysToJump) {
        int[] dp = new int[numberOfStairs + 1];
        dp[0] = 1;

        for (int i = 0; i <= numberOfStairs; i++) {
            for (int jump : waysToJump) {
                if (i - jump >= 0) {
                    dp[i] += dp[i - jump];
                }
            }
        }

        return dp[numberOfStairs];
    }

    public static void main(String[] args) {
        System.out.println("Ways to climb 3 stairs with jumps {1, 2} (expecting 3): " + waysToClimb(3));
        System.out.println("Ways to climb 5 stairs with jumps {1, 2} (expecting 8): " + waysToClimb(5));

        HashSet<Integer> waysToJump = new HashSet<>();
        waysToJump.add(1);
        waysToJump.add(3);
        waysToJump.add(5);
        System.out.println("Ways to climb 3 stairs with jumps {1, 3, 5} (expecting 2): "
            + waysToClimb(3, waysToJump));
        System.out.println("Ways to climb 6 stairs with jumps {1, 3, 5} (expecting 8): "
            + waysToClimb(6, waysToJump));
    }
}
