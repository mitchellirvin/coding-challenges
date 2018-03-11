import java.util.*;

class SortedInsertPosition {
    public static int searchInsert(ArrayList<Integer> a, int b) {
  	    int upperIndex = a.size() - 1, lowerIndex = 0, mid = (lowerIndex + upperIndex) / 2;

  	    while(lowerIndex <= upperIndex) {
          mid = (lowerIndex + upperIndex) / 2;
  	        System.out.println("checking index: " + mid + " :" +
  	            lowerIndex + "," + upperIndex);
  	        if(a.get(mid) == b) return mid;
  	        else if(a.get(mid) < b) lowerIndex = mid + 1;
  	        else upperIndex = mid - 1;
  	    }

        // case where target would be inserted at end of array
        if(a.get(mid) < b) return mid + 1;
  	    return mid;
  	}

    public static void main(String[] args) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(1);
      list.add(3);
      list.add(5);
      list.add(6);
      System.out.println(searchInsert(list, 0));
      System.out.println(searchInsert(list, 4));
      System.out.println(searchInsert(list, 7));
    }
}
