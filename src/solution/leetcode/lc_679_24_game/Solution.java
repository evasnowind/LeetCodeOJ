package solution.leetcode.lc_679_24_game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/8/22
 */
public class Solution {

    private static final int TARGET = 24;
    private static final double EPSILON = 1e-6;
    private static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {

        List<Double> list = new ArrayList<Double>();
        for (int num : nums) {
            list.add((double) num);
        }

        return hasSolution(list);
    }

    public boolean hasSolution(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }

        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //上面的i、j循环保证了能遍历所有元素的组合
                if (i != j) {
                    List<Double> curRes = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        //先将除第i、j个元素的所有其他元素将加入数组中。
                        if (k != i && k != j) {
                            curRes.add(list.get(k));
                        }
                    }

                    //对第i、j个元素分别进行回溯，看两者分别进行四则运算后，是否能满足要求
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        /*
                        注意此处是4次回溯，整体而言就是回溯框架：

                        四则运算后得到第i、j计算结果，加入到list2末尾
                        backtrack(curRes)，看是否已经得到24
                        将list2末尾移除，即去掉第i、j计算结果

                         */
                        if (k == ADD) {
                            curRes.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            curRes.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            curRes.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                curRes.add(list.get(i) / list.get(j));
                            }
                        }
                        //此处的回溯，则能不断向下遍历、使得队列中数字个数逐步变化：4 -> 3 -> 2 -> 1。从而遍历所有可能性。
                        if (hasSolution(curRes)) {
                            return true;
                        }
                        curRes.remove(curRes.size() - 1);
                    }
                }
            }
        }

        return false;
    }

}
