// https://www.interviewbit.com/problems/container-with-most-water/

import java.util.*;

public class ContainersWithMostWater {
    public static int maxArea(ArrayList<Integer> A) {
        int i = 0;
        int j = A.size() - 1;
        int max = 0;

        while (j > i) {
            max = Math.max(max, (j - i) * Math.min(A.get(i), A.get(j)));
            if (A.get(i) < A.get(j)) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> containers = new ArrayList<>();
        containers.add(1);
        containers.add(5);
        containers.add(4);
        containers.add(3);
        System.out.println("Coordinates: 0,1 - 1,5 - 2,4 - 3,3.");
        System.out.println("Max water to hold: " + maxArea(containers));
    }
}
