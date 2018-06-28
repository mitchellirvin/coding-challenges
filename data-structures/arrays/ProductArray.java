/**
Given an array of integers, return a new array such that each element at index i
of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be
[120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
*/

public class ProductArray {
    public static int[] withDivision(int[] input) {
        int product = 1;

        for (int n : input) {
            product *= n;
        }

        int[] products = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            products[i] = product / input[i];
        }

        return products;
    }

    public static int[] withoutDivision(int[] input) {
        int[] productsFromLeft = new int[input.length];
        int[] productsFromRight = new int[input.length];

        productsFromLeft[0] = input[0];
        for (int i = 1; i < input.length; i++) {
            productsFromLeft[i] = productsFromLeft[i - 1] * input[i];
        }

        productsFromRight[input.length - 1] = input[input.length - 1];
        for (int i = input.length - 2; i >= 0; i--) {
            productsFromRight[i] = productsFromRight[i + 1] * input[i];
        }

        int[] products = new int[input.length];
        products[0] = productsFromRight[1];
        products[input.length - 1] = productsFromLeft[input.length - 2];
        for (int i = 1; i < input.length - 1; i++) {
            products[i] = productsFromLeft[i - 1] * productsFromRight[i + 1];
        }

        return products;
    }

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "}");
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        System.out.print("For input: ");
        printArray(input);

        System.out.print("    withDivision() yields: ");
        printArray(withDivision(input));

        System.out.print("    withoutDivision() yields: ");
        printArray(withoutDivision(input));

        int[] input2 = {1, 2};
        System.out.print("For input: ");
        printArray(input2);

        System.out.print("    withDivision() yields: ");
        printArray(withDivision(input2));

        System.out.print("    withoutDivision() yields: ");
        printArray(withoutDivision(input2));
    }
}
