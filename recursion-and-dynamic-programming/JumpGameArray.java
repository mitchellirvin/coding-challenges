//

import java.util.*;

class JumpGameArray {
    public static boolean canJump(ArrayList<Integer> jumps) {
        int farthestJump = 0;

        for (int i = 0; i <= farthestJump; i++) {
            if (farthestJump >= jumps.size() - 1) {
                return true;
            }
            farthestJump = Math.max(farthestJump, i + jumps.get(i));
        }

        return false;
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(1);
        test.add(0);
        printArray(test);
        System.out.println("Can jump: " + canJump(test));
    }
}
