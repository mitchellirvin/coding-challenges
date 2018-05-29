// https://www.interviewbit.com/problems/permutations/

import java.util.*;

public class FindPermutationsInArray {
    private static ArrayList<ArrayList<Integer>> permutations;

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        permutations = new ArrayList<>();

        System.out.print("Finding permutations of: ");
        System.out.println(A);

        // faster and more space efficient iterative solution
        List<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
        LinkedList<Integer> curr = new LinkedList<>();
        curr.add(A.get(0));
        results.add(curr);

        for (int i = 1; i < A.size(); i++) {
            // pick next int from A
            int nextValue = A.get(i);
            // for each LinkedList (permutation) in results
            // place the next int at all possible positions
            for (int j = results.size() - 1; j >= 0; j--) {
                LinkedList<Integer> permutation = results.remove(j);
                int size = permutation.size();
                for (int k = 0; k <= size; k++) {
                    permutation.add(k, nextValue);
                    results.add(new LinkedList<Integer>(permutation));
                    permutation.remove(k);
                }
            }
        }

        System.out.println(results.size() + " permutations.");
        System.out.println(results);

        return null;

        // permute(A, 0, A.size() - 1);
        // return permutations;
    }

    public static void printTabs(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }

    public static void permute(ArrayList<Integer> list, int leftIndex, int rightIndex) {
        printTabs(leftIndex);
        System.out.print("Calling permute on: ");
        for(int n : list) {
            System.out.print(n + " ");
        }
        System.out.println(" : " + leftIndex + ", " + rightIndex);

        if(leftIndex == rightIndex) {
            printTabs(leftIndex + 1);
            System.out.print("Adding: ");
            for(int n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
            permutations.add(new ArrayList<Integer>(list));
        }
        else {
            for(int i = leftIndex; i <= rightIndex; i++) {
                // choose
                list = swapValuesInList(list, leftIndex, i);
                // explore
                permute(list, leftIndex + 1, rightIndex);
                // unchoose
                list = swapValuesInList(list, leftIndex, i);
            }
        }
    }

    public static ArrayList<Integer> swapValuesInList(ArrayList<Integer> list, int leftIndex, int rightIndex) {
        int temp = list.get(leftIndex);
        list.set(leftIndex, list.get(rightIndex));
        list.set(rightIndex, temp);
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        permute(test);
    }
}
