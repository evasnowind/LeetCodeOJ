package solution.lc_289_game_of_life;

/**
 *
 * @author chenglong.yu
 * created on 2020/4/2
 */
public class Solution {

    /**
     * 题目相对简单，模拟过程的题目，不过本题的代码抄自
     * https://leetcode-cn.com/problems/game-of-life/solution/
     * 思路很清晰，不过答案里判断当前细胞周边的细胞数量，思路没太
     * 看明白，懒得一步步推演了，直接拿来主义
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        int[][] copyBoard = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, board[i].length);
        }

        int[] neighbors = {0, 1, -1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int livingCellCnt = 0;

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < columns && c >= 0) && (copyBoard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // 规则 1 或规则 3
                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 0;
                }
                // 规则 4
                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 1;
                }

            }
        }
    }

}
