package solution.leetcode.lc_724_pivot_index;

/**
 * @author chenglong.yu
 * created on 2020/7/25
 */
public class Solution {


    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int idx = s.pivotIndex(new int[]{1,7,3,6,5,6});
//        System.out.println(idx);
        int idx = s.pivotIndex(new int[]{-1,-1,-1,0,1,1});
        System.out.println(idx);
    }
}
