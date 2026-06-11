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
        List<List<Integer>> storeList = new ArrayList<>();
        Queue<TreeNode> store = new LinkedList<>();
        store.add(root);
    
        while (!store.isEmpty()) {
            int levelLength = store.size();
            List<Integer> levelStore = new ArrayList<>();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = store.remove();
                levelStore.add(curr.val);
                if (curr.left != null) store.add(curr.left);
                if (curr.right != null) store.add(curr.right);
            }
            storeList.add(levelStore);
        }
        return storeList;
    }
}
