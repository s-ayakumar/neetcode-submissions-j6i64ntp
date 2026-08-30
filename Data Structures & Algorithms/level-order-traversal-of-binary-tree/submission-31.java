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

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int currLvl = q.size();
            
            List<Integer> lvl = new ArrayList<>();

            for (int i = 0; i < currLvl; i++) {
                TreeNode curr = q.poll();
                int currVal = curr.val;
                lvl.add(currVal);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            list.add(lvl);
        }

        return list;
        
        
    }
}
