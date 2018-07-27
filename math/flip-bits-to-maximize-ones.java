// https://www.interviewbit.com/problems/flip/

public class Solution {
    public ArrayList<Integer> flip(String s) {
        // base case S is all 1s
        String zeroes = s.replace("1", "");
        if(zeroes.length() == 0) return new ArrayList<Integer>();

        return findSubArrayWithSum(s);
    }

    public ArrayList<Integer> findSubArrayWithSum(String s) {
        int maxSum = Integer.MIN_VALUE, maxAtCurrent = 0;
        int left = 1, right = 1, maxLeft = 1;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') maxAtCurrent += 1;
            else maxAtCurrent -= 1;

            if(maxAtCurrent > maxSum) {
                right = i + 1;
                maxLeft = left;
                maxSum = maxAtCurrent;
            }

            if(maxAtCurrent < 0) {
                maxAtCurrent = 0;
                left = i + 2;
            }
        }

        ArrayList<Integer> leftAndRight = new ArrayList<>();
        leftAndRight.add(maxLeft);
        leftAndRight.add(right);
        return leftAndRight;
    }
}
