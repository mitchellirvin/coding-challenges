// https://www.interviewbit.com/problems/permutations/

import java.util.*;

public class FindPermutationsInArray {
    private static ArrayList<ArrayList<Integer>> permutations;

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        permutations = new ArrayList<>();

        permute(A, 0, A.size() - 1);

        return permutations;
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
