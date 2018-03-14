// correct solution to: https://www.interviewbit.com/problems/combinations/
// but known error exists in interviewbit's tests

import java.util.*;

public class FindCombinations {
    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        int[] arr = new int[A];
        for(int i = 0; i < A; i++) arr[i] = i + 1;

        if(B > A) return new ArrayList<ArrayList<Integer>>();

        findCombinations(arr, B);
        return listOfCombos;
    }

    public static ArrayList<ArrayList<Integer>> listOfCombos = new ArrayList<>();

    public static void findCombinations(int arr[], int lengthOfCombination) {
        Integer currCombo[] = new Integer[lengthOfCombination];
        findCombinations(arr, lengthOfCombination, 0, currCombo, 0);
    }

    public static void findCombinations(int arr[], int lengthOfCombination,
        int comboIndex, Integer currCombo[], int arrIndex) {

        if(comboIndex == lengthOfCombination) {
            ArrayList<Integer> currList = new ArrayList<Integer>(Arrays.asList(currCombo));

            if(!listOfCombos.contains(currList)) listOfCombos.add(currList);
            return;
        }

        if(arrIndex >= arr.length) return;

        currCombo[comboIndex] = arr[arrIndex];
        findCombinations(arr, lengthOfCombination, comboIndex + 1,
            currCombo, arrIndex + 1);
        findCombinations(arr, lengthOfCombination, comboIndex,
            currCombo, arrIndex + 1);
    }

    public static void main(String[] args) {
      // call combine
    }
}
