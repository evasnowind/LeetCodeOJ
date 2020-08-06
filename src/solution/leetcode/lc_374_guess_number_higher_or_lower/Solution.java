package solution.leetcode.lc_374_guess_number_higher_or_lower;

public class Solution extends GuessGame{
	/*
	 * 分析：主要是要注意看清题目，guessNumber的用意是猜出某个[1,n]范围内的值，
	 * 		guess仅仅是一个判断函数，那么直接二分查找即可
	 */
	public int guessNumber(int n) {
        int i = 1, j = n;
        while(i < j) {
            int mid = i + (j - i) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
	
}
