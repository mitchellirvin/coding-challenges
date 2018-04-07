// https://www.interviewbit.com/problems/assign-mice-to-holes/

import java.util.*;

public class MiceToHoles {
    public static int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int maxTime = 0;

        for (int i = 0; i < A.size(); i++) {
            maxTime = Math.max(maxTime, Math.abs(A.get(i) - B.get(i)));
        }

        return maxTime;
    }

    public static void main(String[] args) {
        ArrayList<Integer> mice = new ArrayList<>();
        ArrayList<Integer> holes = new ArrayList<>();
        mice.add(4);
        mice.add(-4);
        mice.add(2);
        holes.add(4);
        holes.add(0);
        holes.add(5);

        System.out.println("Mice: 4, -4, 2. Holes: 4, 0, 5. Min time: " + mice(holes, mice));
    }
}
