// https://www.interviewbit.com/problems/multiply-strings/

import java.util.*;

public class MultiplyStrings {
    public static String multiply(String a, String b) {
        return "";
    }

    public static String add(ArrayList<ArrayDeque<Integer>> numbers) {
        String s = "";

        int carry = 0;
        int sum = 0;
        while (true) {
            boolean end = true;
            sum = carry;

            for (ArrayDeque<Integer> number : numbers) {
                if (!number.isEmpty()) {
                    sum += number.poll();
                    end = false;
                }
            }

            if (end == true) {
                break;
            }

            s = (sum % 10) + s;
            carry = sum / 10;
        }

        if (sum > 0) {
            s = sum + s;
        }

        return s;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> numOne = new ArrayDeque<>();
        ArrayDeque<Integer> numTwo = new ArrayDeque<>();
        numOne.add(2);
        numOne.add(1);
        numOne.add(8);
        numTwo.add(9);
        numTwo.add(3);
        numTwo.add(0);
        numTwo.add(2);
        ArrayList<ArrayDeque<Integer>> numbers = new ArrayList<>();
        numbers.add(numOne);
        numbers.add(numTwo);

        System.out.println("Adding 2039 and 812, should yield 2851: " + add(numbers));

        numOne.add(9);
        numOne.add(9);
        numOne.add(9);
        numTwo.add(9);
        numTwo.add(9);
        numTwo.add(9);
        ArrayDeque<Integer> numThree = new ArrayDeque<>();
        numThree.add(9);
        numThree.add(2);
        numThree.add(2);
        numThree.add(5);
        numThree.add(7);
        numbers.clear();
        numbers.add(numOne);
        numbers.add(numTwo);
        numbers.add(numThree);

        System.out.println("Adding 999 + 999 + 75229, should yield 77227: " + add(numbers));
    }
}
