// https://www.interviewbit.com/problems/majority-element/

import java.util.*;

public class MajorityElement {
    public static int majorityElement(final List<Integer> A) {
        HashMap<Integer, Integer> valueToCount = new HashMap<>();

        int majority = 0;
        int element = 0;

        for (int n : A) {
            if (!valueToCount.containsKey(n)) {
                valueToCount.put(n, 1);
            } else {
                valueToCount.put(n, valueToCount.get(n) + 1);
            }
            if (valueToCount.get(n) > majority) {
                majority = valueToCount.get(n);
                element = n;
            }
        }

        return element;
    }

    public static int majorityElementGreedy(final List<Integer> A) {
        int majority = 0;
        int element = 0;

        for (int n : A) {
            if (n != element) {
                majority--;
                if (majority < 0) {
                    element = n;
                    majority = 1;
                }
            } else {
                majority++;
            }
        }

        return element;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(3);
        test.add(2);
        test.add(3);
        test.add(6);
        test.add(6);
        test.add(3);
        test.add(3);
        test.add(3);

        System.out.println("Should yield 3: " + majorityElement(test));
        System.out.println("Should yield 3 (greedy): " + majorityElementGreedy(test));

        test.add(6);
        test.add(6);
        test.add(6);
        test.add(6);
        test.add(6);
        test.add(6);

        System.out.println("Should yield 6: " + majorityElement(test));
        System.out.println("Should yield 6 (greedy): " + majorityElementGreedy(test));
    }
}
