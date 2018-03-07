// https://www.interviewbit.com/problems/repeat-and-missing-number-array/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> list) {
        int arr[] = new int[list.size()];
        ArrayList<Integer> output = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[list.get(i) - 1] == 0) arr[list.get(i) - 1] = 1;
            else if(arr[list.get(i) - 1] == 1) output.add(list.get(i));
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) output.add(i + 1);
        }

        return output;
    }
}
