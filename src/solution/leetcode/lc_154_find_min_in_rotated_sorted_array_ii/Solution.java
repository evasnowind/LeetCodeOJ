package solution.leetcode.lc_154_find_min_in_rotated_sorted_array_ii;

/**
 * @author chenglong.yu
 * created on 2020/7/22
 */
public class Solution {


    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                //说明当前mid在左半边，比right元素要高，可以忽略左边。搜索区间[mid+1, high]
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                //说明当前mid在右半边，比right元素要低，需要忽视右边，搜索区间 [low, mid]
                //错误写法：right = mid - 1 为何？
                right = mid;
            } else if (nums[mid] == nums[right]) {
                /*
                可能出现多个相等元素的情况，此时不一定mid就是解，可能刚好mid right相等、但最小值还比他们小。
                此时可以忽略right，往左边挪动一下
                 */
                right = right - 1;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.findMin(new int[]{3,1,3});
    }
}
