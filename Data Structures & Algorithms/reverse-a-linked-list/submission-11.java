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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        // [0, 1, 2, 3]
        // [3, 2, 1, 0]
        // make previous of 0 the curr next of 0         

        ListNode curr = head;
        ListNode prev = null;
        // 1 0 -> null
        // 
        while (curr != null) {
            // 2 -> 3
            ListNode temp = curr.next;
            // 1 -> 0
            curr.next = prev;
            // prev = 1
            prev = curr;
            // curr = 2 -> 3
            curr = temp;
        }

        return prev;

    }
}
