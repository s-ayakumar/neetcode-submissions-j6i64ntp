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
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int maxSoFar = root.val;

        return goodNodes(root, maxSoFar);
    }
    public int goodNodes(TreeNode root, int maxSoFar) {
        int left;
        int right;
        int count = 0;
        if (root == null) return 0;
        if (root.val >= maxSoFar) {
            count = 1;
            left = goodNodes(root.left, root.val);
            right = goodNodes(root.right, root.val);
        } else {
            left = goodNodes(root.left, maxSoFar);
            right = goodNodes(root.right, maxSoFar);
        }

        return count + left + right;
    }
}
