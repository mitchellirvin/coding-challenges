// https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
// solved with Kadane's algorithm
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int maxSum = Integer.MIN_VALUE, maxAtCurrent = 0;

        for(int i = 0; i < A.size(); i++) {
            maxAtCurrent += A.get(i);
            maxSum = Math.max(maxAtCurrent, maxSum);
            maxAtCurrent = Math.max(maxAtCurrent, 0);
        }

        return maxSum;
    }
}
