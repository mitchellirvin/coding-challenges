// https://www.interviewbit.com/problems/diffk-ii/

import java.util.*;

public class DiffK {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int diffPossible(final List<Integer> A, int B) {
        if(A == null || A.size() <= 1) return 0;

        HashSet<Integer> diffs = new HashSet<>();
        for(int i = 0; i < A.size(); i++) {
            if(diffs.contains(A.get(i))) return 1;
            else {
                diffs.add(A.get(i) + B);
                diffs.add(A.get(i) - B);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
      ArrayList<Integer> test = new ArrayList<>();
      test.add(32);
      test.add(77);
      test.add(28);
      test.add(19);
      test.add(21);
      test.add(67);
      test.add(15);
      test.add(53);
      test.add(25);
      test.add(82);
      test.add(52);
      test.add(8);
      test.add(94);
      test.add(50);
      test.add(30);
      test.add(37);
      test.add(39);
      test.add(9);
      test.add(43);
      test.add(35);
      test.add(48);
      test.add(82);
      test.add(53);
      test.add(16);
      test.add(20);
      test.add(13);
      test.add(95);
      test.add(18);
      test.add(67);
      test.add(77);
      test.add(12);
      test.add(93);
      test.add(0);

      System.out.println("should be 1: " +  diffPossible(test, 53));
    }
}
