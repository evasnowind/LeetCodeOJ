package solution.leetcode.lc_1111_max_depth_after_split;

/**
 * @author chenglong.yu
 * created on 2020/4/1
 */
public class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            char ch =seq.charAt(i);
            if (ch == '(') {
                ans[i] = i & 1;
            } else if (ch == ')') {
                ans[i] = 1 - i & 1;
            }
        }

        return ans;
    }

    /**
     * 计算嵌套深度时进行区分。
     * 计算嵌套过程是用栈，但此处只需要计算出深度，深度是奇数分到一组，深度是偶数分到另一组，
     * 可以不用栈、直接用变量保存当前栈深度的计数。只是需要注意一下d加1、减1的时机
     * 这样比较容易理解。上面的实现是总结规律出来的，估计比较难理解自己想出来。
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit2(String seq) {
        int d = 0;
        int length = seq.length();
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            if (seq.charAt(i) == '(') {
                ++d;
                ans[i] = d % 2;
            } else {
                ans[i] = d % 2;
                --d;
            }
        }
        return ans;
    }
}
