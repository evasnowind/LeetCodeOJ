package solution.leetcode.lc_75_sort_colors;

/**
 * @author chenglong.yu
 * created on 2020/9/7
 */
public class Solution {
    public void sortColors(int[] nums) {
        int rCnt = 0, wCnt = 0, bCnt = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    rCnt += 1;
                    break;
                case 1:
                    wCnt += 1;
                    break;
                case 2:
                    bCnt += 1;
                    break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < rCnt) {
                nums[i] = 0;
            } else if (i >= rCnt && i < (rCnt + wCnt)) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    /**
     * 分析参见
     * https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode/
     *
     * 实际上是左右指针逐步向中间夹逼的思路。
     * 双指针。
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        int left = 0, right = nums.length - 1, cur = 0;
        while(cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur, left);
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
                right--;
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2,0,2,1,1,0};
//        int[] nums = new int[]{1,0,2};
        s.sortColors2(nums);
        for (int n : nums) {
            System.out.println(n);
        }

    }
}
