package solution.offer_problem.p15_number_of_1_bits;

/**
 * @author chenglong.yu
 * created on 2020/10/5
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5, res = 0;
        res = s.hammingWeight(n);
        System.out.println(res);
        n = 4;
        res = s.hammingWeight(n);
        System.out.println(res);
    }
}
