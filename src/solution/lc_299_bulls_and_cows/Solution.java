package solution.lc_299_bulls_and_cows;

public class Solution {
	/*
	 * 参考：https://discuss.leetcode.com/topic/38600/my-3ms-java-solution-may-help-u/2
	 * 思路直白，很容易想到用数组计数（空间换时间）统计cow的出现次数，但需要注意有重复数的情况，
	 * 比如题目给出的
	 * 	
	 * Secret number:  "1123"
		Friend's guess: "0111"
		
		1出现多次，此时以最少此时为准，避免多次重复，以便符合题目要求
	 */
	public String getHint(String secret, String guess) {
		int bull  = 0;
		int cow = 0;
		int len = secret.length();
		int[] secretArr = new int[10];
		int[] guessArr = new int[10];
		for(int i = 0; i < len; i++){
			if(secret.charAt(i) == guess.charAt(i)){
				++bull;
			}else{
				++secretArr[secret.charAt(i)-'0'];
				++guessArr[guess.charAt(i)-'0'];
			}
		}
		for(int i = 0; i < 10; i++){
			cow += Math.min(secretArr[i], guessArr[i]);
		}
		return "" + bull + "A" + cow + "B";
    }
}
