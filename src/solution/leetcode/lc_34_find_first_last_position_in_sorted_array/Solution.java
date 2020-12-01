package solution.leetcode.lc_34_find_first_last_position_in_sorted_array;

/**
 * @author chenglong.yu
 * created on 2020/12/1
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return new int[]{-1, -1};
        }


        int low = 0, high = nums.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (low == nums.length || nums[high] != target) {
            return new int[]{-1, -1};
        }

        int start = high, end = high;
        while(end < nums.length && nums[end] == target) {
            end++;
        }

        return new int[]{start, end-1};

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,2,3,4,5};
        int target = 2;
        int[] res = null;
//        res = s.searchRange(nums, target);
//        System.out.println(res);
        nums = new int[]{5,7,7,8,8,10};
//        target = 8;
//        res = s.searchRange(nums, target);
//        target = 6;
//        res = s.searchRange(nums, target);
//        System.out.println(res);
        nums = new int[]{1};
        target = 1;
        res = s.searchRange(nums, target);
        System.out.println(res);
    }
}
