package solution.leetcode.lc_703_kth_largest_element_in_a_stream;

import java.util.PriorityQueue;

public class KthLargest {

    private int k;
    private PriorityQueue<Integer> priorityQueue;


    /**
     * 经典的Top K问题。
     * 基本思想：使用小顶堆保存总体排序中最大的K个元素。如果有新增元素，则调用堆的add方法，该方法将元素加入堆、
     * 并且保证如果堆的大小大于K，则删掉小顶堆的根节点，而根节点正好就是目前最小的元素。
     *
     * 牢记：
     * 小顶堆：可以用来求当前最大的K个元素，根节点是整个数组中第K大的数
     * 大顶堆：可以用来求当前最小的K个元素，根节点是整个数组中第K小的数
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>();

        for(int num : nums) {
            //此处必须调用add方法，不能直接调用PriorityQueue的offer方法，因为需要判断已经大于k个元素、大于k个则需要删除一个元素
            add(num);
        }
    }


    public int add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

}
