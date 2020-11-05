package solution.leetcode.lc_127_word_ladder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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


	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		//
		Set<String> wordSet = new HashSet<>(wordList);
		if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
			return 0;
		}
		//将beginWord删除，因为我们要从这个点出发开始搜索。
		wordSet.remove(beginWord);

		//套用BFS遍历模板
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		int step = 1;
		while(!queue.isEmpty()) {
			/*
			拿到当前层的元素数量，以便在BFS遍历中区分不同层，
			每深入一层，step+1，以便保存最终的距离是多少
			 */
			int currentSize = queue.size();
			for (int i = 0; i < currentSize; i++) {
				/*
				BFS模板也就这个地方需要根据具体题目调整广度遍历的方式。
				比如此处需要根据调整一个单词中的每个字母，看是否能找到
				下一个单词刚好就是endWord的情况。若是则说明找到结果，直接
				返回；如果不是endWord、但下一个包含在wordSet中，说明还需要继续BFS，
				因而加入队列中。
				将这个过程单独封装，即可得到下面changeWordEveryOneLetter方法
				 */
				String currentWord = queue.poll();
				if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
					/*
					此处通过BFS，只要找到，就说明路径是最短的。
					 */
					return step + 1;
				}
			}
			step++;
		}
		return 0;
	}

	private boolean changeWordEveryOneLetter(String currentWord, String endWord,
											 Queue<String> queue, Set<String> visited, Set<String> wordSet) {
		char[] charArray = currentWord.toCharArray();
		for (int i = 0; i < endWord.length(); i++) {
			char originChar = charArray[i];
			for (char k = 'a'; k <= 'z'; k++) {
				if (k == originChar) {
					continue;
				}
				charArray[i] = k;
				String nextWord = String.valueOf(charArray);
				if (wordSet.contains(nextWord)) {
					if (nextWord.equals(endWord)) {
						return true;
					}
					if (!visited.contains(nextWord)) {
						queue.add(nextWord);
						visited.add(nextWord);
					}
				}
			}
			charArray[i] = originChar;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int len = s.ladderLength2("hot", "dog", Arrays.asList("dog", "hot"));
		System.out.println(len);
	}


	/**
	 * 双向广度优先遍历
	 *
	 * 实际上就是对上述思路的优化，两边都看，哪边需要遍历的节点少，就从哪边开始
	 *
	 作者：liweiwei1419
	 链接：https://leetcode-cn.com/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/
	 来源：力扣（LeetCode）
	 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
		// 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
		Set<String> wordSet = new HashSet<>(wordList);
		if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
			return 0;
		}

		// 第 2 步：已经访问过的 word 添加到 visited 哈希表里
		Set<String> visited = new HashSet<>();
		// 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
		Set<String> beginVisited = new HashSet<>();
		beginVisited.add(beginWord);
		Set<String> endVisited = new HashSet<>();
		endVisited.add(endWord);

		// 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
		int step = 1;
		while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
			// 优先选择小的哈希表进行扩散，考虑到的情况更少
			if (beginVisited.size() > endVisited.size()) {
				Set<String> temp = beginVisited;
				beginVisited = endVisited;
				endVisited = temp;
			}

			// 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
			Set<String> nextLevelVisited = new HashSet<>();
			for (String word : beginVisited) {
				if (changeWordEveryOneLetter3(word, endVisited, visited, wordSet, nextLevelVisited)) {
					return step + 1;
				}
			}

			// 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
			beginVisited = nextLevelVisited;
			step++;
		}
		return 0;
	}


	/**
	 * 尝试对 word 修改每一个字符，看看是不是能落在 endVisited 中，扩展得到的新的 word 添加到 nextLevelVisited 里
	 *
	 * @param word
	 * @param endVisited
	 * @param visited
	 * @param wordSet
	 * @param nextLevelVisited
	 * @return
	 */
	private boolean changeWordEveryOneLetter3(String word, Set<String> endVisited,
											 Set<String> visited,
											 Set<String> wordSet,
											 Set<String> nextLevelVisited) {
		char[] charArray = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			char originChar = charArray[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (originChar == c) {
					continue;
				}
				charArray[i] = c;
				String nextWord = String.valueOf(charArray);
				if (wordSet.contains(nextWord)) {
					if (endVisited.contains(nextWord)) {
						return true;
					}
					if (!visited.contains(nextWord)) {
						nextLevelVisited.add(nextWord);
						visited.add(nextWord);
					}
				}
			}
			// 恢复，下次再用
			charArray[i] = originChar;
		}
		return false;
	}

}
