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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        TreeNode curr = root;

        if (p.val < curr.val && q.val > curr.val || (q.val < curr.val && p.val > curr.val)) return curr;
        else if (curr.val == p.val || curr.val == q.val) return curr;
        else if (p.val < curr.val && q.val < curr.val) {
           return lowestCommonAncestor(root.left, p, q); 
        }
        else {
            return lowestCommonAncestor(root.right, p, q);
        }
        
    }
}
