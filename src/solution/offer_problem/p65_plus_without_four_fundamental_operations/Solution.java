package solution.offer_problem.p65_plus_without_four_fundamental_operations;

/**
 * @author chenglong.yu
 * created on 2020/8/17
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
     *
     * 这个是位运算，参见链接里大神给的分析过程。
     * 算是模拟计算机计算过程。
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {

        if (b == 0) {
            return a;
        }

        return add(a ^ b, (a & b) << 1);
    }
}
