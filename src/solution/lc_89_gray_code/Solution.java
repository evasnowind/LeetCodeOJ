package solution.oj_89_gray_code;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/*
	 * gray code详细解释参见https://en.wikipedia.org/wiki/Gray_code
	 * 需要多举几个例子，n=1、n=2、n=3都列出来，比对，仔细观察会发现有
	 * 一个对称关系，如n=2时，
	 * 00
	 * 01
	 * 11
	 * 10
	 * 第3个是在第2个基础上加了一个10、第4个是在第1个基础上加了10，详情参考https://en.wikipedia.org/wiki/Gray_code
	 * 本人是参考了https://discuss.leetcode.com/topic/1011/what-is-the-best-solution-for-gray-code-problem-no-extra-space-used-and-no-recursion/3
	 * 之后，去看了wikipedia解释才明白这个规律，有点难
	 * 另一个规律：G(i)= i ^ (i>>1) 在wikipedia上有给出，具体原理尚未深究
	 * 
	 */
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		for(int i = 0; i < n; i++){
			int inc = 1 << i;
			for(int j = res.size() - 1; j >= 0; j--){
				res.add(res.get(j) + inc);
			}
		}
		return res;
    }
}
