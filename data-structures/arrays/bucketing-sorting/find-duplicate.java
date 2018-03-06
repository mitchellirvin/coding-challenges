// https://www.interviewbit.com/problems/find-duplicate-in-array/

public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    HashSet<Integer> uniqueNums = new HashSet<>();

	    for(int n : a) {
	        if(uniqueNums.contains(n)) return n;
	        else uniqueNums.add(n);
	    }

	    return 0;
	}
}
