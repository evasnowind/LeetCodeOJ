package solution.leetcode.lc_239_sliding_window_maximum;

import java.util.ArrayDeque;

/**
 * @author chenglong.yu
 * created on 2020/10/30
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i-1], nums[i]);
            }
            int j = n - i - 1;
            if ((j+1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        return output;
    }


    /**
     * 暴力法
     * 时间O(NK)
     * 空间O(N−k+1)
     * https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] nums;

    public void cleanDeque(int i, int k) {
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            /*
            deque中保存的是索引位置，i-k+1是当前窗口的索引最小值，小于这个值
            则说明索引位置已经从窗口中滑出，需要将该位置清理掉。

            注意，我们在双端队列的队头，一直保持的是当前窗口最大值对应的索引位置。
             */
            deque.removeFirst();
        }

        while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            /*
            排除掉队列中小于当前值nums[i]的值，因为nums[i]马上加入队尾，
            若比nums[i]还小，则不可能是最大值，直接删掉即可。如果deque中的值都比nums[i]小，
            此处的删除实际上会让nums[i]能排到队头。
             */
            deque.removeLast();
        }
    }

    /**
     * 时间O(N) 空间O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        this.nums = nums;
        int maxIdx = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int[] output = new int[n - k + 1];
        output[0] = nums[maxIdx];

        for (int i = k; i < n; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            /*
            由于我们在cleanDeque操作时，删掉了比nums[i]
            小的元素，只保留了比nums[i]大的元素。因此，此处有两种情况：
            1、清理操作后，deque变空，说明在以nums[i]结尾的窗口中，最大值就是nums[i]。通过deque.addLast(i)操作，会将最大值放到队列头部。
            2、清理操作后，deque不为空，说明在以nums[i]结尾的窗口中，还有值比nums[i]大，这个值已经排在了队列头部。
            所以下面直接取出队列头部即为当前滑动窗口的最大值。
             */
            output[i - k + 1] = nums[deque.getFirst()];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        Solution s = new Solution();
        int[] res = s.maxSlidingWindow3(nums, 3);
        System.out.println(res);

    }
}
