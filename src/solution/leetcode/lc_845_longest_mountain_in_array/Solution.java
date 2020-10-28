package solution.leetcode.lc_845_longest_mountain_in_array;

/**
 * @author chenglong.yu
 * created on 2020/10/25
 */
public class Solution {

    /**
     * 题目要求的是连续子数组，因此相对简单，
     * 只需要连续判断即可，如果是非连续子数组，
     * 那判断会就复杂一些。
     *
     * @param A
     * @return
     */
    public int longestMountain(int[] A) {
        //长度小于等于2，则不可能出现山
        if (null == A || A.length <= 2) {
            return 0;
        }

        int n = A.length;
        int left = 0;
        int maxLen = 0;
        while(left < n - 2) {
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                //先找到递增数组起始位置
                while(right + 1 < n && A[right] < A[right+1]) {
                    right++;
                }

                if (right < n - 1 && A[right] > A[right+1]) {
                    //接下来找到递减结束位置
                    while(right + 1 < n && A[right] > A[right+1]) {
                        right++;
                    }
                    maxLen = Math.max(maxLen, right - left + 1);

                } else {
                    right++;
                }

            }
            /*
            由于是求连续子数字，一个子数组校验完之后，直接从下一个位置开始，不用考虑历史记录
             */
            left = right;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,4,7,3,2,5};
        Solution s = new Solution();
        int maxLen = s.longestMountain(nums);
        System.out.println(maxLen);
    }
}
