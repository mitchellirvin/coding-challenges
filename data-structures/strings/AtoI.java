// https://www.interviewbit.com/problems/atoi/

import java.util.*;

public class AtoI {
    public static int atoi(final String A) {
        int i = 0;
	    long num = 0;
	    boolean isNegative = false;
	    String s = A.trim();

	    if (s.length() == 0) {
	        return 0;
	    }

	    if (s.charAt(0) == '-') {
	        isNegative = true;
	        i = 1;
	    } else if (s.charAt(0) == '+') {
	        i = 1;
	    }

	    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
	        num *= 10;
	        num += Character.getNumericValue(s.charAt(i));

	        if (num > Integer.MAX_VALUE && isNegative) {
	            return Integer.MIN_VALUE;
	        } else if (num > Integer.MAX_VALUE && !isNegative) {
	            return Integer.MAX_VALUE;
	        }

	        i++;
	    }

	    if (isNegative) {
	        return -((int) num);
	    }
	    return (int) num;
    }

    public static void main(String[] args) {
        System.out.println("-423423sdfsd yields: " + atoi("-423423sdfsd"));
        System.out.println("345346245745456 yields: " + atoi("345346245745456"));
        System.out.println("gwerewrgsd235ssd yields: " + atoi("gwerewrgsd235ssd"));
    }
}
