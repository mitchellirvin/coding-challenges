// https://www.interviewbit.com/problems/bulbs/

import static java.util.Arrays.asList;

import java.util.List;

public class LightBulbsOnAWire {
    public static int numberOfFlips(List<Integer> A) {
        int flips = 0;

        for (int n : A) {
            if (isOff(n, flips)) {
                flips++;
            }
        }

        return flips;
    }

    public static boolean isOff(int light, int flips) {
        if ((isEven(flips) && light == 0) || (isOdd(flips) && light == 1)) {
            return true;
        }
        return false;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    public static void main(String[] args) {
        List<Integer> bulbs = asList(0, 1, 0, 1);
        System.out.print("Bulbs: ");
        System.out.println(bulbs);
        System.out.println("Flips: " + numberOfFlips(bulbs));
    }
}
