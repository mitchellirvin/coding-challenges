// https://www.interviewbit.com/problems/greatest-common-divisor/

public class Solution {
    public int gcd(int A, int B) {
        for(int i = Math.min(A, B); i > 1; i--) {
            if((A % i == 0) && (B % i == 0)) return i;
        }
        if(A == 0 || B == 0) return Math.max(A, B);
        return 1;
    }
}
