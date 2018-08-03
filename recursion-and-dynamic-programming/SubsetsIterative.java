/*
The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
*/

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.ArrayDeque;

public class SubsetsIterative {

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> powerSet = getPowerSetIncludingEmptySubset();
        if (set.size() == 0) {
            return powerSet;
        }

        // queue to hold the smaller subsets, used to generate next larger subsets
        ArrayDeque<ArrayList<Integer>> subsetsOfPreviousLength = getSubsetsOfLengthOne(set);
        // add all subsets of length 1 to get started.
        powerSet.addAll(new ArrayList<ArrayList<Integer>>(subsetsOfPreviousLength));

        // iterate from 1 through n - 1, where n is length of original set
            // use subsets of previous length to build subsets of next length
        for (int subsetLength = 1; subsetLength < set.size(); subsetLength++) {
            int n = subsetsOfPreviousLength.size() - 1;
            for (int i = 0; i <= n; i++) {
                ArrayList<Integer> nextSubset = subsetsOfPreviousLength.poll();
                for (int indexToAdd = subsetLength + i; indexToAdd < set.size(); indexToAdd++) {
                    // add new value to nextSubset
                    nextSubset.add(set.get(indexToAdd));
                    // add nextSubset to powerSet
                    powerSet.add(new ArrayList<Integer>(nextSubset));
                    // add nextSubset to our queue (used to generate next larger subsets)
                    subsetsOfPreviousLength.add(new ArrayList<Integer>(nextSubset));
                    // remove new value from nextSubset
                    nextSubset.remove(nextSubset.size() - 1);
                }
            }
        }

        return powerSet;
    }

    public static ArrayList<ArrayList<Integer>> getPowerSetIncludingEmptySubset() {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<Integer>());
        return powerSet;
    }

    public static ArrayDeque<ArrayList<Integer>> getSubsetsOfLengthOne(ArrayList<Integer> set) {
        ArrayDeque<ArrayList<Integer>> subsetsOfLengthOne = new ArrayDeque<>();

        for (int n : set) {
            subsetsOfLengthOne.add(new ArrayList<Integer>(asList(n)));
        }

        return subsetsOfLengthOne;
    }

    public static void printSetAndPowerset(ArrayList<Integer> set, ArrayList<ArrayList<Integer>> powerSet) {
        System.out.println("------------------");
        System.out.print("Set: ");
        System.out.println(set);

        System.out.print("Power Set: ");
        System.out.println(powerSet);
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> powerSet = subsets(set);
        printSetAndPowerset(set, powerSet);

        set = new ArrayList<Integer>(asList(1));
        powerSet = subsets(set);
        printSetAndPowerset(set, powerSet);

        set.add(2);
        powerSet = subsets(set);
        printSetAndPowerset(set, powerSet);

        set.add(3);
        powerSet = subsets(set);
        printSetAndPowerset(set, powerSet);

        set.add(4);
        powerSet = subsets(set);
        printSetAndPowerset(set, powerSet);
    }

}
