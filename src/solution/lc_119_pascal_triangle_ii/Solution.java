package solution.lc_119_pascal_triangle_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/*
	 * 参考地址：https://discuss.leetcode.com/topic/4722/my-accepted-java-solution-any-better-code
	 * 亮点：重复利用了一个数组进行计算，每次计算时开头加一个1，结尾的1不用动，中间的数据不断迭代
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>(rowIndex+1);
		if(rowIndex < 0) return result;
		for(int i = 0; i < rowIndex+1; i++){
			result.add(0,1);
			for(int j = 1; j < result.size()-1; j++){
				result.set(j, result.get(j)+result.get(j+1));
			}
		}
		return result;
    }
}
