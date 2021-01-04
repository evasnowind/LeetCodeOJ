package solution.leetcode.lc_609_fibonacci_number;

/**
 * @author chenglong.yu
 * created on 2021/1/4
 */
public class Solution {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int f0 = 0, f1 = 1;

        int cur = f1;
        for(int i = 1; i < n; i++) {
            cur = f0 + f1;
            f0 = f1;
            f1 = cur;
        }
        return cur;
    }
}
