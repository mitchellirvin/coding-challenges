/*
  A=[1, 2, 1, 3, 4, 3] and K = 3

  All windows of size K are

  [1, 2, 1]
  [2, 1, 3]
  [1, 3, 4]
  [3, 4, 3]

  So, we return an array [2, 3, 3, 2].
*/

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> windowUniqueNums = new ArrayList<>();
        HashMap<Integer, Integer> window = new HashMap<>();

        for(int i = 0; i < A.size(); i++) {
            // remove element from back of window
            if(i - B >= 0) {
                window.put(A.get(i-B), window.get(A.get(i-B)) - 1);
                if(window.get(A.get(i-B)) == 0) window.remove(A.get(i-B));
            }

            if(window.containsKey(A.get(i))) window.put(A.get(i), window.get(A.get(i)) + 1);
            else window.put(A.get(i), 1);

            // add unique count for current window
            if(i - (B - 1) >= 0) windowUniqueNums.add(window.size());
        }

        return windowUniqueNums;
    }
}
