// https://www.interviewbit.com/problems/pascal-triangle/

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int A) {
        ArrayList<ArrayList<Integer>> pascalsTriangle = new ArrayList<>();

        for(int i = 0; i < A; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) row.add(1);
                else row.add(pascalsTriangle.get(i - 1).get(j) + pascalsTriangle.get(i - 1).get(j - 1));
            }
            pascalsTriangle.add(row);
        }

        return pascalsTriangle;
    }
}
