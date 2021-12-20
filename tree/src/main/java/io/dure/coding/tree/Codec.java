package io.dure.coding.tree;

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        StringBuilder result = new StringBuilder(String.valueOf(root.val));
        result.append(",").append(leftStr).append(",").append(rightStr);
        return result.toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(",");
        int[] i = { 0 };
        return dfs(nodeStrs, i);
    }

    private TreeNode dfs(String[] strs, int[] i) {
        String str = strs[i[0]];
        i[0]++;

        if (str.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = dfs(strs, i);
        node.right = dfs(strs, i);
        return node;
    }

}
