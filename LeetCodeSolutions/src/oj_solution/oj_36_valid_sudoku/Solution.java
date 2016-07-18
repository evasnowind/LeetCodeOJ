package oj_solution.oj_36_valid_sudoku;

public class Solution {
	/*
	 * 参考了http://blog.csdn.net/linhuanmars/article/details/20748171 
	 * 注意题目的意思其实就是验证一下表格中已有的数组是否满足数独规则，
	 * 因此就是一个遍历操作，去挨个验证横、竖、整个方块是否有效
	 */
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;
		for (int i = 0; i < 9; i++) {
			boolean[] map = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (map[(int) (board[i][j] - '1')]) {
						return false;
					}
					map[(int) (board[i][j] - '1')] = true;
				}
			}
		}
		for (int j = 0; j < 9; j++) {
			boolean[] map = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (map[(int) (board[i][j] - '1')]) {
						return false;
					}
					map[(int) (board[i][j] - '1')] = true;
				}
			}
		}
		/*
		 * 一般矩阵的运算都可以参考这里的写法：用索引号、行、列算出具体坐标
		 */
		for (int block = 0; block < 9; block++) {
			boolean[] map = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						if (map[(int) (board[i][j] - '1')]) {
							return false;
						}
						map[(int) (board[i][j] - '1')] = true;
					}
				}
			}
		}
		return true;
	}
}
