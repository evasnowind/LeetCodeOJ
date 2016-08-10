package oj_test.oj_54_spiral_matrix;

import oj_solution.oj_54_spiral_matrix.Solution;

public class TestOJ54 {

	public static void main(String[] args) {
//		int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//		int[][] a = new int[][]{{1,2},{3,4}};
//		int[][] a = new int[][]{{1,2,3},{4,5,6}};
//		int[][] a = new int[][]{{1,2},{3,4},{5,6}};
		int[][] a = new int[][]{{1,2}};
		
		Solution s = new Solution();
		s.spiralOrder(a);
	}

}
