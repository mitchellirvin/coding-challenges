// https://www.interviewbit.com/problems/3-sum-zero/

import java.util.*;

public class ThreeSumZero {

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();

        Collections.sort(A);
        for(int i = 0; i < A.size(); i++) {
            int k = A.size() - 1;
            int j = i + 1;
            while(k > j) {
                if((-A.get(i)) == (A.get(j) + A.get(k))) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    // System.out.print(A.get(i) + " " + A.get(j) + " " + A.get(k) + " | ");
                    triplet.add(A.get(i));
                    triplet.add(A.get(j));
                    triplet.add(A.get(k));
                    Collections.sort(triplet);
                    if(!triplets.contains(triplet)) triplets.add(triplet);
                    j++;
                    k--;
                } else if((-A.get(i)) > (A.get(j) + A.get(k))) j++;
                else k--;
            }
        }

        return triplets;
    }


    public static void main(String[] args) {
      // call three sum.
      ArrayList<Integer> test = new ArrayList<>();

      test.add(1);
      test.add(-4);
      test.add(0);
      test.add(0);
      test.add(5);
      test.add(-5);
      test.add(1);
      test.add(0);
      test.add(-2);
      test.add(4);
      test.add(-4);
      test.add(1);
      test.add(-1);
      test.add(-4);
      test.add(3);
      test.add(4);
      test.add(-1);
      test.add(-1);
      test.add(-3);

      // expected [-5 0 5 ] [-5 1 4 ] [-4 -1 5 ] [-4 0 4 ] [-4 1 3 ] [-3 -2 5 ]
      // [-3 -1 4 ] [-3 0 3 ] [-2 -1 3 ] [-2 1 1 ] [-1 0 1 ] [0 0 0 ]
      ArrayList<ArrayList<Integer>> results = threeSum(test);
      for(ArrayList<Integer> list : results) {
        for(int n : list) {
          System.out.print(n + " ");
        }
        System.out.println();
      }
    }
}
