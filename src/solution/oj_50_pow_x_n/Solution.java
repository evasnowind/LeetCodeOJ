package solution.oj_50_pow_x_n;

/**
 * @author chenglong.yu@100credit.com
 * created on 2020/5/11
 */
public class Solution {

    /*
    public double myPow(double x, int n) {
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (0 == n) {
            return 1;
        }
        if (1 == n) {
            return x;
        }
        if (-1 == n) {
            return 1 / x;
        }

        if ((n & 1) == 1) {
            return x * helper(x, n - 1);
        } else {
            return helper(x * x, n / 2);
        }
    }
     */

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (0 == n) {
            return 1;
        }

        if ((n & 1) == 1) {
            return x * helper(x * x, n / 2);
        } else {
            return helper(x * x, n / 2);
        }
    }

    public static void main(String[] args) {


        Solution s = new Solution();

        System.out.println(s.myPow(2.1d, 3));
//        System.out.println(s.myPow(2.0d, -2));
//        System.out.println(s.myPow(2.0d, 10));
//        System.out.println(s.myPow(2.0d, -10));
//        System.out.println(s.myPow(2.0d, -3));
//        System.out.println(s.myPow(2.0d, -1));
//        System.out.println(s.myPow(2.0d, 0));
//        System.out.println(s.myPow(1.0d, 99));
    }
}
