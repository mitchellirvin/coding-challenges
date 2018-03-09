// https://www.interviewbit.com/problems/single-number/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int lonelyNumber = 0;
        for(int n : A) {
            lonelyNumber ^= n;
        }
        return lonelyNumber;
    }
}
