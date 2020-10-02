package solution.leetcode.lc_581_shortest_unsorted_continuous_subarray;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/9/16
 */
public class Solution {

    /**
     * 思路1：
     * 拷贝数组，将拷贝后的数据排序，然后与原数组比较，找到两者不一致的长度，直接返回
     * 时间O(nlogn) 空间O(n)
     *
     * 思路2：
     * 使用栈，顺序遍历找到左边界，逆序遍历找到右边界
     *
     * 思路3：
     * 不使用额外的空间
     * 无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
     *
     * 因此，首先我们需要找到原数组在哪个位置开始不是升序的。我们从头开始遍历数组，一旦遇到降序的元素，我们记录最小元素为 minmin 。
     *
     * 类似的，我们逆序扫描数组 numsnums，当数组出现升序的时候，我们记录最大元素为 maxmax。
     *
     * 然后，我们再次遍历 numsnums 数组并通过与其他元素进行比较，来找到 minmin 和 maxmax 在原数组中的正确位置。我们只需要从头开始找到第一个大于 minmin 的元素，从尾开始找到第一个小于 maxmax 的元素，它们之间就是最短无序子数组。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        /*
        更优雅一些的依靠排序实现的逻辑：
         public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

作者：LeetCode
链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

         */
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);

        int start = 0, cur = 0;
        boolean first = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copyNums[i]) {
                cur = i;
                if (!first) {
                    first = true;
                    start = i;
                }
            }
        }

        /*
        当输入数组直接就是有序数组时，用first来判断，避免因为cur-start+1返回1的情况
         */
        return !first ? 0 : cur - start + 1;
    }


    public int findUnsortedSubarray2(int[] nums) {
        //使用栈的思路：时间O(N) 空间O(N)
        Deque<Integer> stack = new LinkedList<>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    public int findUnsortedSubarray3(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        Solution s = new Solution();
        s.findUnsortedSubarray(nums);
    }
}
