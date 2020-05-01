package solution.oj_134_gas_station;

public class Solution {
	/*
	 * 参考：https://discuss.leetcode.com/topic/8860/fully-commented-o-n-c-solution-enabled-by-a-single-observation-of-mine/2
	 * 
	 * 基本算法：按照题目意思，一般思路需要双重循环，需要试验每个加油站
	 * 是否可以走一次环路，此时时间复杂度为O(n2)，但通过分析，有如下结论：
	 * 若从A站无法到达B站，则A与B之间的任何一站都没法到达B站。
	 * 证明：
	 * 		假设可以到达
	 * 		if 存在k，A可以到达k
	 * 		then A可以到达B，与假设矛盾，因此不可以到达
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(null == gas || gas.length <= 0 
				|| null == cost || cost.length <= 0){
			return -1;
		}
		int leftGas;
		int j = 0;
		for(int i = 0; i < gas.length; i+=j){
			leftGas = 0;
			for(j = 1; j <= gas.length; j++){
				int k = (i + j - 1) % gas.length;
				leftGas += gas[k] - cost[k];
				if(leftGas < 0){
					break;
				}
			}
			if(j > gas.length){
				return i;
			}
		}
        return -1;
    }
}
