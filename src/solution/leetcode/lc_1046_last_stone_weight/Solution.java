package solution.leetcode.lc_1046_last_stone_weight;

import java.util.PriorityQueue;

/**
 * @author chenglong.yu
 * created on 2020/12/30
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
        默认的PriorityQueue是小顶堆，根节点是最小元素。
        而我们目前需要的是最大的两个值，因此需要调整下排序规则。
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }

        while(priorityQueue.size() > 1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            if (a > b) {
                priorityQueue.offer(a - b);
            }//else a = b时，两个石头完全粉碎，不用考虑
        }

        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }
}
