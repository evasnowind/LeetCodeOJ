package solution.oj_990_satisfiability_of_equality_equation;

/**
 * @author chenglong.yu@100credit.com
 * created on 2020/6/8
 */
public class Solution {

    public boolean equationsPossible(String[] equations) {
        int charArrLen = 26;
        int[] root = new int[charArrLen];
        int[] ranks = new int[charArrLen];

        init(root, ranks, charArrLen);

        for (String str : equations) {
            if (str.charAt(1) == '=') {
                union(root, ranks, str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }

        for (String str : equations) {
            if (str.charAt(1) == '!' && findRoot(root, str.charAt(0) - 'a') == findRoot(root, str.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }

    private void init(int[] root, int[] ranks, int len) {
        for (int i = 0; i < len; i++) {
            root[i] = -1;
            ranks[i] = 0;
        }
    }

    private int findRoot(int[] root, int x) {
        int xRoot = x;
        while(root[xRoot] != -1) {
            xRoot = root[xRoot];
        }
        return xRoot;
    }

    private void union(int[] root, int[] ranks, int x, int y) {
        int xRoot = findRoot(root, x);
        int yRoot = findRoot(root, y);
        if (xRoot == yRoot) {
            //两个节点在一棵树上
            return;
        }

        int xRank = ranks[xRoot];
        int yRank = ranks[yRoot];
        if (xRank < yRank) {
            //谁的高度大，谁就作为合并之后树的根
            root[xRoot] = yRoot;
        } else if (xRank > yRank) {
            root[yRoot] = xRoot;
        } else {
            root[yRoot] = xRoot;
            ranks[xRoot] += 1;
        }
    }
}
