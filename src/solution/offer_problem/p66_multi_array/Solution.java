package solution.offer_problem.p66_multi_array;

/**
 * @author chenglong.yu
 * created on 2020/10/8
 */
public class Solution {

    /**
     * 如果没有题目中限定的不许用除法的限制，我们可以将整个数组乘起来，然后每个位置都除以当前A[i]
     * 这样最省时省力。
     *
     * 如果不能用除法，直接暴力算，固然能解，但存在大量重复计算。
     * 此处可以使用DP的思想，进一步优化暴力算法。
     * 基本思想还是保存历史计算结果，空间换时间
     *
     * 分析参见 https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
     * 不过上述这个做法，节省了一个O(N)的空间，下面的解法看着更清晰、更容易理解
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] res = null;
        if (null == a || a.length == 0) {
            return a;
        }

        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
