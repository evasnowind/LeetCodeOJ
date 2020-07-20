package solution.lc_945_minIncreasement;

import java.util.*;

/**
 * @author chenglong.yu
 * created on 2020/3/22
 */
public class Solution {

    /**
     * 方法1：
     * 排序后，从头开始遍历，如果遇到相邻元素值相同的情况，则将其中一个往前先挪1步，继续往下走，如果挪了一步后，下一个刚好值
     * 还是相同，则还是需要往前挪一步。不断重复，其实也就是模拟某个元素从较低的值一步步挪动1、看是否还有重复，直到保证没有重复的位置
     *
     * 方法2：
     * 此处没有实现，思路类似：排序后，统计不同元素的个数，只有元素值个数大于1的，才需要挪动，然后分别挪动这些值，直至没有重复数字
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        // 先排序
        Arrays.sort(A);
        int move = 0;
        // 遍历数组，若当前元素小于等于它的前一个元素，则将其变为前一个数+1
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                move += A[i] - pre;
            }
        }
        return move;
    }
}
