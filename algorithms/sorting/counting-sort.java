import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] countingSort(int[] arr) {
        int[] copy = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            copy[arr[i]]++;
        }

        int[] retArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < copy[i]; j++) {
                retArr[i] = i;
            }
        }

        return retArr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = countingSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
