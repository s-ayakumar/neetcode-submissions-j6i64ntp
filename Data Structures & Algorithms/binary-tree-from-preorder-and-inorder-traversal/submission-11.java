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
    int preorderIndex;
    HashMap<Integer, Integer> lookup;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inOrderTrack;
        lookup = new HashMap<>();

        for (inOrderTrack = 0; inOrderTrack < inorder.length; inOrderTrack++) {
            lookup.put(inorder[inOrderTrack], inOrderTrack);
        }

        return fillIn(preorder, 0, inorder.length - 1);
    }

    public TreeNode fillIn(int[] preorder, int l, int r) {
        if (l > r) return null;

        int rootVal = preorder[preorderIndex];
        preorderIndex++;

        int inOrderIndex = lookup.get(rootVal);
        
        TreeNode root = new TreeNode(rootVal);
        
        root.left = fillIn(preorder, l, inOrderIndex - 1);
        root.right = fillIn(preorder, inOrderIndex + 1, r);

        return root;

    }
}
