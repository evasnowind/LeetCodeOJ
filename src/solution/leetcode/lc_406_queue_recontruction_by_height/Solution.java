package solution.leetcode.lc_406_queue_recontruction_by_height;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/7
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode/
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                /*
                题目很费解、只能从题解入手了……
                看样子是先按身高逆序、然后按索引值顺序
                 */
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }

}
