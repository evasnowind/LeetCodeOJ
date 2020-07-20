package solution.lc_292_nim_game;

public class Solution {
	/*
	 * 分析参见https://discuss.leetcode.com/topic/26999/theorem-all-4s-shall-be-false
	 * https://discuss.leetcode.com/topic/27109/one-line-o-1-solution-and-explanation
	 */
	public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
