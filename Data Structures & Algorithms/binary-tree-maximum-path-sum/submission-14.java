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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxPath;
    }
    public int findMaxPath (TreeNode subRoot) {
        if (subRoot == null) return 0;

        int left = findMaxPath(subRoot.left);
        int right = findMaxPath(subRoot.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        
        maxPath = Math.max(left + right + subRoot.val, maxPath);

        return subRoot.val + Math.max(left, right);
    }
}

