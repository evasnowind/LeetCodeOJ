package solution.leetcode.lc_37_solve_sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/15
 */
public class Solution {

    /**
     * 统计当前每行数字出现的情况
     * row[i][digit] 表示第i行中，数字（digit+1）是否出现过
     */
    private boolean[][] row = new boolean[9][9];
    /**
     * 统计当前每列数字出现的情况
     * column[i][digit] 表示第i列中，数字（digit+1）是否出现过
     */
    private boolean[][] column = new boolean[9][9];
    /**
     * 使用该数组记录3x3的区域内，1-9的数字是否出现过一次。
     * 比较巧妙的地方是：block下标全部采用 i / 3, j / 3，下取整的方式。
     * 这样就可以利用 3x3x9的矩阵，表示一个9x9矩阵中、共计9个小数独的数字出现情况。
     * 因为使用除以3下取整时，必然会时i/j落在3x3的范围内，且一个小数独内[i/3, j/3]的
     * 结果必然是一个元素，比如i=0,1,2, i/3都等于0；j=0,1,2，j/3都等于0，于是[i,j]=[[0,2], [0,2]]
     * 只对应[0,0]，再利用block第3列，即可用于判断一个小数独内是否数字只出现了一次。
     *
     * 小疑问：感觉好像只利用这个block就可以得出一个小数独矩阵内数字唯一，是否row/column数组就没必要了？
     * 还没深入想，不确定
     */
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] ==  '.') {
                    spaces.add(new int[] {i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    row[i][digit] = true;
                    column[j][digit] = true;
                    block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!row[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                row[i][digit] = true;
                column[j][digit] = true;
                block[i / 3][j / 3][digit] = true;
                board[i][j] = (char)(digit + '0' + 1);
                dfs(board, pos + 1);
                row[i][digit] = false;
                column[j][digit] = false;
                block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
