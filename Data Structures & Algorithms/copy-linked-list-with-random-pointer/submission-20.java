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
        if (head ==
        null) return null;
        Node curr = head;
        Node copy = new Node(curr.val);
        Node copyHead = copy;
        Map<Node, Node> copyMap = new HashMap<>();

        while (curr.next != null) {
            copy.next = new Node(curr.next.val);
            copyMap.put(curr, copy);
            curr = curr.next;
            copy = copy.next;
        }
        copy.next = null;
        copyMap.put(curr, copy);

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
