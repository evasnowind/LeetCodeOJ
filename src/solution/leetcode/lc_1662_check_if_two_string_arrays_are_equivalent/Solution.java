package solution.leetcode.lc_1662_check_if_two_string_arrays_are_equivalent;

/**
 * @author chenglong.yu
 * created on 2020/11/25
 */
public class Solution {
    /**
     * 这个没啥可说的，太简单的题目
     * 周赛送分题
     *
     * @param word1
     * @param word2
     * @return
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();
        for (String s : word1) {
            w1.append(s);
        }
        for (String s : word2) {
            w2.append(s);
        }
        return w1.toString().equals(w2.toString());
    }
}
