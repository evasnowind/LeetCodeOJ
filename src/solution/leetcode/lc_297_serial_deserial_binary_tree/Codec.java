package solution.leetcode.lc_297_serial_deserial_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenglong.yu
 * created on 2020/6/16
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null == node) {
                builder.append("n ");
                continue;
            }
            builder.append(node.val)
                    .append(" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("" == data) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodeStr = data.split(" ");
        TreeNode root = new TreeNode(0);
        root.val = Integer.parseInt(nodeStr[0]);
        queue.add(root);

        for(int idx = 1; idx < nodeStr.length; idx ++) {
            TreeNode parent = queue.poll();
            if (!nodeStr[idx].equals("n")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodeStr[idx]));
                parent.left = leftNode;
                queue.add(leftNode);
            }
            idx += 1;
            if (!nodeStr[idx].equals("n")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodeStr[idx]));
                parent.right = rightNode;
                queue.add(rightNode);
            }
        }

        return root;
    }

    public static void main(String[] args) {

        //[1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);

        Codec codec = new Codec();
        String code = codec.serialize(root);
        TreeNode node = codec.deserialize(code);
        System.out.println(code);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}