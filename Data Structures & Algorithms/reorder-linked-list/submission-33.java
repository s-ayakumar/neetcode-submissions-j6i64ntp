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

        int n = 0;

        ListNode curr = head;

        while (curr != null) {
            curr = curr.next;
            n++;
        }

        curr = head;
        for (int i = 0; i < n/2; i++) {
            curr = curr.next;
        }
        // sh = 10 -> 8 -> 6
        ListNode secondHalf = reverse(curr.next);
        curr.next = null;
        ListNode firstHalf = head;

        // curr = 2 -> 4 
        ListNode currNode = firstHalf;


        while (secondHalf != null) {
            // nf = 4 -> null
            ListNode nextFirst = currNode.next;
            // ns = 8 -> 6
            ListNode nextSecond = secondHalf.next;

            // curr = 2 -> 8 -> 6
            currNode.next = secondHalf;
            // curr = 2 -> 8 -> 4
            currNode.next.next = nextFirst;

            currNode = nextFirst;
            secondHalf = nextSecond;
        }


    }

    // 4 -> 5 -> 6
    // 6 -> 5 -> 4

    private ListNode reverse (ListNode node) {
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
