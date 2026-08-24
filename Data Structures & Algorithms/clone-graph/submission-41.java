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

        // 
        Map<Node, Node> clone = new HashMap<>();

        return dfs(clone, node);
    }

    private Node dfs(Map<Node, Node> clone, Node node) {
        if (clone.containsKey(node)) return clone.get(node);
        Node copy = new Node(node.val);
        clone.put(node, copy);
        List<Node> copyList = new ArrayList<>();

        for (int i = 0; i < node.neighbors.size(); i++) {
            copyList.add(dfs(clone, node.neighbors.get(i)));
        }

        copy.neighbors = copyList;
        return copy;

    }

    

    

}