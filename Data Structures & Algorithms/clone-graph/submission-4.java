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
        if (node.neighbors.size() == 0) return new Node(node.val);
        
        Map<Node, Node> check = new HashMap<>();
    
        int listIndex = 1;

        return dfs(node, check);
        

    }

    private Node dfs (Node node, Map<Node, Node> check)
    {
        if (node == null) return null;
        if (node.neighbors.size() == 0) return new Node(node.val);
        if (check.containsKey(node)) return check.get(node);

        Node curr = node;
        Node copy = new Node(curr.val);
        check.put(curr, copy);

        for (int i = 0; i < curr.neighbors.size(); i++)
        {
            copy.neighbors.add(dfs(curr.neighbors.get(i), check));
        }


        return copy;

    }
}