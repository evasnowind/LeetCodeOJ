package solution.offer_problem.p10_i_fibonacci;

public class Solution {


    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int f0 = 0, f1 = 1, res = 0;
        for(int i = 2; i <= n; i++) {
            res = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = res;
        }
        return res;
    }
}
