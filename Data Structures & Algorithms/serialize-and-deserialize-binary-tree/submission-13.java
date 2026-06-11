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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
       return String.join(",", res);
    }
    private void dfsSerialize(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] newData = data.split(",");
        int[] k = {0};
        return dfsDeserialize(newData, k);
    }
    private TreeNode dfsDeserialize(String[] newData, int[] k) {
        if (newData[k[0]].equals("N")) {
            k[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(newData[k[0]]));
        k[0]++;
        root.left = dfsDeserialize(newData, k);
        root.right = dfsDeserialize(newData, k);
        return root;
    }
}
