package solution.offer_problem.p56_single_number_ii;

/**
 * @author chenglong.yu
 * created on 2020/10/5
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/javashi-xian-jian-zhi-si-lu-wei-yun-suan-zhu-wei-t/
     *
     * 解析参照上面
     *
     * 总体而言，不能利用异或来做，因为3个数字异或后还是自己。
     * 换一种思路：统计每个二进制位的位数和，保存成一个数组。
     * 然后每一位判断：
     * - 若该位上是3的倍数，则只出现一次的数字在该位上是0；
     * - 若该位上不是3的倍数，则只出现一次的数字在该位上是1。
     *
     * 这样就可以利用这个数组，通过移位、加上每位的二进制数，来拼出所求数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        //java int类型有32位，其中首位为符号位
        int[] bitNums = new int[32];
        int res = 0;
        for (int num : nums) {
            int bitMask = 1;
            for (int i = 31; i >= 0; i--) {
                //这里同样可以通过num的无符号右移>>>来实现，否则带符号右移(>>)左侧会补符号位，对于负数会出错。
                //但是不推荐这样做，最好不要修改原数组nums的数据
                if ((num & bitMask) != 0) {
                    bitNums[i]++;
                }
                //左移没有无符号、带符号的区别，都是在右侧补0
                bitMask = bitMask << 1;
            }
        }
        //上面循环结束后，bitNums中保存了整个数组、每个整数二进制位相加的结果。
        for (int i = 0; i < 32; i++) {
            //这种做法使得本算法同样适用于负数的情况，注意下面两条语句顺序不能变
            res = res << 1;
            res += bitNums[i] % 3;
        }

        return res;
    }

}
