package solution.leetcode.lc_973_kclosest_points_to_origin;

import jdk.management.resource.internal.inst.DatagramDispatcherRMHooks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author chenglong.yu
 * created on 2020/11/9
 */
public class Solution {
    /**
     * 虽然计算的是欧几里得距离，但我们只需要判断平方和即可。也因为取平方根之后并不改变结果顺序。
     *
     * 思路1：按平方和排序，然后取前k个小的元素
     *
     *  public int[][] kClosest(int[][] points, int K) {
     *         Arrays.sort(points, new Comparator<int[]>() {
     *             public int compare(int[] point1, int[] point2) {
     *                 return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
     *             }
     *         });
     *         return Arrays.copyOfRange(points, 0, K);
     *     }
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/zui-jie-jin-yuan-dian-de-k-ge-dian-by-leetcode-sol/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 思路2：
     * 与数组中取前k个小的数一样，可以利用大顶堆保存前k个元素，然后遍历k+1个元素，大于根元素则将当前根取出、
     * 加入新元素。
     * 时间O(nlogk) 空间O(k)
     *
     * 思路3：
     * 采用快速排序的思想
     * 空间 O(log n) 时间期望O(n) 最坏O(n^2)
     *
     * 思路3：归并
     *
     * 时间O(n)
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        /*
        题目输入已经保证points K都是有效值，不用判空
         */
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                /*
                java中优先级队列默认是小顶堆，而我们需要使用大顶堆来找出前k小的元素，
                因此这里使用相反数比较，就可以获得大顶堆。
                 */
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < K; i++) {
            priorityQueue.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        for (int i = K; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            /*
            与计算前k个元素的思路一样，当前元素大于当前根，则将根删除、当前元素加入。
             */
            if (dist < priorityQueue.peek()[0]) {
                priorityQueue.poll();
                priorityQueue.offer(new int[]{dist, i});
            }
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[priorityQueue.poll()[1]];
        }
        return res;
    }

    Random rand = new Random();

    public int[][] kClosest2(int[][] points, int K) {
        int n = points.length;
        randomSelect(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void randomSelect(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            randomSelect(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            randomSelect(points, i + 1, right, K - (i - left + 1));
        }
    }


    private void swap(int[][] points, int index1, int index2) {
        int[] tmp = points[index1];
        points[index1] = points[index2];
        points[index2] = tmp;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = new int[][]{{1,3},{-2,2}};
        s.kClosest(points, 1);
    }
}
