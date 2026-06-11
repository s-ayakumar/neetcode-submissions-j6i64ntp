/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> storage = new HashMap<>();
        Node newHead = new Node(head.val);
        Node curr = head;
        Node thisCurr = newHead;

        storage.put(curr, thisCurr);
        
        while (curr.next != null) {
            curr = curr.next;
            Node temp = new Node(curr.val);
            thisCurr.next = temp;
            thisCurr = thisCurr.next;
            storage.put(curr, thisCurr);
        }

        Node newCurr = head;
        Node newThisCurr = newHead;
        while (newCurr != null)
        {
            storage.get(newCurr).random = storage.get(newCurr.random);
            newCurr = newCurr.next;
        }

        return newHead;
    }
}
