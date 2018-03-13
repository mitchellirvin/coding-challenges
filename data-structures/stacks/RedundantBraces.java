// https://www.interviewbit.com/problems/redundant-braces/

import java.util.*;

public class RedundantBraces {
    public static int braces(String A) {
        ArrayDeque<Character> bracesStack = new ArrayDeque<>();

        for(char c : A.toCharArray()) {
            if(c == '(') bracesStack.push('(');
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                if(bracesStack.size() > 0) bracesStack.pop();
            }
        }

        return (bracesStack.isEmpty() ? 0 : 1);
    }

    public static void main(String[] args) {
      System.out.println("should return 0: " + braces("a+b"));
      System.out.println("should return 0: " + braces("((a+b)-b)"));
      System.out.println("should return 0: " + braces("(a+b)-(a*b)/b"));
      System.out.println("should return 1: " + braces("(a+b)-(a*b)/(b)"));
      System.out.println("should return 1: " + braces("((a+b))"));
    }
}
