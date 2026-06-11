/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnOutput = new ArrayList<>();
        Queue<TreeNode> store = new LinkedList<>();
        if (root == null) return returnOutput;
        store.add(root);
        
        
        while (!store.isEmpty())
        {
            int size = store.size();
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i < size)
            {
                TreeNode current = store.poll();
                int curr = current.val;
                temp.add(curr);
                if (current.left != null) store.add(current.left);
                if (current.right != null) store.add(current.right);
                i++;
            }
            returnOutput.add(temp);
        }

        return returnOutput;
    }
}
