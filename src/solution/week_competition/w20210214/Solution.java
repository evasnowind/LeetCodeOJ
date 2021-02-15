package solution.week_competition.w20210214;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenglong.yu
 * created on 2021/2/14
 */
public class Solution {




    public int minimumSize(int[] nums, int maxOperations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            priorityQueue.add(num);
        }

        for(int i = 0; i < maxOperations; i++) {
            int max = priorityQueue.poll();
            int half = max / 2;
            priorityQueue.offer(half);
            priorityQueue.offer(max - half);
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumSize(new int[]{9}, 2));
//        System.out.println(s.minimumSize(new int[]{2,4,8,2}, 4));
//        System.out.println(s.minimumSize(new int[]{7,17}, 4));
    }
}
