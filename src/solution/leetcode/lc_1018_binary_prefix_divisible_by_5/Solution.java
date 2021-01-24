package solution.leetcode.lc_1018_binary_prefix_divisible_by_5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2021/1/14
 */
public class Solution {
    /**
     * 简单题目，题目本身看上去只需要每次计算出二进制数对应的数字、
     * 然后看该数字是否能被5整除就可以，但此处隐含的边界条件是大整数，
     * 二进制位数最大可以到30000，那就不能考虑一个变量存这个数。
     *
     * 换种思路，由于只是判断是否能被5整除，那影响因素其实只是这个数的
     * 被5取余后的余数。比如说，10（1010），能被5整除，余数为0。
     * 如果后面再追加一个0，即原数*2；
     * 如果后面再追加一个1，即原数*2+1；
     * 再结合能被5整除的条件：末尾必须是0或者5。
     *
     * 实际上这就意味着只需要关心每次追加数字后的余数变化即可。
     *
     * @param A
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> res = new ArrayList<>();
        int curRemain = 0;
        for(int i = 0; i < A.length; i++) {
            /*
            获得当前的余数，能被5整除则说明找到一个解。
            此外，当前余数需要保留，以便计算下一个数的余数。
            数字变化可以参考状态图。
             */
            curRemain = (curRemain * 2 + A[i]) % 5;
            if (curRemain == 0) {
                res.add(Boolean.TRUE);
            } else {
                res.add(Boolean.FALSE);
            }
        }
        return res;
    }

}
