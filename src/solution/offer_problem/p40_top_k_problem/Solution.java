package solution.offer_problem.p40_top_k_problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author chenglong.yu
 * created on 2020/10/21
 */
public class Solution {


    /**
     * 参见
     * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/
     *
     * 经典题目
     * 解法1：排序
     * 时间nlogn  空间logn （用于排序）
     *
     * 解法2：使用大顶堆
     * 时间nlogk 大顶堆每次插入删除都是logk的时间复杂度，最坏情况n个节点都要插入，因此nlogk
     * 空间k，大顶堆所需的空间
     *
     * 解法3：借鉴快排思想
     *
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            res[i] = arr[i];
        }
        return res;
    }


    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        if (0 == k) {
            return res;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                /*
                从大到小排序
                PriorityQueue内部采用堆实现，从大到小排序即可获得一个大顶堆。
                 */
                return num2 - num1;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                /*
                大顶堆：每个根都要大于左右孩子
                根是最大值，比根小，则需要入队、把根剔除，然后调整队列内部、保证符合大顶堆的特性。
                幸好PriorityQueue自己就支持, poll()方法每次只从队列头、即根节点删除一个元素。
                 */
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    public void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
