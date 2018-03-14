// https://www.interviewbit.com/problems/2-sum/

import java.util.*;

public class TwoSum {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> twoSum(final List<Integer> A, int sumToFind) {
        if(A == null || A.size() <= 1) return new ArrayList<Integer>();

        ArrayList<Integer> indices = new ArrayList<>();
        HashMap<Integer, Integer> arrayMap = new HashMap<>();

        for(int i = 0; i < A.size(); i++) {
            if(arrayMap.containsKey(A.get(i))) {
                indices.add(arrayMap.get(A.get(i)));
                indices.add(i + 1);
                return indices;
            } else {
                if(!arrayMap.containsKey(sumToFind - A.get(i))) {
                    arrayMap.put(sumToFind - A.get(i), i + 1);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    // returns all possible pairs
    public static ArrayList<ArrayList<Integer>> twoSums(ArrayList<Integer> list, int sumToFind) {
        if(list.size() <= 1 || list == null) return new ArrayList<ArrayList<Integer>>();

        HashMap<Integer, Integer> complementToIndexMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> valuePairs = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            if(complementToIndexMap.containsKey(list.get(i))) {
                ArrayList<Integer> valuePair = new ArrayList<>();
                valuePair.add(complementToIndexMap.get(list.get(i)));
                valuePair.add(i);
                System.out.println("Adding: " + complementToIndexMap.get(list.get(i)) + ", " + i);
                valuePairs.add(valuePair);
            } else {
                if(!complementToIndexMap.containsKey(sumToFind - list.get(i))) {
                    complementToIndexMap.put(sumToFind - list.get(i), i);
                }
            }
        }

        return valuePairs;
    }

    public static void main(String[] args) {
      ArrayList<Integer> test = new ArrayList<>();
      test.add(4);
      test.add(7);
      test.add(-4);
      test.add(2);
      test.add(2);
      test.add(2);
      test.add(3);
      test.add(-5);
      test.add(-3);
      test.add(9);
      test.add(-4);
      test.add(9);
      test.add(-7);
      test.add(7);
      test.add(-1);
      test.add(9);
      test.add(9);
      test.add(4);
      test.add(1);
      test.add(-4);
      test.add(-2);
      test.add(3);
      test.add(-3);
      test.add(-5);
      test.add(4);
      test.add(-7);
      test.add(7);
      test.add(9);
      test.add(-4);
      test.add(4);

      ArrayList<Integer> indices = twoSum(test, -3);
      for(int n : indices) {
        System.out.print(n + " " );
      }
      System.out.println();

      test.clear();
      test.add(1);
      test.add(1);
      test.add(1);

      indices = twoSum(test, 2);
      for(int n : indices) {
        System.out.print(n + " " );
      }
      System.out.println();

      test.clear();
      test.add(1);
      test.add(0);
      test.add(-1);
      test.add(0);
      test.add(-2);
      test.add(2);

      ArrayList<ArrayList<Integer>> result = twoSums(test, 0);
      for(int i = 0; i < result.size(); i++) {
        for(int j = 0; j < result.get(i).size(); j++) {
          System.out.print(result.get(i).get(j) + ", ");
        }
        System.out.println();
      }
    }
}
