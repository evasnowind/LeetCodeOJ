package solution.oj_201_bitwise_and_of_num_range;

public class Solution {

	/*
	 * 分析：这道题目考察的是对数据的分析、观察能力。从m到n，所有数字相与，
	 * 一个个演算来看，会发现其实这个计算过程的最终结果只保留了[m,n]这个区间
	 * 内所有数字二进制公共的高位部分，而找二进制公共部分实际很简单，代码参见
	 * https://discuss.leetcode.com/topic/12133/bit-operation-solution-java
	 * 
	 * 坦白讲我能想到的是暴力算法、直接循环遍历，还是看了这个帖子才明白为何discuss里
	 * 是这么写，推荐一下：http://www.meetqun.net/thread-8769-1-1.html
	 * 
	 * 而且这篇帖子里也还提到了另一种解法，即运用n&(n-1)能消去n最低位0的做法
	 * 
	public int rangeBitwiseAnd(int m, int n) {
        while(n > m) {
          n = n & (n-1);
        }
        return n;
    }
	 * 
	 */
	public int rangeBitwiseAnd(int m, int n) {
		int cnt = 0;
		while(m != n){
			m >>>= 1;
			n >>>= 1;
			cnt += 1;
		}
		return m << cnt;
    }
}
