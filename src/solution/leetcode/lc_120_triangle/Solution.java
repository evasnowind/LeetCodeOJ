package solution.leetcode.lc_120_triangle;

import java.util.List;

public class Solution {
	/*
	 * 分析：问题本身比较容易看出具有最优子结构，即最优解包含子问题的最优解，
	 * 		那么狠明显应该使用动态规划来求解，但按照一般思路，从第一个元素开始往下
	 * 		遍历，需要一个m*n的矩阵来记录中间过程，最后扫描最后一行找到最优解。
	 * 		题目要求尽量用O(n)空间，则参考https://discuss.leetcode.com/topic/1669/dp-solution-for-triangle
	 * 		可以考虑从最底层开始向上遍历，此时每次需要更新第k行的一个数据，
	 * 		只需要第k+1的两个数据，并且每次更新只需要更新一个数据（利用minpath[k+1][i], minpath[k+1][i+1]
	 * 		更新minpath[k][i]，都是第i个位置，不影响第i+1个位置），使得重复利用minpath成为
	 * 		可能，因此有了如下算法
	 * 			For the kth level:
					minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i]; 
	 *		反之，如果从上往下遍历，那么更新minpath[k+1]后，并不一定得到最优解，
	 *		必须算出最后一行整行的值才能知道哪个最小，计算过程中利用第k行算第k+1行时，
	 *		第k+1行每个数字需要第k行2个数据，没法用一个一维数组重复保存结果
	 *			
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		if(null == triangle || 0 == triangle.size()) return 0;
		for(int layer = triangle.size() - 2; layer >= 0; layer--){
			for(int j = 0; j <= layer; j++){
				triangle.get(layer).set(j, triangle.get(layer).get(j) + Math.min(triangle.get(layer+1).get(j), triangle.get(layer+1).get(j+1)));
			}
		}
		return triangle.get(0).get(0);
    }
    
    public int minimumTotal2(List<List<Integer>> triangle) {
		if (null == triangle || triangle.size() == 0) {
			return 0;
		}

		int n = triangle.size();
		int[] memo = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				memo[j] = Math.min(memo[j], memo[j+1]) + triangle.get(i).get(j);
			}
		}
		return memo[0];
	}
}
