package solution.offer_problem.p37_serialize_binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2021/2/16
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (null == root) {
            return "";
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (null == cur) {
                builder.append("n ");
                continue;
            }

            builder.append(cur.val)
                    .append(" ");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("" == data) {
            return null;
        }

        String[] dataArr = data.split(" ");

        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        queue.offer(root);
        for(int i = 1; i < dataArr.length; i++) {
            TreeNode parent = queue.poll();
            String str = dataArr[i++];
            if (!str.equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(str));
                queue.offer(parent.left);
            }

            str = dataArr[i];
            if (!str.equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(str));
                queue.offer(parent.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node3;
        node3.left = new TreeNode(4);
        node3.right = new TreeNode(5);

        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println(data);
        TreeNode newRoot = codec.deserialize(data);
        System.out.println(newRoot);

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
