// https://www.interviewbit.com/problems/allocate-books/
// https://articles.leetcode.com/the-painters-partition-problem-part-ii/

import java.util.*;

public class AllocateBooks {
    public static int allocateBooks(ArrayList<Integer> A, int B) {
        if (B > A.size()) {
            return -1;
        }

        int lo = getMaximum(A);
        int hi = getSum(A);

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // System.out.println("Lo: " + lo + ", Hi: " + hi + ", Mid: " + mid);
            if (getMinimumStudents(A, mid) <= B) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.print(item.toString() + " ");
        }
        System.out.println();
    }

    public static int getMinimumStudents(ArrayList<Integer> books, int minPages) {
        int currSum = 0;
        int students = 1;

        for (int pages : books) {
            currSum += pages;
            if (currSum > minPages) {
                students++;
                currSum = pages;
            }
        }

        return students;
    }

    public static int getMaximum(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        for (int n : A) {
            max = Math.max(max, n);
        }
        return max;
    }

    public static int getSum(ArrayList<Integer> A) {
        int sum = 0;
        for (int n : A) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> books = new ArrayList<>();
        books.add(12);
        books.add(34);
        books.add(67);
        books.add(90);
        System.out.print("Books (# pages): ");
        printList(books);
        System.out.println("Min pages to partition for 3 readers: " + allocateBooks(books, 3));
    }
}
