package solution.oj_200_island_num;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenglong.yu@100credit.com
 * created on 2020/4/20
 */
public class Solution {

    /**
     * 深度优先/广度优先都可以做到。
     * 此处用广度优先
     *
     * 参见 https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int islandNum = 0;

        for (int r = 0; r < nr; r++) {
            for(int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    islandNum += 1;
                    grid[r][c] = '0';
                    Queue<Integer> toVisitQueue = new LinkedList<>();
                    toVisitQueue.add(r * nc + c);
                    while (!toVisitQueue.isEmpty()) {
                        int curPosition = toVisitQueue.poll();
                        int row = curPosition / nc;
                        int col = curPosition % nc;
                        visitNeighbor(grid, row, col, nr, nc, toVisitQueue);
                    }
                }
            }
        }

        return islandNum;
    }

    private void visitNeighbor(char[][] grid, int row, int col, int nr, int nc, Queue<Integer> toVisitQueue) {
        if (row - 1 >= 0 && grid[row-1][col] == '1') {
            grid[row - 1][col] = '0';
            toVisitQueue.add((row-1) * nc + col);
        }
        if (row + 1 < nr && grid[row+1][col] == '1') {
            grid[row+1][col] = '0';
            toVisitQueue.add((row+1) * nc + col);
        }
        if (col - 1 >= 0 && grid[row][col-1]== '1') {
            grid[row][col-1] = '0';
            toVisitQueue.add(row * nc + col - 1);
        }
        if (col + 1 < nc && grid[row][col+1] == '1') {
            grid[row][col+1] = '0';
            toVisitQueue.add(row * nc + col + 1);
        }
    }


}
