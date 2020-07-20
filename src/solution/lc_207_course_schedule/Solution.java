package solution.lc_207_course_schedule;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	/*
	 * 分析：典型的拓扑图，判断图中是否有环，可以采用Kahn算法，算法如下
		
		L ← Empty list that will contain the sorted elements
		S ← Set of all nodes with no incoming edges
		while S is non-empty do
		    remove a node n from S
		    add n to tail of L
		    for each node m with an edge e from n to m do
		        remove edge e from the graph
		        if m has no other incoming edges then
		            insert m into S
		if graph has edges then
		    return error (graph has at least one cycle)
		else 
		    return L (a topologically sorted order)
	
	 * 引自：https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
	 * 
	 * 此处需要先将输入转换成常用的邻接矩阵，所有节点的入度用一个数组记录，然后用上述算法即可
	 * 
	 * 具体实现参考了https://discuss.leetcode.com/topic/13854/easy-bfs-topological-sort-java/2
	 * 
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
		int[] indegrees = new int[numCourses];
		for(int i = 0; i < prerequisites.length; i++){
			int cur = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if(matrix[pre][cur] == 0){
				indegrees[cur] += 1;
			}
			matrix[pre][cur] = 1;
		}
		int count = 0; 
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < numCourses; i++){
			if(indegrees[i] == 0) {
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()){
			int course = queue.poll();
			count++;
			for(int i = 0; i < numCourses; i++){
				if(matrix[course][i] != 0){
					indegrees[i] -= 1;
					if(indegrees[i] == 0){
						queue.offer(i);
					}
				}
			}
		}
		return count == numCourses;
    }
}
