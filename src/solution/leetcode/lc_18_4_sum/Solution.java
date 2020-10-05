package solution.leetcode.lc_18_4_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/10/5
 */
public class Solution {

    /**
     * 分析参见 https://leetcode-cn.com/problems/4sum/solution/si-shu-zhi-he-by-leetcode-solution/
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();

        if (null == nums || nums.length < 4) {
            return quadruplets;
        }

        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                //重复元素，需要跳过，保证结果不重
                continue;
            }

            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                /*
                剪枝：最小的4个元素相加若都大于target，则必然没有解，直接结束即可。
                由于在最外层循环中已经加入了 i < nums.length-3的条件，因而此处
                的索引必然满足条件、不用担心越界
                 */
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                /*
                剪枝：当前元素 + 最大的3个元素仍然不能满足条件，需要i+1
                 */
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    /*
                    剪枝：与上面类似，去掉重复数据
                     */
                    continue;
                }
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                    /*
                    剪枝：最小的几个元素和仍大于target，则必然不会有解，直接跳出当前循环
                     */
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    /*
                    剪枝：当前的2个元素（i,j）+最大的两个元素值仍小于target，进入下次循环，挪动j
                     */
                    continue;
                }

                int left = j + 1, right = length - 1;
                while(left < right) {
                    int curSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (curSum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) {
                            //去重
                            left++;
                        }
                        //继续循环，寻找在当前i, j前提下，下一个能满足target的left right
                        left++;
                        while(left < right && nums[right] == nums[right - 1]) {
                            //去重
                            right--;
                        }
                        //继续循环，寻找在当前i, j前提下，下一个能满足target的left right
                        right--;
                    } else if (curSum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return quadruplets;
    }
}
