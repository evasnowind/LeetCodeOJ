package solution.interview.sum_1_n;

/**
 * @author chenglong.yu@100credit.com
 * created on 2020/6/2
 */
public class Solution {

    /**
     * 解析参见 https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        //后面 > 0其实没啥意义，主要是为了执行 n+=sumNum 这个操作，因为输入已规定都是正数。
        boolean x = n > 1 && (n += sumNums (n - 1)) > 0;
        return n;
    }
}
