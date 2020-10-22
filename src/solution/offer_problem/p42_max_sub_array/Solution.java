package solution.offer_problem.p42_max_sub_array;

import java.sql.PreparedStatement;

/**
 * @author chenglong.yu
 * created on 2020/10/22
 */
public class Solution {
    /**
     * 求最值问题，可以考虑动态规划。
     * 设动态规划列表 dp ，dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和
     *  为何定义最大和 dp[i] 中必须包含元素 nums[i] ：保证 dp[i] 递推到 dp[i+1] 的正确性；如果不包含 nums[i]，递推时则不满足题目的 连续子数组 要求。
     * 当 dp[i - 1] > 0时：执行 dp[i] = dp[i-1] + nums[i]；
     * 当 dp[i−1] ≤ 0 时：执行 dp[i] = nums[i] ；
     * 初始：dp[0] = nums[0]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = 0;
        if (null == nums || nums.length == 0) {
            return res;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int res = 0;
        if (null == nums || nums.length == 0) {
            return res;
        }

        //由于本题中，并不需要保存所有的DP结果，我们每次只需要保存上次计算结果即可，因此可以省去dp数组
        int lastDP = nums[0];
        res = nums[0];
        /*
        此处for循环起点很重要，我个人是比较喜欢res=nums[0]，然后从1开始遍历。
        这样的话就可以包含以下边界情况：
        1、数组只有一个元素的情况
        2、避免从0开始时，lastDP手工置为0可能导致的bug，比如说数组若都是负数，那么容易写错。即lastDP=0, i=0开始，循环体内若处理不当，
        将得到错误的解
         */
        for (int i = 1; i < nums.length; i++) {
            if (lastDP > 0) {
                lastDP = lastDP + nums[i];
            } else {
                lastDP = nums[i];
            }
            res = Math.max(lastDP, res);

        }
        return res;
    }

    /**
     * 参见
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
     *
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        //重用nums数组，但我个人不太喜欢这种，因为这破坏了输入
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            //利用Math.max代替了if 判断
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        Solution s = new Solution();
        int max = s.maxSubArray2(nums);
        System.out.println(max);
        max = s.maxSubArray2(new int[]{-1});
        System.out.println(max);
        max = s.maxSubArray2(new int[]{-2, -1});
        System.out.println(max);
    }
}
