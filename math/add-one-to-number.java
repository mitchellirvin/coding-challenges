// https://www.interviewbit.com/problems/add-one-to-number/
public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> list) {
        String numericValueString = "";
        ArrayList<Integer> incrementedList = new ArrayList<>();

        int startIndex = 0;
        while(list.get(startIndex) == 0) {
            startIndex++;
            if(startIndex == list.size()) {
                incrementedList.add(1);
                return incrementedList;
            }
        }

        for(int i = startIndex; i < list.size(); i++) {
            incrementedList.add(list.get(i));
        }

        for(int i = incrementedList.size() - 1; i >= 0; i--) {
            if(incrementedList.get(i) == 9) incrementedList.set(i, 0);
            else {
                incrementedList.set(i, incrementedList.get(i) + 1);
                break;
            }

            if(i - 1 == -1) incrementedList.add(0, 1);
        }

        return incrementedList;
    }
}
