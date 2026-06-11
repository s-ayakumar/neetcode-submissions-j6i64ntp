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
    int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> holder = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !holder.isEmpty()) {
            while (curr != null) {
                holder.push(curr);
                curr = curr.left;
            }
            curr = holder.pop();
            counter++;
            if (counter == k) return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}
