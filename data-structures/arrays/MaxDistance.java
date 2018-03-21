// https://www.interviewbit.com/problems/max-distance/

import java.util.*;

public class MaxDistance {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int maximumGap(final List<Integer> A) {
        // holds smallest element left of A[i] including A[i]
        int[] leftMin = new int[A.size()];
        leftMin[0] = A.get(0);
        for(int i = 1; i < A.size(); i++) {
            leftMin[i] = Math.min(leftMin[i - 1], A.get(i));
        }

        // holds greatest element right of A[j] including A[j]
        int[] rightMax = new int[A.size()];
        rightMax[A.size() - 1] = A.get(A.size() - 1);
        for(int i = A.size() - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A.get(i));
        }

        int i = 0;
        int j = 0;
        int maxGap = Integer.MIN_VALUE;
        while(i < A.size() && j < A.size()) {
            if(leftMin[i] <= rightMax[j]) {
                maxGap = Math.max(maxGap, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(3);
        test.add(5);
        test.add(4);
        test.add(2);
        System.out.println("Should be 2: " + maximumGap(test)); 
    }
}
