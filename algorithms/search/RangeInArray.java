import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RangeInArray {
	// DO NOT MODIFY THE LIST
	public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    ArrayList<Integer> range = new ArrayList<>();

	    int startIndex = findStartIndex(a, b);

	    if(a.get(startIndex) != b) {
	        range.add(-1);
	        range.add(-1);
	        return range;
	    }

	    range.add(startIndex);
	    range.add(findEndIndex(a, b));
	    return range;
	}

	public static int findStartIndex(List<Integer> a, int b) {
	    int midIndex = 0, lowerBound = 0, upperBound = a.size() - 1;

	    while(lowerBound < upperBound) {
			    System.out.println("index: " + lowerBound + ", " + upperBound);
	        midIndex = (upperBound + lowerBound) / 2;
	        if(b <= a.get(midIndex)) upperBound = midIndex - 1;
	        else lowerBound = midIndex + 1;
	    }

	    System.out.println("index: " + lowerBound + ", " + a.get(lowerBound));
	    if(a.get(lowerBound) == b) return lowerBound;
	    return lowerBound + 1;
	}

	public static int findEndIndex(List<Integer> a, int b) {
	    int midIndex = 0, lowerBound = 0, upperBound = a.size() - 1;

	    while(lowerBound < upperBound) {
	        midIndex = (upperBound + lowerBound) / 2;
	        if(b < a.get(midIndex)) upperBound = midIndex - 1;
	        else lowerBound = midIndex + 1;
	    }

	    // System.out.println("index: " + lowerBound + ", " + a.get(lowerBound));
	    if(a.get(lowerBound) == b) return lowerBound;
	    return lowerBound - 1;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(5);
		list.add(5);
		System.out.println("Calling search range");
		for(int n : searchRange(list, 2)) {
			System.out.print(n + " ");
		}
	}
}
