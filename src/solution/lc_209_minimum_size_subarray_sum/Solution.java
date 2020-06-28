package solution.lc_209_minimum_size_subarray_sum;

/**
 * @author chenglong.yu@brgroup.com
 * created on 2020/6/28
 */
public class Solution {

    /**
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen0(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int start = 0, end = 0, minLen = Integer.MAX_VALUE, sum = 0;
        while(end < nums.length) {
            sum += nums[end];

            while(sum >= s) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start += 1;
            }

            end += 1;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int minLen = s.minSubArrayLen(4, new int[]{1,4,4});
        System.out.println(minLen);
    }
}
