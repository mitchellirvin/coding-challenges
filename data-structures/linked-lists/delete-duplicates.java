/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode head = A;

        while(A.next != null) {
            if(A.val == A.next.val) {
                A.next = A.next.next;
                if(A.next == null) break;
            } else A = A.next;
        }

        return head;
    }
}
