package solution.leetcode.lc_43_multiply_strings;


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
	    for(int p : pos) {
	    	if(!(sb.length() == 0 && p == 0)) {
	    		sb.append(p);
			}
		}
	    return sb.length() == 0 ? "0" : sb.toString();
    }

	/**
	 * 模拟乘法过程（非竖式乘法）
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply2(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		String ans = "0";
		int m = num1.length(), n = num2.length();
		for (int i = n - 1; i >= 0; i--) {
			StringBuilder curMul = new StringBuilder();
			//先加上末尾的补0，因为计算过程中String保存数字是逆序的，reverse操作后这些0就会变成数字末尾的0
			for (int j = n - 1; j > i; j--) {
				curMul.append(0);
			}

			/*
			计算每次的乘法：用被乘数每一位 * 乘数的一位数字，得到的只是1个中间结果。还需要将每个中间结果叠加到一起。
			这里又需要用到字符串加法
			 */
			int carry = 0;
			int y = num2.charAt(i) - '0';
			for (int j = m - 1; j >= 0; j--) {
				int x = num1.charAt(j) - '0';
				int product = x * y + carry;
				curMul.append(product % 10);
				carry = product / 10;
			}
			//避免遗漏最后一次的进位
			if (carry != 0) {
				curMul.append(carry);
			}

			ans = addStrings(ans, curMul.reverse().toString());
		}

		return ans;
	}


	private String addStrings(String num1, String num2) {
		int i = num1.length() - 1, j = num2.length() - 1;
		StringBuilder builder = new StringBuilder();
		int carry = 0;
		//注意此处的进位！通过while条件避免了写一个单独判断，但不要漏掉！
		while(i >= 0 || j >= 0 || carry != 0) {
			int sum = carry;
			if (i >= 0) {
				sum += num1.charAt(i) - '0';
			}
			if (j >= 0) {
				sum += num2.charAt(j) - '0';
			}
			carry = sum / 10;
			builder.append(sum % 10);
			i -= 1;
			j -= 1;
		}

		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "2", s2 = "3";
		Solution s = new Solution();
		System.out.println(s.multiply2(s1, s2));
	}
}
