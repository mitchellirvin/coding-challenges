import java.util.*;

public class FindSharedElements {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        arr1[0] = 2;
        arr1[1] = 4;
        arr1[2] = 5;
        arr1[3] = 7;
        arr1[4] = 9;

        int[] arr2 = new int[5];
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
        arr2[3] = 6;
        arr2[4] = 7;

        int arr1Pointer = 0;
        int arr2Pointer = 0;

        System.out.print("Shared elements: ");
        while (arr1Pointer < arr1.length && arr2Pointer < arr2.length) {
            if (arr1[arr1Pointer] == arr2[arr2Pointer]) {
                System.out.print(arr1[arr1Pointer] + " ");
                arr1Pointer++;
                arr2Pointer++;
            } else if (arr1[arr1Pointer] < arr2[arr2Pointer]) {
                arr1Pointer++;
            } else {
                arr2Pointer++;
            }
        }
        System.out.println();
    }
}
