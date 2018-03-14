// https://www.interviewbit.com/problems/3-sum-zero/

import java.util.*;

public class Solution {
    public static class SumPair {
        int sum;
        int firstVal;
        int firstIndex;
        int secondVal;
        int secondIndex;
        public SumPair(int sum, int firstVal, int firstIndex, int secondVal, int secondIndex) {
            this.sum = sum;
            this.firstVal = firstVal;
            this.firstIndex = firstIndex;
            this.secondVal = secondVal;
            this.secondIndex = secondIndex;
        }
    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();

        Collections.sort(A);
        ArrayList<SumPair> pairSums = new ArrayList<>();
        for(int i = 0; i < A.size(); i++) {
            for(int j = i + 1; j < A.size(); j++) {
                pairSums.add(new SumPair(A.get(i) + A.get(j), A.get(i), i, A.get(j), j));
            }
        }

        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < pairSums.size(); j++) {
                if((A.get(i) + pairSums.get(j).sum == 0) &&
                    (i != pairSums.get(j).firstIndex && i != pairSums.get(j).secondIndex)) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(A.get(i));
                        triplet.add(pairSums.get(j).firstVal);
                        triplet.add(pairSums.get(j).secondVal);
                        Collections.sort(triplet);
                        if(!triplets.contains(triplet)) {
                            triplets.add(triplet);
                        }
                    }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
      // call three sum.
      // currently fails the interviewbit test because of inefficiency
    }
}
