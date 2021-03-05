package solution.interview.sum_3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenglong.yu
 * created on 2021/2/25
 */
public class Test2 {


    public static void main(String[] args) {
        //最大乘积，有负数，3个
    }

    public static int maxMul(int[] arr) {
        //1. 暴力


        //2. 拆解
        //优先级队列 最大， 最小
        //最大3个数
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(3);


        PriorityQueue<Integer> minQueue = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int num : arr) {
            minQueue.offer(num);
            maxQueue.offer(num);
        }


        //比较，找出最值
        int min1 = minQueue.poll();
        int min2 = minQueue.poll();
        int max1 = maxQueue.poll();
        int max2 = maxQueue.poll();
        int max3 = maxQueue.poll();
        int max4 = Math.max(max3, Math.max(max1, max2));
        return Math.max(max3 * max2 * max1, max4 * min1 * min2);
    }
}
