package solution.offer_problem.p49_ugly_number;

/**
 * @author chenglong.yu
 * created on 2020/11/18
 */
public class Solution {
    /**
     * 实际上还是遍历所有过程、得到最终的结果。
     * 而这可以通过DP的思想进行优化。此处就是通过记忆
     * 已有的结果、简化下一个解的计算。
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] data = new int[1690];
        data[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < data.length; i++) {

            int min = Math.min(Math.min(data[i2] * 2, data[i3] * 3), data[i5] * 5);
            data[i] = min;
            /*
            注意：此处通过i2 i3 i5都判断、做了去重操作。
            因为data[x] * 2/3/5可能会出现重复数字。也就不能单纯的if else，必须是if if if并列的形式。

             */
            if (min == data[i2] * 2) {
                i2++;
            }
            if (min == data[i3] * 3) {
                i3++;
            }
            if (min == data[i5] * 5){
                i5++;
            }
        }

        return data[n-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.nthUglyNumber(10);

    }
}
