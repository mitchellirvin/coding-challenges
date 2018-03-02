import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyQueue<T> {
    private Stack<T> stackOrder = new Stack<T>();
    private Stack<T> queueOrder = new Stack<T>();

    public void enqueue(T n) {
        stackOrder.push(n);
    }

    public T dequeue() {
        doQueueOrder();
        return queueOrder.pop();
    }

    public T peek() {
        doQueueOrder();
        return queueOrder.peek();
    }

    public void doQueueOrder() {
        if(queueOrder.empty()) {
            while(!stackOrder.empty()) queueOrder.push(stackOrder.pop());
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
