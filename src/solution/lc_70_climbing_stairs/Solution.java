package solution.oj_70_climbing_stairs;

public class Solution {
	/*
	 * climbStairs(n) = climbStairs(n-1)+climbStairs(n-2);
	 * 
	 * n>2时是菲波那切数列，但递归算法会超时，因此需要采用非递归写法
	 * 
	 * 思路：基本算法题都要按照题目要求，自己走一遍，这道题很明显是递归思路，
	 * 但递归写出后直接超时，然后就得思考如何优化（此处是没有记录中间结果，所以
	 * 递归算起来慢，因此用空间换时间）
	 * 
	 */
	public int climbStairs(int n) {
		if(0 >= n) {
			return 0;
		} else if(1 == n){
			return 1;
		} else if(2 == n) {
			return 2;
		} else {
			int [] tmpResult = new int[n];
			tmpResult[0] = 1; 
			tmpResult[1] = 2;
			for(int i = 2; i < n; i++){
				tmpResult[i] = tmpResult[i-1]+tmpResult[i-2];
			}
			return tmpResult[n-1];
		}
    }
	
	/*
	 * 更简单的写法如下（来自leetcode discuss），相比之下，上面的
	 * 写法容易出现内存问题：
	public int climbStairs(int n) {
	    // base cases
	    if(n <= 0) return 0;
	    if(n == 1) return 1;
	    if(n == 2) return 2;
	    
	    int one_step_before = 2;
	    int two_steps_before = 1;
	    int all_ways = 0;
	    
	    for(int i=2; i<n; i++){
	    	all_ways = one_step_before + two_steps_before;
	    	two_steps_before = one_step_before;
	        one_step_before = all_ways;
	    }
	    return all_ways;
	}
	*/
}