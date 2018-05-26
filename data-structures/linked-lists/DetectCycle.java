// https://www.interviewbit.com/problems/list-cycle/

import java.util.*;

public class DetectCycle {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

	public static ListNode detectCycle(ListNode a) {
	    HashSet<ListNode> visited = new HashSet<>();

	    while (a != null) {
	        if (visited.contains(a)) {
                System.out.println("\nFound start of cycle: " + a.val);
	            return a;
	        }
            System.out.print(a.val + " -> ");
	        visited.add(a);
	        a = a.next;
	    }

	    return null;
	}

    public static void main(String[] args) {
        ListNode test = new ListNode(4);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = test.next;
        detectCycle(test);
    }
}
