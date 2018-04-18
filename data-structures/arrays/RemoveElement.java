// https://www.interviewbit.com/problems/remove-element-from-array/

import java.util.*;

public class RemoveElement {
    public static int removeElement(ArrayList<Integer> list, int numToRemove) {
	    int index = 0;
	    int count = 0;
	    for (int i = 0; i < list.size(); i++) {
	        if (list.get(i) == numToRemove) {
	            count++;
	        } else {
	            list.set(index, list.get(i));
	            index++;
	        }
	    }
	    return list.size() - count;
	}

    public static void printArray(ArrayList<Integer> list) {
        for (int n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(1);
        test.add(1);
        test.add(2);
        test.add(1);
        test.add(3);
        printArray(test);
        System.out.println("Removed " + removeElement(test, 1) + " instances of 1.");
    }
}
