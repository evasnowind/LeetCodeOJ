package solution.oj_43_multiply_strings;


public class Solution {
	/*
	 * https://leetcode.com/problems/multiply-strings/?tab=Description
	 * 
	 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
	 * 
	 * 基本思路：直接模拟乘法操作，算法容易实现，但有些繁琐
	 * 进一步优化：参考https://discuss.leetcode.com/topic/49709/share-my-c-solution-easy-to-understand
	 * 再一步优化：如下面代码，来自 https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation/2
	 */
	public String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
	    int[] pos = new int[m + n];
	   
	    for(int i = m - 1; i >= 0; i--) {
	        for(int j = n - 1; j >= 0; j--) {
	            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
	            int p1 = i + j, p2 = i + j + 1;
	            int sum = mul + pos[p2];

	            pos[p1] += sum / 10;
	            pos[p2] = (sum) % 10;
	        }
	    }  
	    
	    StringBuilder sb = new StringBuilder();
	    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
	    return sb.length() == 0 ? "0" : sb.toString();
    }
}
