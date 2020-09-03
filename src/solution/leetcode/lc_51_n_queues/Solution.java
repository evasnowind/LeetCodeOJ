package solution.leetcode.lc_51_n_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/3
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0, res);
        return res;
    }

    private void backtrack(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            //如果有解，则保存
            res.add(createRes(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, res);
                board[row][col] = '.';
            }
        }
    }
    

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            //同一列
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //左上方向
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //右上方向
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> createRes(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solveNQueens(4);
    }
}
