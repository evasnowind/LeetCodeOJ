package solution.leetcode.lc_454_four_num_sum_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2020/11/27
 */
public class Solution {

    /**
     * 时间复杂度过高，超时
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;

        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int jSum = A[i] + B[j];
                for (int k = 0; k < len; k++) {
                    int kSum = jSum + C[k];
                    for (int l = 0; l < len; l++) {
                        if (kSum + D[l] == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int cur = A[i] + B[j];
                map.put(cur, map.getOrDefault(cur, 0));
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int cur = -C[i] - D[j];
                if (map.containsKey(cur)) {
                    res += map.get(cur);
                }
            }
        }
        return res;
    }
}
