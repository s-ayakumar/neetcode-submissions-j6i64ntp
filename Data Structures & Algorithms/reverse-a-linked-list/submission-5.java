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

 // 0 -> 1 -> 2 -> 3

 // temp = 1 -> 2 -> 3
 // 0 -> null
 // prev = 0 -> null
 // curr = 1 -> 2 -> 3

 // temp = 2 -> 3
 // curr.next = 0 -> null
 // prev = 1 -> 0 -> null
 // curr = 2 -> 3

 // temp = 3
 // curr.next = 1 -> 0 -> null
 // prev = 2 -> 1 -> 0 -> null
 // curr = 3

 // temp = null
 // curr.next = 2 -> 1 -> 0 -> null
 // prev = 3 -> 2 -> 1 -> 0 -> null
 // curr = null

 // 3 -> 2 -> 1 -> 0

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        ListNode curr = head;
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
