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

        Map<Node, Node> copy = new HashMap<>();

        return dfs(copy, node);
    }

    private Node dfs (Map<Node, Node> copy, Node node) {
        if (copy.containsKey(node)) return copy.get(node);

        Node copyNode = new Node(node.val);
        List<Node> copyList = new ArrayList<>();
        copy.put(node, copyNode);

        for (int i = 0; i < node.neighbors.size(); i++) {
            copyList.add(dfs(copy, node.neighbors.get(i)));
        }

        copyNode.neighbors = copyList;

        return copyNode;
        
    }

    

}