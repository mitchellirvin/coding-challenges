// https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/

public class SwapListNodesInPairs {
    static class ListNode {
       public int val;
       public ListNode next;
       ListNode(int x) { val = x; next = null; }
    }

    public static ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode head = A.next;
        ListNode curr = A;
        ListNode prev = null;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;

            curr.next = next.next;
            next.next = curr;
            if (prev != null) {
                prev.next = next;
            }

            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(6);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Before swapping: ");
        printList(head);

        ListNode newHead = swapPairs(head);
        System.out.println("After swapping: ");
        printList(newHead);
    }
}
