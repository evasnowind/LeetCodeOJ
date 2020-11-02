package solution.leetcode.lc_463_island_perimeter;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/10/30
 */
public class Solution {


    private static final int[] xStep = new int[]{0, 0, 1, -1};
    private static final int[] yStep = new int[]{1, -1, 0, 0};

    public int islandPerimeter(int[][] grid) {
        /*
        下面islandPerimeter2使用BFS，思路没问题，但有遇到数据量较大时，会有超时的问题。
        原因在于BFS多出很多无用计算。
        对于本题而言，我们只需要计算岛屿即可，不用遍历整个地图，因此用深度遍历更合适，
        可以减少大量计算。
         */

        int rowLen = grid.length, colLen = grid[0].length;
        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    /*
                    注意，我们已经找到了岛屿的一个位置，只要从这个起点开始遍历，
                    当遍历超过地图，或是发现当前点已经不再是岛屿范围（grid[x][y]=0），
                    那说明dfs发现了一条边界，计数加1。
                    此外，这种DFS的解法实际上也能适用于多个岛屿的情况。
                    */
                    res = res + dfs(i, j, grid, rowLen, colLen);
                }
            }
        }
        return res;
    }

    private int dfs(int x, int y, int[][] grid, int rowLen, int colLen) {
        if (x < 0 || x >= rowLen || y < 0 || y >= colLen || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            //利用原数组作为visited数组，=2表示已遍历过
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int tx = x + xStep[i];
            int ty = y + yStep[i];
            res = res + dfs(tx, ty, grid, rowLen, colLen);
        }
        return res;
    }


    public int islandPerimeter2(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;
        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    /*
                    当前已经是岛屿的前提下，找到地图边界，或是
                    发现已经走出岛屿，则说明找到一条边。
                    */
                    int cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int tx = i + xStep[k];
                        int ty = j + yStep[k];
                        if (tx < 0 || tx >= rowLen
                                || ty < 0 || ty >= colLen
                                || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    res += cnt;
                }
            }
        }
        return res;
    }

    /**
     * 下面解法应该是有问题（至少效率比较低），懒得深究了。。。
     *
     * @param grid
     * @return
     */
    public int islandPerimeter3(int[][] grid) {
        //输入数据已约束>0，不用判空处理

        /*
        典型的图遍历问题。而图的遍历，常用的就是BFS DFS两种。
        此处选用BFS。
        遍历时，
        0、若已遍历过(visited=true)，则跳过
        1、检查一个网格周边的节点数量
            若是1，则表明属于岛屿，需要计算该节点贡献的周长：
                1.1 若上下左右4个节点都不属于岛，则4个边都计入；
                1.2 若上下左右4个节点中有1个属于岛（=1），则3个边计入；
                1.3 若上下左右4个节点中有2个属于岛（=1），则2个边计入；
                1.4 若上下左右4个节点中有3个属于岛（=1），则1个边计入；
                1.5 若上下左右4个节点中有4个属于岛（=1），则0个边计入；
            若是0，则标记visited，将周边节点加入队列，继续下次遍历过程即可
         */
        
        int[] xStep = new int[]{0, 0, 1, -1};
        int[] yStep = new int[]{1, -1, 0, 0};

        int rowNum = grid.length, colNum = grid[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            Arrays.fill(visited[i], false);
        }

        int res = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (visited[cur[0]][cur[1]]) {
                for (int i = 0; i < 4; i++) {
                    int nextX = cur[0] + xStep[i];
                    int nextY = cur[1] + yStep[i];
                    if (nextX < 0 || nextY < 0 || nextX >= rowNum || nextY >= colNum) {
                        continue;
                    } else {
                        if (!visited[nextX][nextY]) {
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            } else {
                //需要判断多少周长
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nextX = cur[0] + xStep[i];
                    int nextY = cur[1] + yStep[i];
                    if (nextX < 0 || nextY < 0 || nextX >= rowNum || nextY >= colNum) {
                        continue;
                    } else {
                        if (1 == grid[nextX][nextY]) {
                            cnt++;
                        }

                        if (!visited[nextX][nextY]) {
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
                visited[cur[0]][cur[1]] = true;
                if (1 == grid[cur[0]][cur[1]]) {
                    res = res + (4 - cnt);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };

        Solution s = new Solution();
        s.islandPerimeter(matrix);
    }

}
