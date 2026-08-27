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

        if (p.val < curr.val && q.val < curr.val) {
            return lowestCommonAncestor(curr.left, p, q);
        }
        else if (p.val > curr.val && q.val > curr.val) {
            return lowestCommonAncestor(curr.right, p, q);
        }
        else {
            return curr;
        }
        
    }
}
