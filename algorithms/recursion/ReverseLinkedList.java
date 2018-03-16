/**
 * Definition for singly-linked list.
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 */
public class ReverseLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    private static ListNode head;

    public static ListNode reverseList(ListNode A) {
        if(A.next == null) {
            head = A;
            return head;
        }
        reverseList(A.next);
        ListNode temp = A.next;
        temp.next = A;
        A.next = null;
        return head;
    }

    public static void main(String[] args) {
        head = null;
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        ListNode result = reverseList(test);
        while(result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println();
    }
}
