package solution.lc_171_excel_sheet_column_number;

public class Solution {
	/*
	 * 思路：参考OJ 168，题目类似，其问题实质都进制问题，
	 *		本题是将字母转成数字 
	 */
	public int titleToNumber(String s) {
		if(null == s) return 0;
		int res = 0;
		for(char ch : s.toCharArray()){
			res = res * 26 + (ch - 'A' + 1);
		}
		return res;
    }
}
