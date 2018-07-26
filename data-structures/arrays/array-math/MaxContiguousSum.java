// https://www.interviewbit.com/problems/max-sum-contiguous-subarray/

import static java.util.Arrays.asList;

import java.util.List;

// solved with Kadane's algorithm
public class MaxContiguousSum {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int maxSubArray(final List<Integer> A) {
        int maxSum = Integer.MIN_VALUE, maxAtCurrent = 0;

        for(int i = 0; i < A.size(); i++) {
            maxAtCurrent += A.get(i);
            maxSum = Math.max(maxAtCurrent, maxSum);
            maxAtCurrent = Math.max(maxAtCurrent, 0);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        List<Integer> input = asList(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        System.out.println("Given input: ");
        System.out.println(input); 
        System.out.println("Max Sum of a Contiguous Subarray: " + maxSubArray(input));
    }
}
