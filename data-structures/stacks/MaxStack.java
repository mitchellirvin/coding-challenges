/*
Implement a stack that has the following methods:

push(val), which pushes an element onto the stack
pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.

Each method should run in constant time.
*/

import java.util.ArrayDeque;

public class MaxStack {
    static class StackWithMax {
        ArrayDeque<Integer> stack;
        ArrayDeque<Integer> maxStack;
        int maxItem;

        StackWithMax() {
            stack = new ArrayDeque<>();
            maxStack = new ArrayDeque<>();
            maxItem = Integer.MIN_VALUE;
        }

        public void push(int item) {
            stack.push(item);
            System.out.println("Pushing: " + item + ". Stack: " + stack.toString());

            if (item > maxItem || maxStack.isEmpty()) {
                maxStack.push(item);
                maxItem = item;
            }
        }

        public int pop() {
            int popped = stack.pop();
            System.out.println("Popping: " + popped + ". Stack: " + stack.toString());

            if (popped == maxStack.peek()) {
                maxStack.pop();
                maxItem = maxStack.peek() == null ? Integer.MIN_VALUE : maxStack.peek();
            }

            return popped;
        }

        public int max() {
            System.out.println("Max: " + maxItem);
            return maxItem;
        }

        public String toString() {
            return stack.toString();
        }
    }

    public static void main(String[] args) {
        StackWithMax integerStack = new StackWithMax();
        integerStack.push(1);
        integerStack.push(3);
        integerStack.push(2);
        integerStack.push(4);
        integerStack.max();
        integerStack.pop();
        integerStack.max();
        integerStack.pop();
        integerStack.max();
        integerStack.pop();
        integerStack.push(2);
        integerStack.max();
        integerStack.pop();
        integerStack.pop();
    }
}
