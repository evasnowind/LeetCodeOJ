package oj_solution.oj_127_word_ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	/*
	 * 分析：非常经典的一道有关BFS的题目。坦白说我想了半天只能想到很暴力的做法，没想到用BFS。
	 * 参考了如下帖子：
	 * https://discuss.leetcode.com/topic/17890/another-accepted-java-solution-bfs
	 * 这个帖子的BFS实现很典型，具体参见注释（思路其实和按层遍历一样，都是利用一个队列作为遍历依据，
	 * 此处的实现在队列中加入null，以便区分算出距离——按层遍历则用于区分不同层，道理是一样的）。
	 * 
	 * 其他实现：
	 * https://discuss.leetcode.com/topic/20965/java-solution-using-dijkstra-s-algorithm-with-explanation
	 * 
	 * 双向BFS（不断切换找的方向，每次都从节点少的那个方向开始找）
	 * https://discuss.leetcode.com/topic/29303/two-end-bfs-in-java-31ms
	 * 
	 * Dijkstra算法
	 * https://discuss.leetcode.com/topic/20965/java-solution-using-dijkstra-s-algorithm-with-explanation
	 */
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		queue.add(null);
		
		Set<String> visited = new HashSet<String>();
		visited.add(beginWord);
		
		int level = 1;
		
		while(!queue.isEmpty()){
			String str = queue.poll();
			if(null != str){
				char[] chs = str.toCharArray();
				for(int i = 0; i < chs.length; i++){
					char originCh = chs[i];
					//第i位变换26次，看是否能走到下一个word
					for(int j = 0; j < 26; j++){
						char changed = (char) ('a'+j);
						chs[i] = changed;
						String nextWord = new String(chs);
						if(nextWord.equals(endWord)){
							return level+1;
						}
						if(wordList.contains(nextWord) && !visited.contains(nextWord)){
							//加入队列，遍历下一层次
							visited.add(nextWord);
							queue.add(nextWord);
						}
					}
					chs[i] = originCh;
				}
			} else {
				level += 1;
				//遍历到null，说明已经遍历完一层，queue没空说明没遍历完，queue还会有新元素加入，
				//为了区分不同层加入一个null
				if(!queue.isEmpty()){
					queue.add(null);
				}
			}
		}
		return 0;
	}
}
