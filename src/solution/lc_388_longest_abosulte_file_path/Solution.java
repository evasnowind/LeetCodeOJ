package solution.lc_388_longest_abosulte_file_path;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	/*
	 * 注：本题我个人是没想到任何解法，下面代码取自https://discuss.leetcode.com/topic/55247/9-lines-4ms-java-solution
	 * 		此处给出我的一些分析
	 * 分析：实际是一个穷举的过程，走完所有路径、算出每条路径的长度。其中，对于同级子目录/文件而言，
	 * 		父级路径是公共的，不需要重复计算，可以在第一次算出后记下来，供后续使用。关键就是如何分层记录
	 * 		父级路径长度、如何算出同级所有子目录/文件长度。这里可以用一个数组，或是一个栈，保存当前
	 * 		已经算出的父级路径长度。以下面算法为例，用数组保存，只需要知道最深层数即可，但最深层数
	 * 		一开始并不容易算出，因此用栈更好一些。下面算法的数组实现（参见上面的链接）用最后一个\n算出，
	 * 		我个人推测是依据\n后面跟的\t个数来算最深层数，但这个算法应该是错误的，因为最后一行并不一定是
	 * 		最深的那一行，用栈实现更保险。
	 * 		继续分析，用栈保存，栈每层数字代表的是每层对应的父路径长度，第一次是dir，没有父路径，因此需要
	 * 		先置入0；栈高度即当前遍历到的深度（从1开始计数，dir是第1层）。根据\n进行split后所得字符串s，
	 * 		其开头都是\t，\t个数就代表了深度，并且已经按照先父后子的顺序排好，因此先算父亲，算完其所有后代
	 * 		后弹出该父亲，再算下一个即可，直至遍历完毕。
	 * 		注：栈高度即当前遍历到的深度（从1开始计数，dir是第1层），因此\t个数需要加1，才表示对应应该在栈中
	 * 		的位置，比如\tsubdir1，只有一个\t，是第2层，lev=0，因此要加lev+1才能使父亲路径在栈顶
	 * 		
	 */
	public int lengthLongestPath(String input) {
		Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            while(lev+1<stack.size()) stack.pop(); // find parent
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1); 
        }
        return maxLen;
    }
}
