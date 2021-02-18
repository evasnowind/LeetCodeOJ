package solution.leetcode.lc_990_satisfiability_of_equality_equation;

/**
 * @author chenglong.yu
 * created on 2020/6/8
 */
public class Solution {

    public boolean equationsPossible(String[] equations) {
        int charArrLen = 26;
        int[] root = new int[charArrLen];
        int[] ranks = new int[charArrLen];

        init(root, ranks, charArrLen);

        for (String str : equations) {
            /*
            找到a==b这种方程式，将所有能合并的合并到一起，
            这样一个连通分量代表这些变量都相等。
             */
            if (str.charAt(1) == '=') {
                union(root, ranks, str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }

        for (String str : equations) {
            /*
            接下来再查找a!=b这种方程式，如果a在并查集中、并且b也在并查集中，
            说明a==b和a!=b都出现了，是矛盾的，直接返回
             */
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

        /*
        此处采用通过记录每个节点的节点个数，来平衡树的高度，
        平衡后可以将树的高度尽量控制在O(logN)
         */
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
