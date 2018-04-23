//

import java.util.*;

public class SortList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode leftHalf = null;
        ListNode mid = getMiddleNode(node);
        ListNode rightHalf = mid.next;
        // cut end off left half
        mid.next = null;

        // sort left
        leftHalf = mergeSort(node);

        // sort right
        rightHalf = mergeSort(rightHalf);

        // merge/return sorted halves
        return mergeHalves(leftHalf, rightHalf);
    }

    // returns node at middle of list
    public static ListNode getMiddleNode(ListNode node) {
        ListNode singleJump = node;
        ListNode doubleJump = node.next;

        while (doubleJump != null) {
            doubleJump = doubleJump.next;
            if (doubleJump != null) {
                doubleJump = doubleJump.next;
                singleJump = singleJump.next;
            }
        }

        return singleJump;
    }

    // recursive implementation is simpler, but uses large amount of stack space
    public static ListNode mergeHalves(ListNode leftHalf, ListNode rightHalf) {
        ListNode curr = new ListNode(0);
        ListNode headRef = curr;

        while (leftHalf != null && rightHalf != null) {
            if (leftHalf.val <= rightHalf.val) {
                curr.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                curr.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            curr = curr.next;
        }

        while (leftHalf != null) {
            curr.next = leftHalf;
            leftHalf = leftHalf.next;
            curr = curr.next;
        }
        while (rightHalf != null) {
            curr.next = rightHalf;
            rightHalf = rightHalf.next;
            curr = curr.next;
        }

        return headRef.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Before sort: ");
        printList(head);
        ListNode sorted = mergeSort(head);
        System.out.println("After sort: ");
        printList(sorted);
    }
}
