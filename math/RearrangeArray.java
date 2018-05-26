// https://www.interviewbit.com/problems/rearrange-array/

import java.util.*;

public class RearrangeArray {
	public static void arrange(ArrayList<Integer> a) {
	    int size = a.size();
	    for (int i = 0; i < size; i++) {
	        int curr = a.get(i);
	        // set upper 16 bits of curr to hold the new value
	        curr += (a.get(curr) % size) * size;
	        a.set(i, curr);
	    }

	    for (int i = 0; i < size; i++) {
	        a.set(i, a.get(i) / size);
	    }
	}

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.print(item.toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(3);
        test.add(2);
        test.add(0);
        System.out.println("Before: ");
        printList(test);
        arrange(test);
        System.out.println("After: ");
        printList(test);
    }
}
