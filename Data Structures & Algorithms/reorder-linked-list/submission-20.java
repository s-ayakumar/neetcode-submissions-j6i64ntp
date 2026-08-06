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
        ListNode middle = null;

        for (int i = 0; i < n; i++) {
            if (i == n / 2) {
                middle = curr;
                break;
            }
            curr = curr.next;
        }

        ListNode secondHalf = middle.next;
        middle.next = null;
        
        secondHalf = reverse(secondHalf);

        curr = head;
        ListNode temp = head;

        while (curr != null && secondHalf != null) {
            ListNode nextFirst = curr.next;
            ListNode nextSecond = secondHalf.next;

            curr.next = secondHalf;
            secondHalf.next = nextFirst;

            curr = nextFirst;
            secondHalf = nextSecond;

        }
    }

    private ListNode reverse (ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
        
    }


}
