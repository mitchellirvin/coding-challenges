// https://www.interviewbit.com/problems/merge-k-sorted-lists/

// efficiencies: k is number of linked lists, n is num of elements per list
// space: O(k)
// time: O(nk Log(k)) because we iterate over each element in each linked list,
//     and heapify take Log(k) time per iteration


import java.util.*;

public class MergeKLinkedLists {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
	    PriorityQueue<ListNode> pointers = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
        	@Override
        	public int compare(ListNode a, ListNode b) {
    			return Integer.compare(a.val, b.val);
        	}
        });

        for(int i = 0; i < a.size(); i++) {
	        pointers.add(a.get(i));
	    }

	    ListNode head = pointers.poll();
	    if(head.next != null) {
	        pointers.add(head.next);
	    }

	    ListNode current = head;
	    ListNode next =  null;
	    while(pointers.size() > 0) {
	        next = pointers.poll();
	        if(next.next != null) {
	            pointers.add(next.next);
	        }

	        current.next = next;
	        current = current.next;
	    }

	   return head;
    }

    public static void main(String[] args) {
        ArrayList<ListNode> test = new ArrayList<>();
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(4);
        test.add(n);
        n = new ListNode(5);
        n.next = new ListNode(7);
        n.next.next = new ListNode(10);
        test.add(n);
        n = new ListNode(3);
        n.next = new ListNode(6);
        n.next.next = new ListNode(9);
        test.add(n);

        ListNode sortedList = mergeKLists(test);
        System.out.println("Merging: 1 -> 2 -> 4, 5 -> 7 -> 10, and 3 -> 6 -> 9.");
        System.out.print("Merged list: ");
        while(sortedList != null) {
            System.out.print(sortedList.val + " -> ");
            sortedList = sortedList.next;
        }
        System.out.println();
    }
}
