// https://www.interviewbit.com/problems/subtract/
/*
Given linked list 1 -> 2 -> 3 -> 4 -> 5,
You should return 4 -> 2 -> 3 -> 4 -> 5
*/
import java.util.*;

public class SubtractFromFirstHalf {

    static class ListNode {
       public int val;
       public ListNode next;
       ListNode(int x) { val = x; next = null; }
    }

    public static ListNode subtract(ListNode A) {
        ListNode head = A;
        ArrayDeque<Integer> secondHalfOfList = getSecondHalfAsStack(A);

        while(!secondHalfOfList.isEmpty()) {
            A.val = secondHalfOfList.pop() - A.val;
            A = A.next;
        }

        return head;
    }

    public static ArrayDeque<Integer> getSecondHalfAsStack(ListNode head) {
        ArrayDeque<Integer> secondHalfOfList = new ArrayDeque<>();
        ListNode iter = head;

        int numOfNodes = 0;
        while(iter != null) {
            iter = iter.next;
            numOfNodes++;
        }

        iter = head;
        int midPoint = numOfNodes / 2;
        if(numOfNodes % 2 == 1) ++midPoint;

        for(int i = 0; i < numOfNodes; i++) {
            if(i >= midPoint) {
                secondHalfOfList.push(iter.val);
            }
            iter = iter.next;
        }

        return secondHalfOfList;
    }

    public static void main(String[] args) {
      ListNode head = new ListNode(5);
      head.next = new ListNode(9);
      head.next.next = new ListNode(7);
      System.out.println("Should print 2 -> 9 -> 7");
      ListNode result = subtract(head);
      while(result != null) {
        System.out.print(result.val + " -> ");
        result = result.next;
      }
      System.out.println();
    }
}
