import java.util.*;

public class LongestValidParens {
    public static int longestValidParentheses(String A) {
        // stack to hold indices of (
        // push -1 onto stack initially

        // for each char in string
            // if char is ( push onto stack
                // increment current counter
            // else
                // pop from stack
                // if stack is empty
                    // push current index
                // else
                    // calculate current valid length
                    // update max IF max < curr

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int curr = 0;
        int max = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // reset starting index
                    stack.push(i);
                } else {
                    curr = i - stack.peek();
                    max = Math.max(max, curr);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // System.out.println(longestValidParentheses(")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))((("));
        System.out.println(longestValidParentheses(")())(())"));
    }
}
