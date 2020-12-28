package solution.leetcode.lc_330_patching_array;

/**
 * @author chenglong.yu
 * created on 2020/12/29
 */
public class Solution {
    /**
     * https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
     *
     * 实在想不到咋搞，还是看官方题解吧。
     * 感觉是烧脑数学题，自己是做不出了。
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while(x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}
