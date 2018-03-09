// https://www.interviewbit.com/problems/palindrome-integer/

public class Solution {
    public int isPalindrome(int A) {
        if(A < 0) return 0;

        int original = A;
        int reverse = 0;
        while(A != 0) {
            reverse = (reverse * 10) + (A % 10);
            A /= 10;
        }

        if(reverse == original) return 1;
        else return 0;
    }
}
