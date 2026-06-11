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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();
        Queue<TreeNode> holder = new LinkedList<>();
        holder.add(root);
        while (!holder.isEmpty()) {
            int levelLength = holder.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = holder.remove();
                if (i == levelLength - 1) {
                    rightSide.add(curr.val);
                }
                if (curr.left != null) holder.add(curr.left);
                if (curr.right != null) holder.add(curr.right);
            }
        }
        return rightSide;
    }
}
