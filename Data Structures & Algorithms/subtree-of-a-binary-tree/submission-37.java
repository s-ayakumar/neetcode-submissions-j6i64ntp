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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null && subRoot != null) return false;
        
        boolean curr = false;
        if (root.val == subRoot.val) {
            curr = isSame(root, subRoot);
        }

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        return left || right || curr;


    }
    
    private boolean isSame (TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null && subRoot != null) return false;
        if (root != null && subRoot == null) return false;

        if (root.val != subRoot.val) return false;

        boolean left = isSame(root.left, subRoot.left);
        boolean right = isSame(root.right, subRoot.right);

        return left && right;
    }
}
