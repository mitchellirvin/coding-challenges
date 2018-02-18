import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        Stack<Character> bracketStack = new Stack<>();

        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '{') bracketStack.push('}');
            else if(expression.charAt(i) == '[') bracketStack.push(']');
            else if(expression.charAt(i) == '(') bracketStack.push(')');
            else if( bracketStack.empty() || (bracketStack.pop() != expression.charAt(i)) ) return false;
        }
        
        return bracketStack.empty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
