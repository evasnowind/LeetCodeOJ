package solution.oj_35_search_insert_position;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int index = -1;
        if (target > nums[end]) {
            return end + 1;
        }
        if (target < nums[start])
            return 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                index = mid;
                break;
            } else if (target > nums[mid]) {
                start = mid + 1;
                if (nums[mid + 1] > target) {
                    index = mid + 1;
                }

            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 1));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
    }
}