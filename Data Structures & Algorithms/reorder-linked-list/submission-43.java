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
        
        // 0 -> 1 -> 2 
        // 6 -> 5 -> 4 -> 3

        // 0 -> 6 -> 1
        // 1 -> 2
        // 5 -> 4 -> 3

        // 0 -> 6 -> 1 -> 4 -> 2 
        // 2 
        // 4 -> 3

        // 0 -> 6 -> 1 -> 4 -> 2 -> 4 -> null

        while (secondHalf != null) {
            
            ListNode nextFirst = curr.next;
            ListNode nextSecond = secondHalf.next;

            curr.next = secondHalf;
            curr.next.next = nextFirst;
            curr = nextFirst;
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
