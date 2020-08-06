package solution.leetcode.lc_67_add_binary;

public class Solution {
	/*
	 * 思路比较简单，但参考了https://discuss.leetcode.com/topic/13698/short-ac-solution-in-java-with-explanation
	 * 因为这种写法更简洁，可以学习下
	 */
	public String addBinary(String a, String b) {
		if(null == a || a.isEmpty()) return b;
		if(null == b || b.isEmpty()) return a;
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0, sum = 0;
		while(i >= 0 || j >= 0){
			sum = carry;
			if(j >= 0) sum += b.charAt(j--) - '0';
			if(i >= 0) sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if(carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
		if (null == a || a.isEmpty()) {
			return b;
		}
		if (null == b || b.isEmpty()) {
			return a;
		}
		StringBuilder builder = new StringBuilder();

		int sum = 0;
		int carry = 0;
		int i = a.length() - 1, j = b.length() - 1;
		while(i >= 0 || j >= 0) {
			sum = carry;
			if (i >= 0) {
				sum += a.charAt(i) - '0';
				i -= 1;
			}
			if (j >= 0) {
				sum += b.charAt(j) - '0';
				j -= 1;
			}
			builder.append(sum % 2);
			carry = sum / 2;
		}
		if(carry != 0) {
			builder.append(carry);
		}

		//返回最终结果
		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "11", s2 = "1";
		Solution s = new Solution();
		System.out.println(s.addBinary2(s1, s2));

		s1 = "100";
		s2 = "110010";
		System.out.println(s.addBinary2(s1, s2));
	}
}
