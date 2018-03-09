// https://www.interviewbit.com/problems/intersection-of-sorted-arrays/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> commonValues = new ArrayList<>();

        int i = 0, j = 0;
        while(i < A.size() && j < B.size()) {
            if(A.get(i).equals(B.get(j))) {
                commonValues.add(A.get(i));
                j++;
                i++;
            } else if(A.get(i) < B.get(j)) i++;
            else j++;
        }

        return commonValues;
    }
}
