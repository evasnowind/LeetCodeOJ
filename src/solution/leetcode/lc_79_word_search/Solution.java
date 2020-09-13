package solution.leetcode.lc_79_word_search;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/9/13
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        char[] wordChs = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }

        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, i, j, wordChs, 0, visited)) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    private static final int[] stepX = new int[]{0, 0, 1, -1};
    private static final int[] stepY = new int[]{1, -1, 0, 0};
    private boolean backtrack(char[][] board, int x, int y, char[] word, int wordIdx, boolean[][] visited) {
        if (wordIdx == word.length - 1) {
            /*
            注意此处不能直接用wordIdx== word.length来判断。
            因为board中只有一个元素时，将导致无法正确判断，
            需要通过判断最后一个元素也比较完，才能说明都比较了
             */
            return board[x][y] == word[wordIdx];
        }

        boolean res = false;
        if (board[x][y] == word[wordIdx] && !visited[x][y]) {
            /*
            1. 注意回溯时使用数组记录当前遍历状态，且注意如果退回需要恢复状态，避免重复
            2. 使用数组来实现利用循环、往4个方向走的小技巧
             */
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + stepX[i];
                int newY = y + stepY[i];
                if (isInBoard(board, newX, newY) && !visited[newX][newY]) {
                    res = backtrack(board, newX, newY, word, wordIdx + 1, visited);
                    if (res) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return res;
    }

    private boolean isInBoard(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        Solution s = new Solution();
        boolean res = s.exist(board, "ABCCE");
        System.out.println(res);
        res = s.exist(board, "SEE");
        System.out.println(res);
        res = s.exist(board, "ABCB");
        System.out.println(res);

        board = new char[][] {{'a'}};
        boolean res2 = s.exist(board, "a");
        System.out.println(res2);
    }
}
