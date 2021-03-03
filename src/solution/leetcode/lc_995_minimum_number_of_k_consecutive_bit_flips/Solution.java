package solution.leetcode.lc_995_minimum_number_of_k_consecutive_bit_flips;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2021/2/18
 */
public class Solution {

    public int minKBitFlips(int[] A, int K) {
        int len = A.length;

        int res = 0;
        for(int i = 0; i < len - K + 1; i++) {
            if (A[i] == 1) {
                continue;
            }
            for(int j = 0; j < K; j++) {
                A[i+j] = A[i+j] ^ 1;
            }
            res += 1;

        }
        for(int i = 0; i < len; i++) {
            if (A[i] == 0) {
                return -1;
            }
        }
        return res;
    }

    public int minKBitFlips2(int[] A, int K) {
        int len = A.length;
        Deque<Integer> deque = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < len; i++) {
            if (!deque.isEmpty() && deque.getFirst() + K <= i) {
                deque.removeFirst();
            }
            if (deque.size() % 2 == A[i]) {
                if (i + K > len) {
                    return -1;
                }
                deque.offer(i);
                res += 1;
            }
        }
        return res;
    }
}
