package solution.leetcode.lc_496_next_greater_number;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/10/29
 */
public class Solution {

    /**

     单调栈算法模板
     vector<int> nextGreaterElement(vector<int>& nums) {
         vector<int> res(nums.size()); // 存放答案的数组
         stack<int> s;
         // 倒着往栈里放
         for (int i = nums.size() - 1; i >= 0; i--) {
             // 判定个子高矮
             while (!s.empty() && s.top() <= nums[i]) {
                 // 矮个起开，反正也被挡着了。。。
                 s.pop();
             }
             // nums[i] 身后的 next great number
             res[i] = s.empty() ? -1 : s.top();
             //
             s.push(nums[i]);
         }
         return res;
     }

     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (null == nums1 || nums1.length == 0) {
            return nums1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            //从后往前走，找到比自己大的、数组后面的元素。保证栈中知会比当前元素nums2[i]要大，或是为空
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            int cur = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], cur);
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
