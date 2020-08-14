package solution.offer_problem.p10_ii_climb_stairs;

public class Solution {

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }

        /*
        青蛙跳台阶问题： f(0)=1 , f(1)=1 , f(2)=2 ；
        斐波那契数列问题： f(0)=0 , f(1)=1, f(2)=1 。

        作者：jyd
        链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/

         */
        //此处为了减少一次if判断n=2，直接将f2赋值给res。
        int f1 = 1, f2 = 2, res = f2;
        for (int i = 3; i <= n; i++) {
            res = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = res;
        }

        return res;
    }
}
