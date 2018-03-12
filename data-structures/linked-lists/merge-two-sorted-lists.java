// https://www.interviewbit.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null) return B;
        if(B == null) return A;

        ListNode curr = new ListNode(0);
        if(A.val <= B.val) {
            curr = A;
            A = A.next;
        } else {
            curr = B;
            B = B.next;
        }

        ListNode head = curr;
        // System.out.println("Starting at: " + curr.val);

        while(A != null && B != null) {
            // System.out.println(A.val + ", " + B.val);
            if(A.val <= B.val) {
                // System.out.println("Next node from A is: " + B.val);
                curr.next = A;
                A = A.next;
            } else {
                // System.out.println("Next node from B is: " + A.val);
                curr.next = B;
                B = B.next;
            }
            curr = curr.next;
        }

        while(A != null) {
            curr.next = A;
            A = A.next;
            curr = curr.next;
        }

        while(B != null) {
            curr.next = B;
            B = B.next;
            curr = curr.next;
        }

        return head;
    }
}
