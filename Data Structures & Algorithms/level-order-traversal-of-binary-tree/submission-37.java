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
        
        if (root == null) return new ArrayList<>();

        TreeNode curr = root;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(curr);

        while (!q.isEmpty()) {
            int size = q.size(); // 1
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll(); 
                currLevel.add(currNode.val); 
                if (currNode.left != null) {
                    q.add(currNode.left); 
                }
                if (currNode.right != null) {
                    q.add(currNode.right); // add 3
                }
            }
            result.add(currLevel);
        }


        return result;

    }
}
