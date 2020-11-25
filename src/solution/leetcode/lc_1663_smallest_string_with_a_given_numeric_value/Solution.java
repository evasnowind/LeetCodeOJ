package solution.leetcode.lc_1663_smallest_string_with_a_given_numeric_value;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author chenglong.yu
 * created on 2020/11/25
 */
public class Solution {

    /**
     * 题目本身很简单。
     * 但是我思路想错了。
     * 我的思路：
     * 1、遍历、生成所有方案，找到最优解
     * 这个的话可以使用回溯模板写出代码，但当n很大时时间复杂度非常高，因为是26^n
     * 2、看到最小，结果去从动态规划的思路上靠，结果没靠出来。。。。
     *
     * 看题解，从直观感觉走，用贪心的思想，
     * 先将所有字符串置为a，然后修改这个字符串，从后往前修改，
     * 直到k值消耗完
     *
     * @param n
     * @param k
     * @return
     */
    public String getSmallestString(int n, int k) {
        int[] idx = new int[n];
        //先将整个字符串置为全a
        for (int i = 0; i < n; i++) {
            idx[i] = 1;
            k--;
        }

        //从后往前开始消耗k，能装一个z就装z，剩余的继续往前
        for (int i = n - 1; i >= 0; i--) {
            if (k > 0) {
                /*
                最后一位最大是z，即最多消耗k是26，如果k小于等于这个值，则结束;
                否则还需要递进、继续这个过程
                 */
                int last = 26 - idx[i];
                if (k <= last) {
                    idx[i] += k;
                    break;
                } else {
                    k -= last;
                    idx[i] = 26;
                }
            }
        }
        String res = Arrays.stream(idx)
                .boxed()
                .map(i -> "" + (char)(i + 'a' - 1))
                .collect(Collectors.joining());
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = null;
//        str = s.getSmallestString(3, 27);
//        System.out.println(str);
//        str = s.getSmallestString(5, 73);
//        System.out.println(str);
        str = s.getSmallestString(5, 130);
        System.out.println(str);
    }


    public String getSmallestString2(int n, int k) {
        StringBuilder builder = new StringBuilder();
        backtrack(builder, n, k);
        return res;
    }

    private static String res = null;

    private void backtrack(StringBuilder str, int n, int k) {
        if (n == 0 && k == 0) {
            res = str.toString();
            return;
        } else if (k == 0 || n == 0) {
            return;
        }
        for (int i = 1; i <= 26; i++) {
            char ch = (char)('a' + i - 1);
            str.append(ch);
            backtrack(str, n - 1, k - i);
            if (null != res) {
                return;
            }
            str.deleteCharAt(str.length() - 1);
        }
    }

}
