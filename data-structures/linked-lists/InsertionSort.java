public class InsertionSort {
    static ListNode head;

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static ListNode insertionSortList(ListNode A) {
        head = null;

        while(A != null) {
            ListNode next = A.next;
            insertIntoSortedList(A);
            A = next;
        }

        return head;
    }

    public static void insertIntoSortedList(ListNode nodeToInsert) {
        if(head == null || head.val >= nodeToInsert.val) {
            nodeToInsert.next = head;
            head = nodeToInsert;
        } else {
            ListNode pointer = head;
            while(pointer.next != null && pointer.next.val < nodeToInsert.val) {
                pointer = pointer.next;
            }
            nodeToInsert.next = pointer.next;
            pointer.next = nodeToInsert;
        }
    }

    public static void printList(ListNode node) {
      System.out.println("--");
      while(node != null) {
        System.out.print(node.val + " -> ");
        node = node.next;
      }
      System.out.println("\n--");
    }

    public static void main(String[] args) {
      ListNode test = new ListNode(4);
      test.next = new ListNode(2);
      test.next.next = new ListNode(3);
      test.next.next.next = new ListNode(1);
      printList(test);
      printList(insertionSortList(test));
    }
}
