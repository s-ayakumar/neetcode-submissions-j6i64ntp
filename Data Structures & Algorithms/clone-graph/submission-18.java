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
        Map<Node, Node> check = new HashMap<>();
        //return dfs(node, check);
        return bfs(node, check);

        

    }

   /* private Node dfs (Node node, Map<Node, Node> check)
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
    */
    private Node bfs(Node node, Map<Node, Node> check)
    {
        if (node == null) return null;
        if (node.neighbors.size() == 0) return new Node(node.val);
        Queue<Node> store = new LinkedList<>();
        store.add(node);
        Node copy = new Node(node.val);
        check.put(node, copy);

        while(!store.isEmpty())
        {
            Node curr = store.poll();
            Node currClone = check.get(curr);
            for (int i = 0; i < curr.neighbors.size(); i++)
            {
                if(!check.containsKey(curr.neighbors.get(i))) 
                {
                    check.put(curr.neighbors.get(i), new Node(curr.neighbors.get(i).val));
                    store.add(curr.neighbors.get(i));
                }
                currClone.neighbors.add(check.get(curr.neighbors.get(i)));
            }
        }

        return copy;
    }

}