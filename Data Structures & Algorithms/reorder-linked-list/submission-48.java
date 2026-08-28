/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {

        ListNode curr = head;

        int n = 0;

        while (curr != null) {
            n++;
            curr = curr.next;
        }

        curr = head;

        for (int i = 0; i < n / 2; i++) {
            curr = curr.next;
        }

        ListNode secondHalf = reverse(curr.next);
        curr.next = null;
        curr = head;
        
        // fh: 0 -> 1 -> 2 
        // sh: 6 -> 5 -> 4 -> 3
        // m: 0 -> 6 -> 1

        while (secondHalf != null) {
            ListNode nextFirst = curr.next;
            ListNode nextSecond = secondHalf.next;

            curr.next = secondHalf;
            curr.next.next = nextFirst;
            curr = nextFirst;
            secondHalf = nextSecond;

        }


        
    }

    // 0 -> 1 -> 2
    // 2 -> 1 -> 0

    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;

    }
}
