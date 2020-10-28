package solution.leetcode.lc_1365_how_many_numbers_are_smaller_than_current_number;

/**
 * @author chenglong.yu
 * created on 2020/10/26
 */
public class Solution {

    /**
     *
     * 思路1：暴力，双重循环，比较每个元素
     * 时间：n^2
     *
     * 思路2：快排，需要额外
     * 时间：nlgn 空间：需要额外保存排序后的结果n，且需要一个数组保存结果，2个n，但还是n
     *
     * 思路3：计数排序
     * 输入数组的值的围很小，0<=x<=100，可以用计数排序统计频次
     *
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //统计数组中每个值出现次数
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            /*
            重复利用cnt数组，叠加，cnt[i+1]得到的是
            比nums[i]数值更小的个数。因为我们在统计时，cnt[i]
            里保存的是nums[i]出现次数。那比nums[i]更小的
            数值个数，就是cnt[0]+cnt[1]+...+cnt[i-1]。
            nums[i]=0时，小于0的个数必然为0；
            nums[i]>0时，小于nums[i]个数=cnt[nums[i]-1]
             */
            cnt[i] = cnt[i] + cnt[i-1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return res;
    }
}
