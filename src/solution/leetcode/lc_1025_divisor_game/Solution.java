package solution.leetcode.lc_1025_divisor_game;

/**
 * @author chenglong.yu
 * created on 2020/7/24
 */
public class Solution {

    public boolean divisorGame(int N) {


        /*
        最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

选出任一 x，满足 0 < x < N 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。
         */

        //https://leetcode-cn.com/problems/divisor-game/solution/chu-shu-bo-yi-by-leetcode-solution/
        return N%2 == 0;
    }
}
