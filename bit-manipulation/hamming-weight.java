// https://www.interviewbit.com/problems/number-of-1-bits/

public class Solution {
    // AKA Hamming Weight
	public int numSetBits(long a) {
	    int numOnes = 0;
	    for(int i = 1; i < 33; i++) {
	        if((a & (1 << i)) != 0) numOnes++;
	    }
	    return numOnes;
	}
}
