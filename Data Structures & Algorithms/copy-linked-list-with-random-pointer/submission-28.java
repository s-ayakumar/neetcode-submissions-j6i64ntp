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
        Map<Node, Node> copyMap = new HashMap<>();

        Node curr = head;
        Node copyHead = new Node(curr.val);
        Node copy = copyHead;
        copyMap.put(curr, copyHead);

        while (curr.next != null) {
            copy.next = new Node(curr.next.val);
            curr = curr.next;
            copy = copy.next;
            copyMap.put(curr, copy);
        }
        
        copy.next = null;

        curr = head;
        copy = copyHead;

        while (curr != null) {
            copy.random = copyMap.get(curr.random);
            curr = curr.next;
            copy = copy.next;
        }

        return copyHead;



    }
}
