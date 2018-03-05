// https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
// expects (0,0) (3,1) (4,2) to be 6 steps
public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int numOfSteps = 0;
        for(int i = 0; i < A.size() - 1; i++) {
            numOfSteps += numOfStepsFromAtoB(A.get(i), B.get(i),
                                            A.get(i + 1), B.get(i + 1));
        }
        return numOfSteps;
    }

    public int numOfStepsFromAtoB(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}
