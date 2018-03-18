// https://www.hackerrank.com/challenges/ctci-merge-sort/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeSort {
    private static long swaps;

    public static long countInversions(int[] arr) {
        swaps = 0;

        mergeSort(arr);
        // for(int n : arr) {
        //     System.out.print(n + " ");
        // }
        // System.out.println();

        return swaps;
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if(leftStart < rightEnd) {
            int mid = (leftStart + rightEnd) / 2;
            // sort left half of array
            mergeSort(arr, temp, leftStart, mid);
            // sort right half of array
            mergeSort(arr, temp, mid + 1, rightEnd);
            mergeHalves(arr, temp, leftStart, rightEnd);
        }
    }

    public static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;

        int left = leftStart;
        int right = leftEnd + 1;
        int index = left;

        while(left <= leftEnd && right <= rightEnd) {
            if(arr[right] < arr[left]) {
                System.out.println("swapping " + (leftEnd - left + 1) + " times");
                swaps += leftEnd - left + 1;
                temp[index] = arr[right];
                right++;
            } else {
                temp[index] = arr[left];
                left++;
            }
            index++;
        }

        // copy remaining in either array over to temp
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        // copy temp back into arr
        System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 2;
        arr[1] = 1;
        arr[2] = 3;
        arr[3] = 1;
        arr[4] = 2;

        System.out.print("Sorting array: ");
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
        long result = countInversions(arr);
        System.out.println("total swaps: " + result);
        System.out.print("Sorted array: ");
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
