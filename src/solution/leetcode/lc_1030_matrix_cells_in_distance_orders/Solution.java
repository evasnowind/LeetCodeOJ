package solution.leetcode.lc_1030_matrix_cells_in_distance_orders;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/11/17
 */
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<int[]> resArr = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                resArr.add(new int[]{i, j});
            }
        }

        resArr.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int distance1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
                int distance2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
                return distance1 - distance2;
            }
        });

        int len = R * C;
        int[][] res = new int[len][2];
        int idx = 0;
        for (int[] point : resArr) {
            res[idx][0] = point[0];
            res[idx][1] = point[1];
            idx++;
        }
        return res;
    }


    private int computeDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    /**
     * 桶排序
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {

        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            //创建好空的桶
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = computeDist(r0, c0, i, j);
                bucket.get(d).add(new int[]{i, j});
            }
        }

        int[][] res = new int[R * C][2];
        int idx = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] b : bucket.get(i)) {
                res[idx++] = b;
            }
        }
        return res;
    }
}
