package solution.leetcode.lc_168_excel_sheet_column_title;

public class Solution {
	/*
	 * 分析：参考http://blog.csdn.net/u012162613/article/details/42059591
	 * 
	 * 本质是进制计算，计算26进制，个位数直接对26取余数，更高位则不断除基数26（舍去低位数字）
	 * 
	 * 代码参考：https://discuss.leetcode.com/topic/6248/accepted-java-solution
	 * 这个solution比较聪明的地方在于，计算每位之前，先减一，这样取余数后直接就能得到
	 * 该位对应的字母
	 */
	public String convertToTitle(int n) {
		StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
	
}
