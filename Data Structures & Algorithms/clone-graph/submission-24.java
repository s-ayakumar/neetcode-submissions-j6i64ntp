/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {        
        if (node == null) return null;
        // key = og node 
        // val = copy node
        Map<Node, Node> neighbors = new HashMap<>();
        Node clone = dfs(node, neighbors);

        return clone;

    }

    private Node dfs (Node node, Map<Node, Node> neighbors) {
        if (node == null) return null;
        if (neighbors.containsKey(node)) return neighbors.get(node);

        Node copy = new Node(node.val);
        neighbors.put(node, copy);
        List<Node> copyList = new ArrayList<>();

        for (int i = 0; i < node.neighbors.size(); i++) {
            Node neighborClone = dfs(node.neighbors.get(i), neighbors);
            copyList.add(neighborClone);
        }

        copy.neighbors = copyList;

        return copy;

    }

}