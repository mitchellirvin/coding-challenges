/*
  This solution is fully functional with the exception of the twosum function
  The twosum function does not correctly return all pairs that sum to the Given
  input
*/

import java.util.*;

public class FourSum {
    static class SumAndPair {
        int sum;
        int firstVal;
        int secondVal;
        SumAndPair(int sum, int firstVal, int secondVal) {
            this.sum = sum;
            this.firstVal = firstVal;
            this.secondVal = secondVal;
        }
    }

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<SumAndPair> pairSums = new ArrayList<>();

        // Collections.sort(A);
        // find all pair sums, without redundancy
        for(int i = 0; i < A.size() - 1; i++) {
            for(int j = i + 1; j < A.size(); j++) {
                // System.out.print("pair: " + A.get(i) + ", " + A.get(j) + " | ");
                pairSums.add(new SumAndPair(A.get(i) + A.get(j), i, j));
            }
        }
        System.out.print(pairSums.size() + " | ");

        ArrayList<ArrayList<Integer>> winningPairs = twoSum(pairSums, B);
        ArrayList<ArrayList<Integer>> winningQuads = new ArrayList<>();
        HashSet<ArrayList<Integer>> dupeQuadChecker = new HashSet<>();
        HashSet<Integer> dupeIndexChecker = new HashSet<>();

        for(ArrayList<Integer> list : winningPairs) {
            ArrayList<Integer> quad = new ArrayList<>();

            dupeIndexChecker.clear();
            for(int pairSumsIndex : list) {
                if(dupeIndexChecker.contains(pairSums.get(pairSumsIndex).firstVal) ||
                    dupeIndexChecker.contains(pairSums.get(pairSumsIndex).secondVal)) break;

                dupeIndexChecker.add(pairSums.get(pairSumsIndex).firstVal);
                dupeIndexChecker.add(pairSums.get(pairSumsIndex).secondVal);

                quad.add(A.get(pairSums.get(pairSumsIndex).firstVal));
                quad.add(A.get(pairSums.get(pairSumsIndex).secondVal));
            }

            if(quad.size() == 4) {
                for(int n : quad) {
                    System.out.print(n + " " );
                }
                System.out.print(" | ");
                Collections.sort(quad);
                if(dupeQuadChecker.contains(quad)) continue;

                winningQuads.add(quad);
                dupeQuadChecker.add(quad);
            }
        }

        return winningQuads;
    }

    public static ArrayList<ArrayList<Integer>> twoSum(ArrayList<SumAndPair> list, int sumToFind) {
        if(list.size() <= 1 || list == null) return new ArrayList<ArrayList<Integer>>();

        HashMap<Integer, Integer> complementToIndexMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> valuePairs = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            if(complementToIndexMap.containsKey(list.get(i).sum)) {
                ArrayList<Integer> valuePair = new ArrayList<>();
                valuePair.add(complementToIndexMap.get(list.get(i).sum));
                valuePair.add(i);
                System.out.print("quad: " +
                    list.get(complementToIndexMap.get(list.get(i).sum)).firstVal + " " +
                        list.get(complementToIndexMap.get(list.get(i).sum)).secondVal +
                        ", " + list.get(i).firstVal + " " + list.get(i).secondVal + " | ");
                valuePairs.add(valuePair);
            } else {
                if(!complementToIndexMap.containsKey(sumToFind - list.get(i).sum)) {
                    System.out.print(" storing complement: " + (sumToFind - list.get(i).sum) + " | ");
                    complementToIndexMap.put(sumToFind - list.get(i).sum, i);
                }
            }
        }

        return valuePairs;
    }

    public static void main(String[] args) {
      System.out.println("test");
    }
}
