package solution.week_competition.w20201122;

/**
 * @author chenglong.yu
 * created on 2020/11/22
 */
public class Solution3 {

    public int waysToMakeFair(int[] nums) {

        int[] tmp = new int[nums.length - 1];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = 0, idx2 = 0;
            while(idx2 < nums.length) {
                if (idx2 == i) {
                    idx2++;
                    continue;
                }
                tmp[idx] = nums[idx2];
                idx++;
                idx2++;
            }
            if (isBalanced(tmp)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isBalanced(int[] nums) {
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1) {
                oddSum += nums[i];
            } else {
                evenSum += nums[i];
            }
        }

        return oddSum == evenSum;
    }


    public int waysToMakeFair2(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isBalanced2(nums, i)) {
                cnt++;
            }
        }
        return cnt;
    }


    private boolean isBalanced2(int[] nums, int idx) {
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == idx) {
                continue;
            } else if (i < idx) {
                if ((i & 1) == 1) {
                    oddSum += nums[i];
                } else {
                    evenSum += nums[i];
                }
            } else if (i > idx) {
                int tmp = i - 1;
                if ((tmp & 1) == 1) {
                    oddSum += nums[i];
                } else {
                    evenSum += nums[i];
                }
            }
        }

        return oddSum == evenSum;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,1,6,4};
        Solution3 s = new Solution3();
        System.out.println(s.waysToMakeFair2(nums));
        nums = new int[]{1,1,1};
        System.out.println(s.waysToMakeFair2(nums));
        nums = new int[]{1,2,3};
        System.out.println(s.waysToMakeFair2(nums));
    }
}
