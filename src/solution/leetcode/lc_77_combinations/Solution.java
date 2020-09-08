package solution.leetcode.lc_77_combinations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/8
 */
public class Solution {

    /**
     * 本质还是回溯经典题目：全排列的变种，不过是结束条件有所变化而已
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || n < k) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        backtrack(n, k, 1, path, res);
        return res;
    }


    private void backtrack(int n, int k, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        //此处有剪枝，分析参见 https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
        for (int i = start; i <= (n - (k - path.size()) + 1); i++) {
            path.addLast(i);
            /*
            务必注意回溯时，传入的起始索引位置，如果传入的是start+1，将会出现相同元素不同顺序（2/3,3/2）、或是同一个元素（2/2）。
            显然这种不符合题目要求。
             */
            backtrack(n, k, i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4, k = 2;
        List<List<Integer>> result = s.combine(n, k);
        System.out.println("result=" + result);
    }


    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 只有这里 i <= n - (k - path.size()) + 1 与参考代码 1 不同
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
}
