// https://www.interviewbit.com/problems/sort-by-color/

import static java.util.Arrays.asList;

import java.util.ArrayList;

public class SortByColor {

    public static void sortColors(ArrayList<Integer> a) {
        int lo = 0;
        int hi = a.size() - 1;

        for (int i = 0; i <= hi; i++) {
            if (a.get(i) == 0) {
                swap(a, lo, i);
                lo++;
            } else if (a.get(i) == 2) {
                swap(a, i, hi);
                hi--;
                i--;
            }
        }
    }

    public static void swap(ArrayList<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> toSort = new ArrayList<Integer>(asList(0, 1, 2, 0, 1, 2));
        System.out.println("Prior to sorting: ");
        System.out.println(toSort);
        sortColors(toSort);
        System.out.println("Sorted: ");
        System.out.println(toSort);
    }

}
